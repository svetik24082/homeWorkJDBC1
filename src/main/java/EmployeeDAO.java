
import java.util.List;


public interface EmployeeDAO {

    void create(Employee employee);
    // доб об/ъекта

    Employee readById(int id); // пол объект по id

    List<Employee> readAll();//пол всех объектов

    void update(Employee employee); //изменение объекта

    void delete(Employee employee);//удаление

}
