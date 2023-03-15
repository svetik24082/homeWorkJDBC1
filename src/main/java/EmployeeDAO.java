
import java.util.List;


public interface EmployeeDAO {

    void create(Employee employee);
    // доб об/ъекта

    Employee readById(int id); // пол объект по id

    List<Employee> readAll();//пол всех объектов

    void changingAnObjectById(int id, String firstName); //изменение объекта по id

    void deleteById(int id);//удаление по id

}
