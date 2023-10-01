package com.userapi.userapi;
import javax.ejb.*;
import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import java.util.List;

@Singleton
public class UserDAO {
    @PersistenceContext
    private EntityManager em;

    public List<User> allUsers(){
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    public User getUser(int id){
        return em.find(User.class, id);
    }

    public int createUser(String firstName, String lastName, String birthday, String email, String password){
        User u = new User();
        u.setFirstName(firstName);
        u.setLastName(lastName);
        u.setBirthday(birthday);
        u.setEmail(email);
        u.setPassword(password);
        em.persist(u);
        em.flush(); //needed to get the id of the new user
        return u.getId();

    }

    public void updateUser(String firstName, String lastName, String birthday, String email, String password, int id){
        User u = em.find(User.class, id);
        u.setFirstName(firstName);
        u.setLastName(lastName);
        u.setBirthday(birthday);
        u.setEmail(email);
        u.setPassword(password);
        em.merge(u);
    }

    public void deleteUser(int id){
        User u = em.find(User.class, id);
        em.remove(u);
    }

}