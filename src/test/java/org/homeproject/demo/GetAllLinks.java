package org.homeproject.demo;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class GetAllLinks extends BaseReportClass{
	WebDriver driver;
	
  @Test
  public void f() {
	  test = extent1.createTest("f");
	  String url = "";
	  List<WebElement> links = driver.findElements(By.tagName("a"));
	  System.out.println("Total no. of images are " + links.size());
	  

		for(int i=0; i< links.size(); i++){		 
					  
		 url= links.get(i).getAttribute("href");}
		
		if(url == null || url.isEmpty()){
			System.out.println("URL is either not configured for anchor tag or it is empty");}
			
			                
			            else{
			            	System.out.println("URL-Good");
			            	};
	  
	  
	  
  }
  

  
  
  
  @BeforeTest
  public void beforeMethod() {
	  test = extent1.createTest("beforeMethod");
	  driver = new ChromeDriver();
	  driver.get("https://www.fonts.com/");
	  
	  WebDriverWait wait = new WebDriverWait(driver, 30);
	  System.out.println("from before");
	  Object obj = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("logo")));
	  //Assert.assertEquals(obj, By.className("logo"));
	  
	  
	  
  }

  @AfterTest
  public void afterMethod() {
	  test = extent1.createTest("afterMethod");
	  System.out.println("from after");
	  
	  driver.quit();   
  }



@Test
public void test2() {
	  test = extent1.createTest("afterMethod");
	  System.out.println("test2");	  
	  driver.quit();   
}
}
