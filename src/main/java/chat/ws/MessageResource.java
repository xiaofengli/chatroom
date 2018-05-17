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


import chat.data.MessageDAO;


import chat.model.Message;
import chat.model.User;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
    /**
     * The DAO object to manipulate employees.
     */
    private MessageDAO messageDAO;
    /**
     * Constructor.
     *
     * @param userDAO DAO object to manipulate employees.
     */
    public MessageResource(MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
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
    public List<Message> findByName(
            @QueryParam("name") Optional<String> name
    ) {
        if (name.isPresent()) {
            return messageDAO.findByName(name.get());
        } else {
            return messageDAO.findAll();
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
    public Optional<Message> findById(@PathParam("id") LongParam id) {
        return messageDAO.findById(id.get());
        
    }
    
    @POST
    @UnitOfWork
    public Message add(@Valid Message message) {
    	Message bigmessage =new Message("hello", "helli", "string", "ohla");
        Message newMessage = messageDAO.insert(bigmessage);

        return newMessage;
    }
}