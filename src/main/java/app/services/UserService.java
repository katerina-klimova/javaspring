package app.services;

import app.entities.User;
import app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsersServ(){
        return userRepo.getAllUsers();
    }

    public User getUserByLogin(String login) {
        return userRepo.getUserByLogin(login);
    }

    public void addUser(String login, String password, String name, String role){
        userRepo.addUser(login,password,name,role);
    }
}
