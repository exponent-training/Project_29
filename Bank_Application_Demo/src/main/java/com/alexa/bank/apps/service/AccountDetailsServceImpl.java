package com.alexa.bank.apps.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexa.bank.apps.entity.AccountDetails;
import com.alexa.bank.apps.entity.Customer;
import com.alexa.bank.apps.entity.RandomAcNumberGenerator;
import com.alexa.bank.apps.repo.AccountDetailRespository;
import com.alexa.bank.apps.repo.CustomerRepository;
import com.alexa.bank.apps.repo.RamdomAcNumberRepository;

@Service
public class AccountDetailsServceImpl implements AccountDetailsService{

	@Autowired
	private AccountDetailRespository accountDetailRespository;
	
	@Autowired
	private RandomAcNumberService randomAcNumberService;
	
	@Autowired
	private RamdomAcNumberRepository ramdomAcNumberRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public void createAccount(String uname, AccountDetails accountDetails) {
		// TODO Auto-generated method stub
		System.out.println("Account Creation Start");
		if(accountDetails != null && uname != null) {
			
			Customer customer = customerRepository.findByUname(uname);
			
			if(customer != null) {
				RandomAcNumberGenerator randomAcNumberGenerator = randomAcNumberService.getRandomAcNumberData();
				accountDetails.setAccountnumber("SBI/GEN:"+String.valueOf(randomAcNumberGenerator.getAcnumber()));
				accountDetails.setAcholdername(customer.getFirstname()+ " "+customer.getLastname());
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy HH:mm:sss");
				String date = dateFormat.format(new Date(System.currentTimeMillis()));
				
				accountDetails.setAccountcreationdate(date);
				
				long acnumber = randomAcNumberGenerator.getAcnumber()+1;
				System.out.println("Check ac number : " + acnumber);
				randomAcNumberGenerator.setAcnumber(acnumber);
				ramdomAcNumberRepository.save(randomAcNumberGenerator);
				
				customer.getAccountDetails().add(accountDetails);
				
				customerRepository.save(customer);
			}else {
				System.out.println("Customer Not found.");
			}
		}
         System.out.println("Account Creation End.");
		
	}

}
