import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {

        final String user = "postgres";
        final String password = "24082";
        final String url = "jdbc:postgresql://localhost:5432/skypro";
        final String REQUEST = "SELECT * FROM employee INNER JOIN city ON employee.city_id=city.city_id WHERE id = (?)";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement = connection.prepareStatement(REQUEST);

            statement.setInt(1, 2);
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String lastNameOfEmployee = "Lastname " + resultSet.getString("last_name");
                String firstnameOfEmployee = "Firstname " + resultSet.getString("first_name");
                String genderOfEmployee = "Gender " + resultSet.getString("gender");
                String ageOfEmployee = "Age " + resultSet.getString("age");
                String cityOfEmployee = "City " + resultSet.getString("city_name");
                System.out.println(lastNameOfEmployee);
                System.out.println(firstnameOfEmployee);
                System.out.println(genderOfEmployee);
                System.out.println(ageOfEmployee);
                System.out.println(cityOfEmployee);


                EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);
                System.out.println(employeeDAO.readById(4));
                //for (Employee empl : employeeDAO.readAll()) {
                // System.out.println(empl);
                // }
                employeeDAO.changingAnObjectById(1, "Svetlana");
                System.out.println(employeeDAO.readById(1));
                employeeDAO.deleteById(9);


                Employee newPersonal = new Employee("Egor", "Dudkin", "male", 56,
                        new City(4, "Kirov"));
                employeeDAO.create(newPersonal);
                List<Employee> list = new ArrayList<>(employeeDAO.readAll());
                for (Employee employee : list) {
                    System.out.println(employee);
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}














