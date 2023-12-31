
package com.medicureapp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class MediCureTest {

		    //@SuppressWarnings("deprecation")
      @Test
      public static void main(String[] args) throws InterruptedException, IOException {
       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       System.setProperty("webdriver.chrome.driver","//home//ubuntu//chromedriver-linux64//chromedriver");
       //driver.manage().window().maximize();

 ChromeOptions chromeOptions = new ChromeOptions();
 chromeOptions.addArguments("--headless");
 chromeOptions.addArguments("--no-sandbox");
 chromeOptions.addArguments("--disable-dev-shm-usage"); 
 
  driver.get("http://3.110.154.1:8082/contact.html");

   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

   driver.findElement(By.xpath("//input[@placeholder='Your Name']")).sendKeys("Rahul Kumar");

   driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("9711739492");


   driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("rahulpatna89@gmail.com");

   driver.findElement(By.xpath("//input[@placeholder='Message']")).sendKeys("Hi Medicure , Please call me back for medical consultation");

   driver.findElement(By.className("btn_box")).click();

String message = driver.findElement(By.id("message")).getText();
if(message.equals("Email sent.")) {
	TakesScreenshot scrShot = ((TakesScreenshot)driver);
       File screenShot = scrShot.getScreenshotAs(OutputType.FILE);
       File destFile = new File ("//home/ubuntu//scr.png");
        FileUtils.copyFile(screenShot, destFile); 
	System.out.println("Screenshot taken Successfully");
} else 
{
	System.out.println("Taking Screenshot gets failed");
}

        
 
try {
	Thread.sleep(5000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
driver.quit();

	/*
	

      @Test
	  public  void testapp() {
        WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("kia",Keys.ENTER);
		System.out.println(driver.getTitle());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
		
	 */

}
