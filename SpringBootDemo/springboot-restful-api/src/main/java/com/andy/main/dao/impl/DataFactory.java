package com.andy.main.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.andy.main.pojo.User;

public class DataFactory {
	private static List<User> list;
	static {
		list = new ArrayList<User>();
		User user;
		for (int i = 0; i < 10; i++) {
			user = new User();
			user.setAge(20 + i);
			user.setName("Andy" + i);
			list.add(user);
		}
	}

	public static List<User> getUserList() {
		return list;
	}

}
