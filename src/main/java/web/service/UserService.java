package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    void delete (long id);

    User read (long id);

    void update (Long id, User user);

}