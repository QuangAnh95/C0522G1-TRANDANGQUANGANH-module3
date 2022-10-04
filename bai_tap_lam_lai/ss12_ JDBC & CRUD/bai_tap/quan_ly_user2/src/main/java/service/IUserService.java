package service;

import model.User;

import java.util.List;

public interface IUserService {
    List<User> list ();
    void save(User user);
    void delete(int id);
    User findById(int id);
    public boolean updateUser(User user);
}
