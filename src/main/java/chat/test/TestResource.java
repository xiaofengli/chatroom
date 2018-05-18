package chat.test;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.skife.jdbi.v2.DBI;
/*
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class UserResourceTest {

    private static final PeopleStore dao = mock(PeopleStore.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new PersonResource(dao))
            .build();

    private final Person person = new Person("blah", "blah@example.com");

    @Before
    public void setup() {
        when(dao.fetchPerson(eq("blah"))).thenReturn(person);
    }

    @After
    public void tearDown(){
        // we have to reset the mock after each test because of the
        // @ClassRule, or use a @Rule as mentioned below.
        reset(dao);
    }

    @Test
    public void testGetPerson() {
        assertThat(resources.target("/person/blah").request().get(Person.class))
                .isEqualTo(person);
        verify(dao).fetchPerson("blah");
    }
}
*/