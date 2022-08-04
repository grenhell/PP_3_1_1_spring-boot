package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    private static int usersCount = 0;
    List <User> userList = new ArrayList<>();

    {
        User u1 = new User("User1", "Lastname1", "user1@mail.ru");
        usersCount++;
        u1.setId(1);
        User u2 = new User("User2", "Lastname2", "user2@mail.ru");
        usersCount++;
        u1.setId(2);
        User u3 = new User("User3", "Lastname3", "user3@mail.ru");
        usersCount++;
        u1.setId(3);
        User u4 = new User("User4", "Lastname4", "user4@mail.ru");
        usersCount++;
        u1.setId(4);
        User u5 = new User("User5", "Lastname5", "user5@mail.ru");
        usersCount++;
        u1.setId(5);
        userList.add(u1);
        userList.add(u2);
        userList.add(u3);
        userList.add(u4);
        userList.add(u5);

    }

//    @Autowired
//    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        user.setId(++usersCount);
        userList.add(user);

        //sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public User read(long id) {
        return userList.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    @Override
    public void update(long id, User user) {
        User upUser = read(id);
        upUser.setFirstName(user.getFirstName());
        upUser.setLastName(user.getLastName());
        upUser.setEmail(user.getEmail());

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return userList;
//        TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
//        return query.getResultList();
    }



}