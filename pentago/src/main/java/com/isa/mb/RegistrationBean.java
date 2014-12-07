package com.isa.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.isa.mb.saltedHash.SaltHash;
import com.isa.mb.ui.RegistrationForm;

@ManagedBean
@RequestScoped
public class RegistrationBean
{
	 private RegistrationForm registrationForm = null;
	 private SaltHash passwordtohash = new SaltHash();
	 
	 public RegistrationBean()
	 {
		
	 }
	 
	 public String register()
	 {
		  System.out.println("register.....");
		 // String password =  passwordtohash.getSecurePassword(registrationForm.getPassword());
		  
		  //store data in DB
		  System.out.println(this.registrationForm);
		  System.out.println("generated password after hashing is:" + registrationForm.getPassword());
		  String salt = passwordtohash.getSalt();
		  String securepwd = passwordtohash.getSecurePassword(registrationForm.getPassword(),salt);
		  System.out.println("generated salt is:" + salt);
		  System.out.println("generated secure pwd is:" + securepwd);
		  return "welcome";//go to welcome.xhtml
	 }
	 
	 public RegistrationForm getRegistrationForm()
	 {
		  if(this.registrationForm == null){
			  this.registrationForm = new RegistrationForm();
		  }
		  return registrationForm;
	 }
	

 
}