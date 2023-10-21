package com.alexa.bank.apps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountDetails {

       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private int id;
	   private String accountnumber;
	   private String acholdername;
	   private String accounttype;
	   private String accountcreationdate;
	   private String bankname;
	   private String bankifsccode;
	   private String bankfax;
	   private String bankemail;
	   private String bankcontactno;
	   private String bankbranchname;
	   private String bankaddress;
	   
}
