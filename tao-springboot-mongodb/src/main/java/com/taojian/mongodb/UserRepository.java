package com.taojian.mongodb;


import org.springframework.stereotype.Component;


public interface UserRepository {

    User findByUsername(String username);

    public void saveUser(User user);

    public void updateUser(User user);

    public void deleteUserById(Long id);
}