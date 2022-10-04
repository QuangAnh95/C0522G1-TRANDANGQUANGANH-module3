package service.impl;

import model.User;
import repository.IUserRepository;
import repository.impl.UserRepository;
import service.IUserSevice;

import java.util.List;

public class UserService  implements IUserSevice {
    IUserRepository repository = new UserRepository();

    @Override
    public void insertUser(User user) {
        repository.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return repository.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return repository.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) {
        return repository.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) {
        return repository.updateUser(user);
    }
}
