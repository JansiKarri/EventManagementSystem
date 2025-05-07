package com.example.demo.service;

import java.util.List;
import com.example.demo.models.Register;

public interface RegisterService {
    List<Register> getAllRegistrations();
    Register getRegistrationById(int registration_id);
    Register addRegistration(Register r);
    Register updateRegistration(int registration_id, Register r);
    String deleteRegistration(int registration_id);
	
}
