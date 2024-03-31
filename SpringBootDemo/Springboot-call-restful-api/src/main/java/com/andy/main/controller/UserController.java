package com.andy.main.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.andy.main.common.JsonData;
import com.andy.main.pojo.User;

@RestController
@RequestMapping("/user")
public class UserController {
private RestTemplate restTemplate = new RestTemplate();
private final String url = "http://localhost:8081/user";
	
	
	@GetMapping("/")
	public JsonData getUsers() {
		return restTemplate.getForObject(url+"/", JsonData.class);
	}
	
	@GetMapping("/{name}")
	public JsonData getUserByname(@PathVariable("name") String name) {
		return restTemplate.getForObject(url+"/{name}", JsonData.class,name);
	}
	
	@PostMapping("/insert")
	public JsonData insertUser(@RequestBody User user) {
		System.out.println(user);
		return restTemplate.postForObject(url+"/insert", user, JsonData.class);
	}
	@PutMapping("/update")
	public void updateUser(@RequestBody User user){
		restTemplate.put(url+"/update", user);
	}
	@DeleteMapping("/delete/{name}")
	public void deleteUser(@PathVariable("name")String name) {
//	public void deleteUser(@RequestBody User user) {
//		System.out.println(user);
//		restTemplate.delete(url+"/delete/"+name);
		restTemplate.delete(url+"/delete/{name}",name);
	}
	
	
}
