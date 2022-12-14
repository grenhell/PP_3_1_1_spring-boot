package web.service;

import web.dao.UserDao;
import web.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
    @Transactional
    @Override
    public void delete(long id) {
        userDao.delete(id);

    }

    @Override
    @Transactional(readOnly = true)
    public User read(long id) {
        return userDao.read(id);
    }
    @Transactional
    @Override
    public void update(Long id, User user) {
        userDao.update(id, user);
    }

}