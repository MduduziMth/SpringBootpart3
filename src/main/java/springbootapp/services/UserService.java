package springbootapp.services;

public interface UserService {

   String addUser(long id,String name, String surname);
   String removeUser(long Id);
   String getUser(long Id);
}
