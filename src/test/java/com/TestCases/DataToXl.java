package com.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DataToXl
{
public static WebDriver driver=new FirefoxDriver();
 
 public static void data()
 {
	 driver.get("http://server/bank/");
	 driver.manage().window().maximize();
	 driver.findElement(By.xpath("//a[text()='Staff ']")).click();
	 driver.findElement(By.xpath("//input[@name='submitBtn']")).click();
	 
	 		
 }
 
}
