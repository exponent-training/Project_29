package com.alexa.bank.apps.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 
	private String occupation; 
	private String dateofbirth;
    private String firstname; 
    private String identificationmark;
    private String lastname;
    private String contactno;
    private String emailid;
    private String aadharcar;
    private String pancard;
    private String address;
    private String uname;
    private String password;
    
    private String gender;
    private String fathername;
    private String mothername;
    
	@OneToMany(cascade = CascadeType.DETACH)
	@JoinColumn(name = "c_r_id")
	private List<Role> role= new ArrayList<Role>();
	
}
