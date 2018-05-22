import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class UserResourceTest {

    private static final UserDAO dao = mock(EmployeeDAO.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new UserResource(dao))
            .build();

    private final User user = new User("hanfei","deng","mao","zedong");

    @Before
    public void setup() {
        when(dao.findByName(eq("hanfei"))).thenReturn(user);
    }

    @After
    public void tearDown(){
        // we have to reset the mock after each test because of the
        // @ClassRule, or use a @Rule as mentioned below.
        reset(dao);
    }

    @Test
    public void testGetPerson() {
        assertThat(resources.target("/person/hanfei").request().get(User.class))
                .isEqualTo(user);
        verify(dao).findByName("hanfei");
    }
}