package com.alexa.bank.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexa.bank.apps.entity.Customer;
import com.alexa.bank.apps.entity.Role;
import com.alexa.bank.apps.repo.CustomerRepository;
import com.alexa.bank.apps.repo.RoleRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public List<String> getAllUserNames() {
		// TODO Auto-generated method stub
		List<String> unames = customerRepository.getAllUname();
		if(unames.size() > 0 ) {
			return unames;
		}
		return null;
	}

	@Override
	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
		List<Role> rlist = roleRepository.findAll();
		return rlist;
	}

	@Override
	public void assignRole(String uname, Role role) {
		// TODO Auto-generated method stub
		if(uname != null) {
			Customer customer = customerRepository.findByUname(uname);
			customer.setRole(role);
			customerRepository.save(customer);
		}
	}

}
