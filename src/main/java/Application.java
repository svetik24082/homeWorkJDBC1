import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        Employee employee1 = new Employee("Ivanov", " Ivan", " male", 67, 2);
        employeeDAO.create(employee1);

        System.out.println(employeeDAO.readById(3));

        List<Employee> list = employeeDAO.readAll();
        for (Employee employee : list) {
            System.out.println(employee);

        }
        Employee employee2 = new Employee("Semen", "Razin", "male", 43, 1);
        employeeDAO.changingAnObjectById(2, "Frolov");
        employeeDAO.deleteById(4);

    }

}














