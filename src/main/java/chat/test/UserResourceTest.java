package chat.test;

import chat.data.UserDAO;
import chat.model.User;
import chat.ws.UserResource;

import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import static org.mockito.Mockito.*;

import static org.assertj.core.api.Assertions.assertThat;

import io.dropwizard.testing.junit.ResourceTestRule;

public class UserResourceTest {

    private static final UserDAO dao = mock(UserDAO.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new UserResource(dao))
            .build();

    private final User user = new User("blah@example.com", "$pa%%word",null, null,null,null);

    @Before
    public void setup() {
        when(dao.findByName(eq("blah@example.com")).get(0)).thenReturn(user);
    }

 
    //Test Endpoint
    @Test
    public void testGetPerson() {
        assertThat(resources.target("/users").request().get(User.class))
                .isEqualTo(user);
        verify(dao).findByName("blah@example.com");
    }
    
    
    @After
    public void tearDown(){
        // we have to reset the mock after each test because of the
        // @ClassRule, or use a @Rule as mentioned below.
        reset(dao);
    }
}


