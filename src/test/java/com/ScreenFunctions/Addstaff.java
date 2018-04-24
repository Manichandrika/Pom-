package com.ScreenFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.GenericFunctions.GenericFunctions;

public class Addstaff extends GenericFunctions
{
    //xapth for clicking addstaff link
	@FindBy(how = How.XPATH, using = "//a[text()='Add staff member']")
    public static WebElement lnk_add_staff;
	
	//xpath for name
	@FindBy(how = How.XPATH, using = "//input[@name='staff_name']")
    public static WebElement lnk_staff_name;
	
	//xpath for gender
	@FindBy(how = How.XPATH, using = "//table//tbody//tr[3]//td[2]//input[@value='F']")
    public static WebElement lnk_staff_gender;
	
	//xpath for dob
	@FindBy(how = How.XPATH, using = "//input[@name='staff_dob']")
    public static WebElement lnk_staff_dob;
	
	//xpath for relatin
	@FindBy(how = How.XPATH, using = "//table//tbody//tr[5]//td[2]//select")
    public static WebElement lnk_staff_relation;
	
	//xpath for depatment
	@FindBy(how = How.XPATH, using = "//table//tbody//tr[6]//td[2]//select")
    public static WebElement lnk_staff_department;
	
	//xpath fpr doj
	@FindBy(how = How.XPATH, using = "//input[@name='staff_doj']")
    public static WebElement lnk_staff_doj;
	
	//xpath for address
	@FindBy(how = How.XPATH, using = "//textarea[@name='staff_address']")
    public static WebElement lnk_staff_address;
	
	//xpath for mobile
	@FindBy(how = How.XPATH, using = "//input[@name='staff_mobile']")
    public static WebElement lnk_staff_mobile;
	
	//xpath for email
	@FindBy(how = How.XPATH, using = "//input[@name='staff_email']")
    public static WebElement lnk_staff_email;
	
	//xpath for password
	@FindBy(how = How.XPATH, using = "//input[@name='staff_pwd']")
    public static WebElement lnk_staff_pwd;
    
	//xpath for click on add staff after entering data 
	@FindBy(how = How.XPATH, using = "//input[@name='add_staff']")
    public static WebElement lnk_add_staff1;
	
	
	
/*************************************************
	
	
	Function Name:addstaff 
	
	Purpose:-This Function is used to perform the add staff operation in the server/bank application like click on the add staff 
	and then enter the data in the add staff fields
		
	Input Parameters:-User must send an argument stating what data that is required
	
	Output Parameters:-This method will return a string value for the User given input(If data is not found it will return a null)
	
	Author:-Mani Maddipati
	
	Creation date:-05/04/2018
	
	
	**************************************************/
	
	
	
	
	
	
	
	//perform the following operations
	public static boolean addstaff()
	{
		boolean status=true;
      //perform the hoverand click operation 
		status=hoverAndClick(lnk_add_staff);
		
		if (status)
		{
			status=true;
			
			//enter the staffname
			
			String staffname = getdata("Addstaff","Staffname",1);
			status=setdata(lnk_staff_name, staffname);
			
			if(status)
			{
				status=logEvent("pass", "Staff name entered successfully");
				
			}else
			{
				status=logEvent("fail", "Staff name was not entered successfully");
				
			}
			
			
			//click on gender
			
			lnk_staff_gender.click();
			
			if(status)
			{
				status=logEvent("pass", "Gender clicked successfully");
				
			}else
			{
				status=logEvent("fail", "Gender clicked unsuccessfully");
			}
			
			
			
			//enter the data in dob
			String staffdob = getdata("Addstaff","DOB",1);
			status=setdata(lnk_staff_dob, staffdob);
			
			if(status)
			{
				status=logEvent("pass", " DOB entered successfully");
				
			}else
			{
				status=logEvent("fail", " DOB entered unsuccessfully");
			}
			
			
			
			//click on relation
			String staffrelation = getdata("Addstaff","Relationship",1);
			status=selectoption(lnk_staff_relation, staffrelation);
			
			if(status)
			{
				status=logEvent("pass", " Relationship entered successfully");
				
			}else
			{
				status=logEvent("fail", "Relationship entered unsuccessfully");
			}
			
			
			
			//click on department
			String staffdepartment = getdata("Addstaff","Department",1);
			status=selectoption(lnk_staff_department, staffdepartment);
			
			if(status)
			{
				status=logEvent("pass", " Department entered successfully");
				
			}else
			{
				status=logEvent("fail", "Department entered unsuccessfully");
			}
			
			
			
			//enter the data in doj
			String staffdoj = getdata("Addstaff","DOJ",1);
			status=setdata(lnk_staff_doj, staffdoj);
			
			if(status)
			{
				status=logEvent("pass", " DOJ entered successfully");
				
			}else
			{
				status=logEvent("fail", "DOJ entered unsuccessfully");
			}
			
			
			
			//enter the staffaddress 
			String staffaddress = getdata("Addstaff","Address",1);
			status=setdata(lnk_staff_address, staffaddress);
			
			if(status)
			{
				status=logEvent("pass", " Address entered successfully");
				
			}else
			{
				status=logEvent("fail", "Address entered unsuccessfully");
			}
			
			
			
			
			//enter the mobile number
			String staffmobile = getdata("Addstaff","Mobile",1);
			status=setdata(lnk_staff_mobile, staffmobile);
			
			if(status)
			{
				status=logEvent("pass", " Mobile entered successfully");
				
			}else
			{
				status=logEvent("fail", "Mobile entered unsuccessfully");
			}
			
			
			
			//enter the email id
			String staffemail = getdata("Addstaff","EmailId",1);
			status=setdata(lnk_staff_email, staffemail);
			
			if(status)
			{
				status=logEvent("pass", " EmailId entered successfully");
				
			}else
			{
				status=logEvent("fail", "EmailId entered unsuccessfully");
			}
			
			
			
			//enter the password
			String staffpwd = getdata("Addstaff","Password",1);
			status=setdata(lnk_staff_pwd, staffpwd);
			
			if(status)
			{
				status=logEvent("pass", " Password entered successfully");
				
			}else
			{
				status=logEvent("fail", "Password entered unsuccessfully");
			}
			
			
			
			//clickon addstaff
			lnk_add_staff1.click();
			
			if(status)
			{
				status=logEvent("pass", "add staff after entering details clicked successfully");
				
			}else
			{
				status=logEvent("fail", "add staff after entering details clicked unsuccessfully");
			}
			
			
			
			
		}
		else
		{
			status=false;
			
		}
	
		return status;
	
	}
	
	
}
