package com.ScreenFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.GenericFunctions.GenericFunctions;


public class Login extends GenericFunctions
{
	
	@FindBy(how = How.XPATH, using = "//a[normalize-space(text())='Admin']")
	public static WebElement lnk_Admin;

	@FindBy(how = How.NAME, using = "uname")
	public static WebElement Username;

	@FindBy(how = How.NAME, using = "pwd")
	public static WebElement Password;

	@FindBy(how = How.NAME, using = "submitBtn")
	public static WebElement Login;

	
	public static boolean Login_Admin() {
		boolean status = true;

		
		status = waitForElement(lnk_Admin);

			if(status)
			{	
			status=true;
			//click on admin tab
				lnk_Admin.click();
				
			//Enter the username	
				String username = getCommontestdata("Username");
				status=setdata(Username, username);
				
			//Enter the password	
				String password = getCommontestdata("Password");
				status=setdata(Password, password);

			//click on login button		
				Login.click();
			
				if(status=true)
				{
				WebElement element=driver.findElement(By.xpath("//u[text()='Admin']"));
				System.out.println(element.getText());
				System.out.println("Login successfully");		
				}
				else
				{
					System.out.println("Login unssuccessfuly");
				}
			}

		return status;

	}

}

