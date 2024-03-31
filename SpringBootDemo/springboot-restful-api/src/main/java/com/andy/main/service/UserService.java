package com.andy.main.service;



import com.andy.main.common.JsonData;
import com.andy.main.pojo.User;

public interface UserService {
	public JsonData getUsers();
	public JsonData getUserByName(String name);
	public JsonData insertUser(User user);
	public JsonData updateUser(User user);
	public JsonData deleteUser(String name);
}
