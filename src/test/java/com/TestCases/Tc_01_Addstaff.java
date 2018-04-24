package com.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.GenericFunctions.GenericFunctions;


import com.ScreenFunctions.Addstaff;
import com.ScreenFunctions.DeleteCustomer;
import com.ScreenFunctions.Deletestaff;
import com.ScreenFunctions.Login;

public class Tc_01_Addstaff extends GenericFunctions
{
  @Test
	public static void addstaff()
	{
	 //for browser launch
     GenericFunctions gnf=new GenericFunctions();
     gnf.launchApplication("firefox");
	 
	//for login the admin page     
    Login lg=PageFactory.initElements(driver,Login.class);
	lg.Login_Admin();
	
	//for adding the staff
	Addstaff as=PageFactory.initElements(driver,Addstaff.class);
	as.addstaff();
	
	//for deleting the customer
	//DeleteCustomer dc=PageFactory.initElements(driver, DeleteCustomer.class);
	//dc.deletecustomer();
	
	//for deleteing the staff
	//Deletestaff ds=PageFactory.initElements(driver,Deletestaff.class);
	//ds.deletestaff();
	
	
	
	
	
	
	}
	
	
	
}
