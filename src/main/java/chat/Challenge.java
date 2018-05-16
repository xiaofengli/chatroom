package chat;
import chat.data.EmployeeDAO;
import chat.model.Employee;
import chat.ws.EmployeesResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.hibernate.*;

public class Challenge extends Application<ChallengeConfiguration> {
  
	private final HibernateBundle<ChallengeConfiguration> hibernate = 
		new HibernateBundle<ChallengeConfiguration>(  Employee.class) {
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
		 
		 
    }


    
    public static void main(String[] args) throws Exception {
        new Challenge().run(args);
    }
}

