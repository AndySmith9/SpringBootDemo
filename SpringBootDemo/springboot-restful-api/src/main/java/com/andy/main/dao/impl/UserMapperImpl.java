package com.andy.main.dao.impl;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.andy.main.dao.UserMapper;
import com.andy.main.pojo.User;

@Repository
public class UserMapperImpl implements UserMapper {
//private List<User> list = DataFactory.getUserList();
	private static List<User> list;	
private static final Logger log = LoggerFactory.getLogger(UserMapper.class);
	
static {
	list = DataFactory.getUserList();
}


	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		log.info("所有用户数据"+list);
		return list;
	}

	@Override
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		User user = null;
		for(User user2:list) {
			if(Objects.equals(user2.getName(),name)) {
				user = user2;
				log.info("用户名为"+name+"的用户数据:"+user.toString());
			}
		}		
		return  user;
	}

	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		list.add(user);
		log.info("新增用户:"+user.toString());
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		for(User user2:list) {
			if(Objects.equals(user2.getName(), user.getName())) {
				log.info("更新前:"+user2.toString()+".更新后:"+user.toString());
				user2.setAge(user.getAge());
				
			}
		}
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		//java.util.ConcurrentModificationException:
//		for(User user:list) {
//			if(Objects.equals(name, user.getName())) {
//				log.info("用户"+user.toString()+"已被删除.");
//				list.remove(user);
//			
//			}
//		}
		log.info("用户"+user.toString()+"已被删除.");
		list.remove(user);
		
	}

}
