package com.andy.main.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.andy.main.common.JsonData;
import com.andy.main.exception.ParamException;
import com.andy.main.pojo.User;
import com.andy.main.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Value("${user.default.name}")
	private String defaultName;
	@Autowired
	private CacheManager cacheManager;

	@GetMapping("/")
	public JsonData getUsers() {
		return userService.getUsers();
	}

	@GetMapping("/{name}")
	public JsonData getUserByName(@PathVariable("name") String name) {
//		String[] strArray = defaultName.split(",");
//		boolean exist = false;
//		for(String str:strArray) {
//			if(str.equals(name)) {
//				exist = true;
//				break;
//			}
//		}
//		if(!exist) {
//			throw new ParamException("默认用户名字不存在");
//		}
		System.out.println(cacheManager.getClass().getName());//org.springframework.cache.jcache.JCacheCacheManager
		System.out.println(cacheManager.toString());
//		String name1 = String.format(",%s,",name);
//		if(!defaultName.contains(name1)) {
//			throw new ParamException("默认用户名字不存在");
//		}
		return userService.getUserByName(name);
	}

	@PostMapping("/insert")
//	public JsonData insertUser(@RequestParam User user) {
		public JsonData insertUser(@RequestBody User user) {
		return userService.insertUser(user);
	}

	@PutMapping("/update")
	public JsonData updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}

	@DeleteMapping("/delete/{name}")
//	public JsonData deleteUser(@RequestParam("name") String name) {
//	public JsonData deleteUser(@RequestBody User user) {
	public JsonData deleteUser(@PathVariable("name")String name) {
		return userService.deleteUser(name);
	}

}
