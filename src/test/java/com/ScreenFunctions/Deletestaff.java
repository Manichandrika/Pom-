package com.ScreenFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.GenericFunctions.GenericFunctions;

public class Deletestaff extends GenericFunctions
{
	//xapth for clicking delete staff link
	   @FindBy(how=How.XPATH ,using="//a[text()='Delete staff']")
	   public static WebElement Staff_delete_staff;
	   
	   //xpath for click on staff name id
	   @FindBy(how=How.XPATH ,using="//table[1]")
	   public static WebElement Staff_click_id;
	   
	   //xpath for delete staff after clicking the id of the staff
	   @FindBy(how=How.XPATH ,using="//input[@name='submit2_id]")
	   public static WebElement Staff_id_staff_after_click;
	   
		
	/*************************************************
		
		
		Function Name:deletestaff 
		
		Purpose:-This Function is used to perform the delete staff operation in the server/bank application 
			
		Input Parameters:-User must send an argument stating what data that is required
		
		Output Parameters:-This method will return a string value for the User given input(If data is not found it will return a null)
		
		Author:-Mani Maddipati
		
		Creation date:-06/04/2018
		
		
		**************************************************/
		
	 //perform the following operations
	   public static boolean deletestaff()
	   {
		   boolean status=true;
		   
		 //perform the hoverand click operation 
		   status=hoverAndClick(Staff_delete_staff);
		   
		   if(status)
			{
				status=logEvent("pass", "Click on delete Staff name  successfully");
				
			}else
			{
				status=logEvent("fail", "Click on delete Staff name unsuccessfully");
			}
		   
		   if(status)
		   {
			   status=true;
			   
			  //click on the id button if the name is equal to the name which is there in excel 
			   String deletestfname = getdata("Deletestaff","name",1);
			   String deletecstfemail = getdata("Deletestaff","email",1);
			   status=deletecustomer(deletestfname,deletecstfemail);
			   
			   if(status)
				{
					status=logEvent("pass", "Staff name deleted successfully");
					
				}else
				{
					status=logEvent("fail", "Staff name was not deleted successfully");
				}
			   
			   
			   
			   //click on the delete staff after the id is clicked
			   status=hoverAndClick(Staff_id_staff_after_click);
			   
			   if(status)
				{
					status=logEvent("pass", "Click on delete Staff name after deleting the staff successfully");
					
				}else
				{
					status=logEvent("fail", "Click on delete Staff name after deleting the staff unsuccessfully");
				}
			   
			   
				
		   }
		   
		   
		   
		return status;
		   
	   }
	
	
	

}
