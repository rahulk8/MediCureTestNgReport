
package com.medicureapp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MediCureTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","//home//ubuntu//chromedriver-linux64//chromedriver");
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get("http://13.126.151.156:8082/contact.html");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement name= driver.findElement(By.xpath("//input[@placeholder='Your Name']"));
		name.sendKeys("Rahul Kumar");
		
		
		WebElement phone= driver.findElement(By.xpath("//input[@placeholder='Phone Number']"));
		phone.sendKeys("9711739492");
		
		WebElement email= driver.findElement(By.xpath("//input[@placeholder='Email']"));
		email.sendKeys("rahulpatna89@gmail.com");
		
		WebElement messagebox= driver.findElement(By.xpath("//input[@placeholder='Message']"));
		messagebox.sendKeys("Hi Medicure , Please call me back for medical consultation");
		
		driver.findElement(By.className("btn_box")).click();
		
		String message = driver.findElement(By.id("message")).getText();
		if(message.equals("Email sent.")) {
			System.out.println("Script Executed Successfully");
		} else 
		{
			System.out.println("Script Failed");
		}
		
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File ("//home/ubuntu//scr.png");
		FileUtils.copyFile(screenShot, destFile);
		
		Thread.sleep(3000);
		
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
