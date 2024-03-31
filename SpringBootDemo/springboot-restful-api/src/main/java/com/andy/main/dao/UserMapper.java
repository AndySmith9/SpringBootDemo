package com.andy.main.dao;

import java.util.List;

import com.andy.main.pojo.User;

public interface UserMapper {
public List<User> getUsers();
public User getUserByName(String name);
public void insertUser(User user);
public void updateUser(User user);
public void deleteUser(User user);
}
