package springbootapp.Interface;

import springbootapp.model.User;

public interface FakeRepoInterface  {

    void insertUser(long id, String name, String surname);

    User findUserById(long Id);

    String deleteUser(long id);


}
