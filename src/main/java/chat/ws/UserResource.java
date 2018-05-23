package chat.ws;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.sql.*;
import chat.data.EmployeeDAO;
import chat.data.UserDAO;
import chat.model.Employee;
import chat.model.User;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    /**
     * The DAO object to manipulate employees.
     */
    private UserDAO userDAO;
    /**
     * Constructor.
     *
     * @param userDAO DAO object to manipulate employees.
     */
    public UserResource(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    /**
     * Looks for employees whose first or last name contains the passed
     * parameter as a substring. If name argument was not passed, returns all
     * employees stored in the database.
     *
     * @param name query parameter
     * @return list of employees whose first or last name contains the passed
     * parameter as a substring or list of all employees stored in the database.
     */
    @GET
    @UnitOfWork
    public List<User> findByName(
            @QueryParam("name") Optional<String> name
    ) {
        if (name.isPresent()) {
            return userDAO.findByName(name.get());
        } else {
            return userDAO.findAll();
        }
    }
    /**
     * Method looks for an employee by her id.
     *
     * @param id the id of an employee we are looking for.
     * @return Optional containing the found employee or an empty Optional
     * otherwise.
     */
    @GET
    @Path("/{id}")
    @UnitOfWork
    public Optional<User> findById(@PathParam("id") LongParam id) {
        return userDAO.findById(id.get());
        
    }
    
    
    
    @POST
    @UnitOfWork
    public User add(@Valid User user) {
    	User biguser=new User("hanfei","deng","mao","zedong","hello","hello");
        User newUser = userDAO.insert(biguser);

        return newUser;
    }
}
