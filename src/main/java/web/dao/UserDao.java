package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    User read(long id);

    void update(long id, User user);
    List<User> listUsers();

}