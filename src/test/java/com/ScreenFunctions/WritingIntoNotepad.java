package com.ScreenFunctions;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WritingIntoNotepad {

	public static void main(String[] args) throws IOException {
		
		
		WebDriver driver=new FirefoxDriver();
		driver.get("http://server/bank/contact.php");
		driver.manage().window().maximize();
		
	   
	    File f=new File("C:\\Users\\tm\\Desktop","\\manira.txt");
		
	    FileWriter fr=new FileWriter(f);
	 	
		BufferedWriter br=new BufferedWriter(fr);
		
	
		 List<WebElement> list=driver.
		    		findElements(By.xpath("//h3/u[text()='Contact Us']/following::u"));	
		 
		    
		 for(int i=0;i<list.size();i++)
		    {
		    	
		   String str=list.get(i).getText();
		   
		   br.write(str);
		   br.newLine();
		   br.flush();
		    }
			

		fr.close();
		br.close();

	}

}
