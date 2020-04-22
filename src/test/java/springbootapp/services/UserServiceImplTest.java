package springbootapp.services;


import org.apache.coyote.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserServiceImplTest {


    @LocalServerPort
    private int port;

    UserServiceImpl userService = new UserServiceImpl();

    @Autowired
    private TestRestTemplate template ;

    private URL base;

    @BeforeEach
    public void urlLink()throws Exception{
        this.base=new URL("http://localhost:"+port);
    }


    @Test
    void addUser() {
        assertEquals("Mdu entered", userService.addUser(1,"Mdu","Mthethwa"));
    }
    @Test
    void removeUser() {
        userService.addUser(2,"Jurgen","Klopp");
        assertEquals("Jurgen removed",userService.removeUser(2));

    }

    @Test
    void getUser() {
        userService.addUser(3,"Putin","Vladmir");
        assertEquals("hello Putin",userService.getUser(3));
    }

    @Test
    void getUserTest()
    {
        userService.addUser(1,"Putin","Vladmir");

        String name = "";
        for (int i = 0; i < 3; i++) {

            name += "\n" + userService.getUser(1);

        }


    }

    @Test
    void WebConfigTest() throws Exception{
        ResponseEntity<String> response = template.withBasicAuth("Mdu","Secret@123").getForEntity(base.toString(),String.class);

    }
}