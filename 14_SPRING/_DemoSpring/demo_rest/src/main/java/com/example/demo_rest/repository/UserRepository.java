package com.example.demo_rest.repository;


import com.example.demo_rest.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Integer>   {
    User findUserByEmail(String email);
}
