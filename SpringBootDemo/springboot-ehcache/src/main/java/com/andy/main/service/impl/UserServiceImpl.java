package com.andy.main.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.andy.main.common.JsonData;
import com.andy.main.dao.UserMapper;
import com.andy.main.pojo.User;
import com.andy.main.service.UserService;

@Service
@CacheConfig(cacheNames="user_cache")
public class UserServiceImpl implements UserService {
private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserMapper userMapper;

	
	@Override
	public JsonData getUsers() {
		// TODO Auto-generated method stub
		List<User> list = userMapper.getUsers(); 
		if(list == null) {
		log.warn("没有用户数据");
		return	JsonData.fail("没有用户数据");
		}
		return JsonData.success(list);
	}

//	@Cacheable(cacheNames="user_cache",key="#name")
	@Cacheable(key="#name")
	@Override
	public JsonData getUserByName(String name) {
		System.out.println(name);
		User user = userMapper.getUserByName(name);
		System.out.println(user);
		if(user == null) {
			log.warn("用户"+name+"数据不存在.");
			return	JsonData.fail("用户"+name+"数据不存在.");
		}
		return JsonData.success(user);
	}

	@Override
	public JsonData insertUser(User user) {
		// TODO Auto-generated method stub
		User user2 = userMapper.getUserByName(user.getName());
		if(user2 != null) {
			log.warn(user+"数据已存在,无法新增.");
		return JsonData.fail("数据已存在,无法新增.");
		}	
		userMapper.insertUser(user);
		return JsonData.success();
	}

	@CacheEvict(key="#user.name")
//	@CachePut(key="#user.name")
//	@CacheEvict(key="#user.name")
	@Override
	public JsonData updateUser(User user) {
		User user2 = userMapper.getUserByName(user.getName());
		if(user2 == null) {
			log.warn(user+"数据不存在,无法修改.");
		return JsonData.fail("数据不存在,无法修改.");
		}
		userMapper.updateUser(user);
		return JsonData.success();
	}

	@CacheEvict(key="#name")
	@Override
	public JsonData deleteUser(String name) {
		// TODO Auto-generated method stub
		System.out.println(name);
		User user2 = userMapper.getUserByName(name);
		System.out.println(user2);
		if(user2 == null) {
			log.warn("用户"+name+"数据不存在,无法删除.");
		return JsonData.fail("数据不存在,无法删除");
		}
		userMapper.deleteUser(user2);
		return JsonData.success();
	}
	


}
