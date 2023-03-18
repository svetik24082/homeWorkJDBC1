import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public void create(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory()
                .openSession();) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }


    @Override
    public Employee readById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Employee.class, id);

    }

    @Override

    public List<Employee> readAll() {
        List<Employee> users = (List<Employee>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Employee").list();
        return users;
    }


    @Override
    public void changingAnObjectById(int id, String firstName) {
        Employee employee = readById(id);
        employee.setFirstName(firstName);
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();

        }
    }

    @Override
    public void deleteById(int id) {
        Employee employee = readById(id);
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(id);
            transaction.commit();

        }
    }
}
