package com.example.demo.service.Imply;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.models.Event;
import com.example.demo.models.Register;
import com.example.demo.models.User;
import com.example.demo.repository.EventRepo;
import com.example.demo.repository.RegisterRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.RegisterService;

@Service
public class RegisterServiceImply implements RegisterService {
	@Autowired
	RegisterRepo rr;
	@Autowired
	UserRepo ur;
	@Autowired
	EventRepo er;

	@Override
	public List<Register> getAllRegistrations() {

		return rr.findAll();
	}

	@Override
	public Register getRegistrationById(int registration_id) {

		return rr.findById(registration_id).orElseThrow(
				() -> new ResourceNotFoundException("there is no registration with this id: " + registration_id));
	}

	@Override
	public Register addRegistration(Register r) {

		Event fullEvent = er.findById(r.getEvent().getEvent_id())
		        .orElseThrow(() -> new RuntimeException("Event not found"));

		User fullUser = ur.findById(r.getUser().getUser_id())
		        .orElseThrow(() -> new RuntimeException("User not found"));

		r.setEvent(fullEvent);
		r.setUser(fullUser);

		return rr.save(r);

	}

	@Override
	public Register updateRegistration(int registration_id, Register r) {
		Register r1 = getRegistrationById(registration_id);
		r1.setRegistration_date(r.getRegistration_date());
		return rr.save(r1);
	}

	@Override
	public String deleteRegistration(int registration_id) {
		Optional<Register> register=rr.findById(registration_id);
		if(register.isPresent()) {
			rr.deleteById(registration_id);
			return "Register with the id:" +registration_id +" is deleted succesfully";
		}
		else
		{
			return "Register with the id:" +registration_id +"not found";
		}
		//rr.deleteById(registration_id);
		//return "Registration is cancelled succesfully:" + registration_id;
	}

}
