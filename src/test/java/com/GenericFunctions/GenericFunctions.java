package com.GenericFunctions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

public class GenericFunctions extends TestNGListeners {
	
	
	public static  WebDriver driver;

	

	/*************************************************
	
	
	Function Name:launchApplication
	
	Purpose:-This Function is used to launch the HRM Application when ever the user is required
	
	Input Parameters:-User must send in which browser does the application need to be launch
	
	Output Parameters:-This method will return a boolean value stating whether the user logged into in the system
	
	Author:-Veera Prathap Malepati
	
	Creationn date:-12/30/2017
	
	
	**************************************************/
	
	
	
	
	
	public static boolean launchApplication(String browser) {
		
		boolean status=true;
		
		
		switch (browser.toLowerCase()) {
		case "ie":
			
			break;

		case "firefox":
			
			driver= new FirefoxDriver();
			
			String url=getCommontestdata("Url");
			
			System.out.println(url);
			
			driver.get(url);
			
			driver.manage().window().maximize();
			
			//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			
			break;
			
		case "chrome":
			System. setProperty("webdriver.chrome.driver", "C:\\Users\\tm\\Downloads\\chromedriver.exe");		
			
			driver =new ChromeDriver();
			String url1=getCommontestdata("Url");
			System.out.println(url1);
			driver.manage().window().maximize();

			break;
			
			
			
		default:
			break;
		}
		
	return status;	
		
	}
	

	/*************************************************
	
	
	Function Name:GetCommonTestdata 
	
	Purpose:-This Function is used to get the common test data which can be accessed commonly for each testcase such as Environment,Url,Username,Password
	
	Input Parameters:-User must send an argument stating what data that is required
	
	Output Parameters:-This method will return a string value for the User given input(If data is not found it will return a null)
	
	Author:-Veera Prathap Malepati
	
	Creationn date:-12/31/2017
	
	
	**************************************************/
	
	
	
	public static String getCommontestdata(String data)
	{
		
		String strQuery="Select "+ data+" from CommonTestdata";
		
		System.out.println(strQuery);
		
		Recordset recordset;
		
		String fetcheddata="";
		
		
		try {
			
			recordset = TestNGListeners.connection.executeQuery(strQuery);
			
			while(recordset.next()){
				
				System.out.println("Data is found and the data is " +recordset.getField(data));
				
				fetcheddata=recordset.getField(data);
				break;
				
				
				}
				 
				recordset.close();
			
			
		} catch (FilloException e) {
			
			System.out.println("No Records Found");
		}
		 
		return fetcheddata;
		
		
	}
	
	
	
/*************************************************
	
	
	Function Name:Getdata 
	
	Purpose:-This Function is used to get the data which can be accessed from Xl sheet like name,id etc...
		
	Input Parameters:-User must send an argument stating what data that is required
	
	Output Parameters:-This method will return a string value for the User given input(If data is not found it will return a null)
	
	Author:-Mani Maddipati
	
	Creation date:-05/04/2018
	
	
	**************************************************/
	
	
	public static String getdata(String sheetname,String userdata,int itr)
	{
		
		String strQuery="Select "+ userdata+" from "+sheetname+ " where Tc_Name='"+crntclass+"' and Iteration="+itr;
		System.out.println(strQuery);
		
		Recordset recordset;
		
		String fetcheddata="";
		
		
		try {
			
			recordset = TestNGListeners.connection.executeQuery(strQuery);
			
			while(recordset.next()){
				
				System.out.println("Data is found and the data is " +recordset.getField(userdata));
				
				fetcheddata=recordset.getField(userdata);
				break;
				
				
				}
				 
				recordset.close();
			
			
		} catch (FilloException e) {
			
			System.out.println("No Records Found");
		}
		 
		return fetcheddata;
		
		
	}
/*************************************************
	
	
	Function Name:wait for element 
	
	Purpose:-This Function is used to wait for a element until it found for certain time
		
	Input Parameters:-User must send an argument stating what data that is required
	
	Output Parameters:-This method will return a string value for the User given input(If data is not found it will return a null)
	
	Author:-Mani Maddipati
	
	Creation date:-05/04/2018
	
	
	**************************************************/
	public static boolean waitForElement(WebElement element)
	{
	boolean status=true;
		for(int i=1;i<=10;i++)
		{
		try
		{status=true;
			System.out.println("Wait is executing");
			Actions acc=new Actions(driver);
			acc.moveToElement(element).build().perform();
			
			System.out.println("Element Found");
			break;
			
		}
		catch(Exception e)
		{status=false;
			try {
				Thread.sleep(1000);
				
			} catch (InterruptedException e1) {
				
				e1.printStackTrace();
			}
			
		}
		}	
	return status;	
	}/*************************************************
	
	
	Function Name:setdata 
	
	Purpose:-This Function is used to set the data like name ,gender etc...which can accessed from the xl sheet 	
	
	Input Parameters:-User must send an argument stating what data that is required
	
	Output Parameters:-This method will return a string value for the User given input(If data is not found it will return a null)
	
	Author:-Mani Maddipati
	
	Creation date:-05/04/2018
	
	
	**************************************************/
	 public static boolean setdata(WebElement element,String data)
	 {
		 boolean status=true;
		 status=waitForElement(element);
		 if(status)
		 {
			 try{  
				status=true;
				System.out.println("Element is found then we have to click");
				 element.click();
				 element.clear();
				 element.sendKeys(data);
				 
				 				 
			 }
			 catch(Exception e)
			 {
				 status=false;
				 System.out.println("Element is not found");
			 }
		 }
		
		return status;
		 
	 
	 }
	 /*************************************************
		
		
		Function Name:selectoption 
		
		Purpose:-This Function is used to select the perticular text which is same as given in excel
		
		Output Parameters:-This method will return a string value for the User given input(If data is not found it will return a null)
		
		Author:-Mani Maddipati
		
		Creation date:-06/04/2018
		
		
		**************************************************/
	 
	 
	 
