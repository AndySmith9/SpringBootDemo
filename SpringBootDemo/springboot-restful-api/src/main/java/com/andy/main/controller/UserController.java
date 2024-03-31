package com.andy.main.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
		
//		String name1 = String.format(",%s,",name);
//		if(!defaultName.contains(name1)) {
//			throw new ParamException("默认用户名字不存在");
//		}
		return userService.getUserByName(name);
	}

	@GetMapping("/get2")
	public JsonData getUserByName2(User user) {
		return userService.getUserByName(user.getName());
	}
	@GetMapping("/get3")
	public JsonData getUserByName3(@RequestParam("name")String name) {
		return userService.getUserByName(name);
	}
	@GetMapping("/get4")
	public JsonData getUserByName4(@RequestBody String name) {
		return userService.getUserByName(name);
	}
	@GetMapping("/get5")
	public JsonData getUserByName5(@RequestBody User user) {
		return userService.getUserByName(user.getName());
	}
	
	@PostMapping("/insert")
		public JsonData insertUser(@RequestBody User user) {
		return userService.insertUser(user);
	}
	@PostMapping("/insert2")
	public JsonData insertUser2(User user) {
		return userService.insertUser(user);
	}
	@PostMapping("/insert3")
	public JsonData insertUser3(@RequestParam("name")String name,@RequestParam("age")int age) {
		User user = new User(name,age);
		return userService.insertUser(user);
	}
	
	
	@PutMapping("/update")
	public JsonData updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	@PutMapping("/update2")
	public JsonData updateUser2(User user) {
		return userService.updateUser(user);
	}
//	@PutMapping("/update3")
//	public JsonData updateUser3(@RequestParam("name")String name,@RequestParam("age")int age) {
//		User user = new User(name,age);
//		return userService.updateUser(user);
//	}
	
	
	@DeleteMapping("/delete/{name}")
	public JsonData deleteUser(@PathVariable("name")String name) {
		return userService.deleteUser(name);
	}

	@DeleteMapping("/delete2")
	public JsonData deleteUser2(String name) {
		return userService.deleteUser(name);
	}
//	@DeleteMapping("/delete3")
//	public JsonData deleteUser3(@RequestParam("name")String name2) {
//		return userService.deleteUser(name2);
//	}
	
}
