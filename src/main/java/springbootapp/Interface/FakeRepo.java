package springbootapp.Interface;

import springbootapp.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class FakeRepo implements FakeRepoInterface {

    static  ArrayList<User> userArray = new ArrayList<>();


    @Override
    public void insertUser(long id, String name, String surname) {
        User user = new User(id,name,surname);
        userArray.add(user);

    }


    @Override
    public User findUserById(long id) {

        for (User user: userArray) {
            long userId = id;
            if(userId == id)
            return user;

        }

        return null;

    }

    @Override
    public String deleteUser(long id) {

        for (User user:userArray) {

            long userId = id;
            if(userId == id)
                userArray.remove(user);
                return user.getName();
        }

        return "user was not found";
    }
}
