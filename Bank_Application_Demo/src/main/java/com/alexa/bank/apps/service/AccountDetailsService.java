package com.alexa.bank.apps.service;

import com.alexa.bank.apps.entity.AccountDetails;

public interface AccountDetailsService {

	void createAccount(String uname,AccountDetails accountDetails);
}
