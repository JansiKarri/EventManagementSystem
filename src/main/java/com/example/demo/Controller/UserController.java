package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/users/api/v1")
public class UserController {
	@Autowired
	UserService us;
	@PostMapping("/addUser")
	public User addUser(@RequestBody User u) {
		return us.addUser(u);
	}
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers(){
		return us.getAll();
	}
	@GetMapping("/getById/{user_id}")
	public User getById(@PathVariable int user_id) {
		return us.getById(user_id);
	}
	@PutMapping("/updateUser/{user_id}")
	public User updateUser(@RequestBody User u,@PathVariable int user_id) {
		return us.updateUser(user_id, u);
	}
	@DeleteMapping("/deleteById/{user_id}")
	public String deleteById(@PathVariable int user_id) {
		return us.deleteUser(user_id);
	}

}
