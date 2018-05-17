package chat.data;

import java.util.List;
import java.util.Optional;
import org.hibernate.SessionFactory;
import chat.model.Employee;
import chat.model.User;
import io.dropwizard.hibernate.AbstractDAO;

// https://dzone.com/articles/getting-started-with-dropwizard-connecting-to-a-da
	
public class UserDAO extends AbstractDAO<User> {
    /**
     * Constructor.
     *
     * @param sessionFactory Hibernate session factory.
     */
    public UserDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    /**
     * Method returns all employees stored in the database.
     *
     * @return list of all employees stored in the database
     */
    public List<User> findAll() {
        return list(namedQuery("chat.model.User.findAll"));
    }
    /**
     * Looks for employees whose first or last name contains the passed
     * parameter as a substring.
     *
     * @param name query parameter
     * @return list of employees whose first or last name contains the passed
     * parameter as a substring.
     */
    public List<User> findByName(String name) {
        StringBuilder builder = new StringBuilder("%");
        builder.append(name).append("%");
        return list(
                namedQuery("chat.model.User.findByName")
                .setParameter("name", builder.toString())
        );
    }
    /**
     * Method looks for an employee by her id.
     *
     * @param id the id of an employee we are looking for.
     * @return Optional containing the found employee or an empty Optional
     * otherwise.
     */
    public Optional<User> findById(long id) {
        return Optional.ofNullable(get(id));
    }

    
}