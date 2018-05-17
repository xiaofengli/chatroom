package chat;
import chat.data.EmployeeDAO;
import chat.data.MessageDAO;
import chat.data.UserDAO;
import chat.model.Employee;
import chat.model.Message;
import chat.model.User;
import chat.ws.EmployeesResource;
import chat.ws.MessageResource;
import chat.ws.UserResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.hibernate.*;

public class Challenge extends Application<ChallengeConfiguration> {
  
	private final HibernateBundle<ChallengeConfiguration> hibernate = 
		new HibernateBundle<ChallengeConfiguration>(Employee.class, User.class, Message.class) {
				
			@Override
				public DataSourceFactory getDataSourceFactory(ChallengeConfiguration configuration) {
	    			return configuration.getDataSourceFactory();
				}
	};
	
	@Override
	public void initialize(Bootstrap<ChallengeConfiguration> bootstrap) {
	    bootstrap.addBundle(hibernate);
	}

	
	//http://www.maigfrga.ntweb.co/dropwizard-api-rest-example/
	// https://howtodoinjava.com/dropwizard/tutorial-and-hello-world-example/
	@Override
    public void run(ChallengeConfiguration conf, Environment env) {
	     // This is only for one table
		 final EmployeeDAO employeeDAO = new EmployeeDAO(hibernate.getSessionFactory());
		 env.jersey().register(new EmployeesResource(employeeDAO));

		 final UserDAO userDAO = new UserDAO(hibernate.getSessionFactory());
		 env.jersey().register(new UserResource(userDAO));
		 
		 final MessageDAO messageDAO = new MessageDAO(hibernate.getSessionFactory());
		 env.jersey().register(new MessageResource(messageDAO));
		 
		 
		 
    }


    
    public static void main(String[] args) throws Exception {
        new Challenge().run(args);
    }
}

