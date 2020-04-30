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


    @Autowired
    UserServiceImpl userService = new UserServiceImpl();



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



}