package com.alexa.bank.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexa.bank.apps.entity.RandomAcNumberGenerator;
import com.alexa.bank.apps.repo.RamdomAcNumberRepository;

@Service
public class RandomAcNumberServiceImpl implements RandomAcNumberService {

	
	@Autowired
	private RamdomAcNumberRepository ramdomAcNumberRepository;
	
	@Override
	public RandomAcNumberGenerator getRandomAcNumberData() {
		// TODO Auto-generated method stub
		List<RandomAcNumberGenerator> list = ramdomAcNumberRepository.findAll();
		return list.get(0);
	}

}
