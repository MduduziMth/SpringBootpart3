package springbootapp.services;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import springbootapp.Interface.FakeRepo;
import springbootapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private static FakeRepo fakeRepo;


    private User user;


    @Override
    public String addUser(long id, String name, String surname){
        fakeRepo = new FakeRepo();
        fakeRepo.insertUser(id,name,surname);
        return name + " entered";
    }
    @Override
    public String removeUser(long Id){
        fakeRepo = new FakeRepo();
        return  fakeRepo.deleteUser(Id) + " removed";

    }
    @Override
    @Cacheable("User")
    public String getUser(long Id){
        fakeRepo = new FakeRepo();
        user = fakeRepo.findUserById(Id);

        try
        {
            System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
            Thread.sleep(1000*5);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        return "hello " + user.getName();

    }
}
