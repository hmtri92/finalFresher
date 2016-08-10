package com.csc.automationtest;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTestNG {

	WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
        driver.get("http://localhost:8080/final-project/login");
        driver.manage().window().maximize();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
	}

	@Test
	public void test() throws Exception {
		String pageTitle = driver.getTitle();
        if (!pageTitle.equals("Login"))
        {
            System.out.println("Launched the incorrect webpage");
            driver.close();
 
        } 

        WebElement TB_Username = driver.findElement(By.id("j_username"));        
        TB_Username.sendKeys("support");
        
        WebElement TB_Password = driver.findElement(By.id("j_password"));        
        TB_Password.sendKeys("admin");
        

        WebElement BTN_Login = driver.findElement(By.className("btn"));        
        BTN_Login.click();
	}

}
