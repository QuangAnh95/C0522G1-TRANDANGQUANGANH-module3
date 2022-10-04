package service.impl;

import model.User;
import repository.IUserRepository;
import repository.impl.UserRepository;
import service.IUserService;

import java.util.List;

public class UserService implements IUserService {
    private IUserRepository userRepository = new UserRepository();

    @Override
    public List<User> list() {
        return userRepository.list();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);

    }

    @Override
    public void delete(int id) {
        userRepository.delete(id);

    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public boolean updateUser(User user) {
        return userRepository.updateUser(user);
    }
}
