package springbootapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import springbootapp.model.User;
import springbootapp.services.UserService;

@RestController
@RequestMapping("api/")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("getUser/{id}")
    public String getUser(@PathVariable long id)
    {
        return userService.getUser(id);

    }

    @DeleteMapping("delete/{id}")
    public String deleteUser(@PathVariable long id)
    {
        return userService.removeUser(id);
    }

    @PostMapping("addUser/")
    public String addUser(@RequestBody User user)
    {
        return userService.addUser(user.getId(),user.getName(),user.getSurname());
    }



}
