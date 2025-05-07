package com.example.demo.service.Imply;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UserService;
@Service
public class UserServiceImply implements UserService {
    @Autowired
    UserRepo ur;
	@Override
	public List<User> getAll() {
		
		return ur.findAll();
	}

	@Override
	public User addUser(User u) {
		
		return ur.save(u);
	}

	@Override
	public User getById(int user_id) {
		return ur.findById(user_id).orElseThrow(()-> new ResourceNotFoundException("User is no there with id:"+user_id));
	}

	@Override
	public User updateUser(int user_id, User u) {
		User u1=getById(user_id);
		u1.setName(u.getName());
		u1.setEmail(u.getEmail());
		u1.setPassword(u.getPassword());
		u1.setRole(u.getRole());
		return ur.save(u1);
	}

	@Override
	public String deleteUser(int user_id) {
		Optional<User> user = ur.findById(user_id);
	    if (user.isPresent()) {
	        ur.deleteById(user_id);
	        return "User ID " + user_id + " is deleted successfully";
	    } else {
	        return "User ID " + user_id + " not found. Deletion failed.";
	    }
		
		
	}

}