	 public static boolean selectoption(WebElement element,String option)
	 {
		 
		 boolean status=true;
		 try
		 {
			status=true;
			Select slt=new Select(element);
			slt.selectByVisibleText(option);
		 }
		 catch(Exception e)
		 {
				 status=false;
		 }
		 
		return status;
	 }
		
	
		 /*************************************************
		 	
		 	
		 	Function Name:deletecustomer
		 	
		 	Purpose:-This Function is used to delete the customer id which is there in delete customer link 
		 	when the data in the excel and the data is same then it will move to the id row click on the perticular id
		 		
		 	Input Parameters:-User must send an argument stating what data that is required
		 	
		 	Output Parameters:-This method will return a string value for the User given input(If data is not found it will return a null)
		 	
		 	Author:-Mani Maddipati
		 	
		 	Creation date: 06/04/2018
		 	
		 	
		 	**************************************************/
		 	
		 
	public static boolean deletecustomer(String option,String email)	
	{
		boolean status=true;
		
		
		WebElement element=driver.findElement(By.xpath("//table[1]/tbody/tr/td[text()='"+option+"']/following-sibling::td[7][text()='"+email+"']/preceding-sibling::td[8]/input"));
		
		status=hoverAndClick(element);
		if(status)
		{
			System.out.println("Able to click the custmor Id of radio button");
		}
		else
		{
			System.out.println("Unble to click the custmor Id of radio button");
		}
		//List<WebElement> row = table.findElements(By.linkText("tr"));
		//for(int i=2;i<=row.size();i++)
		//{
			//String tablevalue=driver.findElement(By.xpath("//table[@align='center'][1]/tbody/tr[i]/td[2]/following-sibling::td[7])")).getText();
			//if(tablevalue.equals(option))
			//{
				//driver.findElement(By.xpath("//table[@align='center']/tbody/tr[i]/td[1]")).click();
				//break;
		//}
		//}
		
		return status;
		
		
		
	}
	
	
	
		 /*************************************************
			
			
			Function Name:hoverandclick 
			
			Purpose:-This Function is used to perform the hover and force click on the element		
			Input Parameters:-User must send an argument stating what data that is required
			
			Output Parameters:-This method will return a string value for the User given input(If data is not found it will return a null)
			
			Author:-Mani Maddipati
			
			Creation date:-05/04/2018
			
			
			**************************************************/
		 
	 
	public static boolean hoverAndClick(WebElement element)
	{
	boolean status=true;
		
		try
		{
			waitForElement(element);
			Actions acc=new Actions(driver);
			acc.moveToElement(element).click().build().perform();
		
		
			
			
		}
		catch(Exception e)
		{
			
			status=false;
		
		}	
		
	
	
	return status;
	}	
/*************************************************
	
	
	Function Name:forceClick
	
	Purpose:-This Function is used to click on the element forcabilly using java script executor 
	
	Input Parameters:-User must send an argument stating what data that is required
	
	Output Parameters:-This method will return a string value for the User given input(If data is not found it will return a null)
	
	Author:-Mani Maddipati
	
	Creationn date:-05/04/2018
	
	
	**************************************************/
	public static void forceClick(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].click();", element);
		
	}

}
