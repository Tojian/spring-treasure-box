package com.taojian.mongodb;



public interface UserRepository {

    User findByUsername(String username);

    public void saveUser(User user);

    public int updateUser(User user);

    public void deleteUserById(Long id);
}