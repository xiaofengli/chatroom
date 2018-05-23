package chat.ws;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import java.util.Date; 
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import chat.data.MessageDAO;
import chat.model.Message;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
    /**
     * The DAO object to manipulate messages.
     */
    private MessageDAO messageDAO;
    /**
     * Constructor.
     *
     * @param userDAO DAO object to manipulate messages.
     */
    public MessageResource(MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }
    /**
     * Looks for messages whose first or last name contains the passed
     * parameter as a substring. If name argument was not passed, returns all
     * messages stored in the database.
     *
     * @param name query parameter
     * @return list of messages whose first or last name contains the passed
     * parameter as a substring or list of all messages stored in the database.
     */
    @GET
    @UnitOfWork
    public List<Message> findByName(
            @QueryParam("name") Optional<String> name
    ) {
    	System.out.println("I am not here");

        if (name.isPresent()) {
            return messageDAO.findByName(name.get());
        } else {
            return messageDAO.findAll();
        }
    }
    
    /**
     * Looks for messages whose first or last name contains the passed
     * parameter as a substring. If name argument was not passed, returns all
     * messages stored in the database.
     *
     * @param name query parameter
     * @return list of messages whose first or last name contains the passed
     * parameter as a substring or list of all messages stored in the database.
     */
    @GET
    @UnitOfWork
    @Path("/search")
    public List<Message> findByUser(
            @QueryParam("sender") Optional<String> sender,
            @QueryParam("receiver") Optional<String> receiver
    ) { 
    	System.out.println(sender);
        System.out.println(receiver);
        if (sender.isPresent() && receiver.isPresent()) {
        	System.out.println("found the dude");
            return messageDAO.findByUser(sender.get(),receiver.get());
        } else {
        	System.out.println(sender);
            System.out.println(receiver);
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
    @Path("/write")
    @UnitOfWork
    public Message writeMessageToDatabase(@Valid Message message) {
    	message.setLogTime(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()) );
    	System.out.println("I am here");
    //	Message bigmessage=new Message("ohla","ohla","hello","hello",time);
        Message newMessage = messageDAO.insert(message);
        return newMessage;
    }
}
