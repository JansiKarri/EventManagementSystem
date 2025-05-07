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

import com.example.demo.models.Register;
import com.example.demo.service.RegisterService;
@RequestMapping("register/api/v1")
@RestController
public class RegisterController {
	@Autowired
	RegisterService rs;
	@PostMapping("/addRegistration")
	public Register addRegistration(@RequestBody Register r) {
		return rs.addRegistration(r);
	}
	
	@GetMapping("/getAllregistrations")
	public List<Register> getAllRegistrations(){
		return rs.getAllRegistrations();
	}
	
	@GetMapping("/getById/{registration_id}")
	public Register getById(@PathVariable int registration_id) {
		return rs.getRegistrationById(registration_id);
	}
	
	@PutMapping("/updateRegistration/{registration_id}")
	public Register updateRegistration(@RequestBody Register r,@PathVariable int registration_id) {
		return rs.updateRegistration(registration_id, r);
	}
	@DeleteMapping("/deleteById/{registration_id}")
	public String deleteById(@PathVariable int registration_id) {
		return rs.deleteRegistration(registration_id);
	}

}
