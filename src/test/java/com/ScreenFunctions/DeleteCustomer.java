package com.ScreenFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.GenericFunctions.GenericFunctions;

public class DeleteCustomer extends GenericFunctions
{
	//xapth for clicking delete customer link
   @FindBy(how=How.XPATH ,using="//a[text()='Delete customer']")
   public static WebElement Cutomer_delete_customer;
   
   //xpath for click on customer name id
   @FindBy(how=How.XPATH ,using="//table[1]")
   public static WebElement Cutomer_click_id;
   
   //xpath for delete customer after clicking the id of the customer
   @FindBy(how=How.XPATH ,using="//input[@name='submit2_id]")
   public static WebElement Cutomer_dlt_customer_after_click;
   
	
/*************************************************
	
	
	Function Nme:deletecustomer 
	
	Purpose:-This Function is used to perform the delete customer operation in the server/bank application 
		
	Input Parameters:-User must send an argument stating what data that is required
	
	Output Parameters:-This method will return a string value for the User given input(If data is not found it will return a null)
	
	Author:-Mani Maddipati
	
	Creation date:-06/04/2018
	
	
	**************************************************/
	
 //perform the following operations
   public static boolean deletecustomer()
   {
	   boolean status=true;
	   
	 //perform the hoverand click operation 
	   status=hoverAndClick(Cutomer_delete_customer);
	   if(status)
		{
			status=logEvent("pass", "Click on delete Customer name  successfully");
			
		}else
		{
			status=logEvent("fail", "Click on delete Customer name unsuccessfully");
		}
	   if(status)
	   {
		   status=true;
		   
		  //click on the id button if the name is equal to the name which is there in excel 
		   String deletecstname = getdata("Deletecustomer","name",1);
		   String deletecstemail = getdata("Deletecustomer","email",1);
		   status=deletecustomer(deletecstname,deletecstemail);
		   
		   if(status)
			{
				status=logEvent("pass", "customer name deleted successfully");
				
			}else
			{
				status=logEvent("fail", "customer name was not deleted successfully");
			}
		   
		   
		   
		   //click on the delete customer after the id is clicked
		   status=hoverAndClick(Cutomer_dlt_customer_after_click);
		   
		   if(status)
			{
				status=logEvent("pass", "Click on delete customer name after deleting the customer successfully");
				
			}else
			{
				status=logEvent("fail", "Click on delete customer name after deleting the customer unsuccessfully");
			}
		   
			
	   }
	   
	   
	   
	return status;
	   
   }
   
   
   
   
	
	
}
