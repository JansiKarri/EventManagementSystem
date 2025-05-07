package com.example.demo.service;

import java.util.List;

import com.example.demo.models.User;

public interface UserService {
	List<User> getAll();
	User addUser(User u);
	User getById(int user_id);
	User updateUser(int user_id,User u);
	String deleteUser(int user_id);

}
