package com.example.tp1spring.service.impl;


import com.example.tp1spring.entity.User;
import com.example.tp1spring.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements com.example.tp1spring.service.IUserService{
//
//    @Autowired
//    private ServiceHibernate serviceHibernate;
//    private final Session session;
//
//    public UserServiceImpl(ServiceHibernate serviceHibernate) {
//        this.serviceHibernate = serviceHibernate;
//        session = this.serviceHibernate.getSession();
//    }


private UserRepository _userRepository;

public UserServiceImpl(UserRepository userRepository) {
    _userRepository = userRepository;
}


    @Override
    public boolean create(User u) {
//        session.beginTransaction();
//        session.save(u);
//        session.getTransaction().commit();
        _userRepository.save(u);
        return  u.getId() > 0;
    }

    @Override
    public boolean update(User u) {
_userRepository.save(u);
        return true;    }

    @Override
    public boolean delete(User u) {
//        session.beginTransaction();
//        session.delete(u);
//        session.getTransaction().commit();
        _userRepository.delete(u);
        return true;
    }

    @Override
    public User findById(int id) {
//        User user = null;
//        user = session.get(User.class, id);
//        return user;
    _userRepository.findById(id).get();
    return _userRepository.findById(id).get();
}

    @Override
    public List<User> findAll() {
//        Query<User> userQuery = session.createQuery("from User");
//        return userQuery.getResultList();
        return (List<User>) _userRepository.findAll();
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
//        Query<User> userQuery = session.createQuery("from User where username = :username and password = :password");
//        userQuery.setParameter("username", username);
//        userQuery.setParameter("password", password);
//        return userQuery.getSingleResult();

        return _userRepository.findByUsernameAndPassword(username, password);

    }


}
