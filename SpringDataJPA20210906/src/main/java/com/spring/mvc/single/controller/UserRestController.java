package com.spring.mvc.single.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mvc.single.entity.User;
import com.spring.mvc.single.repository.UserRepository;

@RestController //在每個方法會自動加上 @ResponseBody
@RequestMapping(value = "/rest/user")
public class UserRestController {
	@Autowired
	private UserRepository userRepository;
	
	//查詢
	@GetMapping(value = "/")
	public List<User> queryAll(){
		Sort sort = new Sort(Sort.Direction.DESC,"id");
		List<User> users = userRepository.findAll(sort);
		return users;
	}
	
	//單筆查詢
	@GetMapping(value = "/{id}")
	public User getOne(@PathVariable(value = "id") Long id) {
		return userRepository.findOne(id);
	}
	
	//新增
	@PostMapping(value = "/")
	public User create(@RequestBody User user) {
		userRepository.save(user);
		return user;
	}
	
	//修改
	@PutMapping(value = "/")
	public User update(@RequestBody User user) {
		userRepository.saveAndFlush(user);
		return user;
	}
	
	//刪除
	@DeleteMapping(value = "/{id}")
	public String delete(@PathVariable(value = "id")Long id) {
		userRepository.delete(id);
		return id+"";
	}
	
}
