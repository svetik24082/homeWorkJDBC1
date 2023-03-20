import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        CityDAO cityDAO = new CityDAOImpl();

        City newCity = new City(9, "Ufa");
        //cityDAO.create(newCity);
        //viewAllCities(cityDAO);
        for (City c : cityDAO.readAll()) {
            System.out.println(c);

        }
        City updatedCity = cityDAO.readById(5);
        updatedCity.setCityName("Zvenigorod");
        cityDAO.update(updatedCity);
        viewAllCities(cityDAO);


        Employee newPersonal = new Employee("Slava", "Antonov", "female", 34, new City("Zlatoust"));
        employeeDAO.create(newPersonal);
        viewAllEmployees(employeeDAO);
        viewAllCities(cityDAO);


        cityDAO.delete(cityDAO.readById(5));
        viewAllCities(cityDAO);
        viewAllEmployees(employeeDAO);

    }



    private static void viewAllCities(CityDAO cityDAO) {
        for (City c : cityDAO.readAll()) {
            System.out.println(c);
        }
    }

    private static void viewAllEmployees(EmployeeDAO employeeDAO) {
        for (Employee e : employeeDAO.readAll()) {
            System.out.println(e);


        }

    }
}
















