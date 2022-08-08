package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
//    List <User> userList = new ArrayList<>();

    public  UserDaoImp (){

    }
    @PersistenceContext
    @Autowired
    private EntityManager em;


    @Override
    public List<User> listUsers() {
        return em.createQuery("from User", User.class).getResultList();

    }
    @Override
    public void add(User user) {
        em.persist(user);
    }

    @Override
    public User read(long id) {
        return em.find(User.class, id);
    }

    @Override
    public void update(long id, User user) {
        em.merge(user);
    }

    @Override
    public void delete(long id) {
        em.remove(read(id));
    }





}