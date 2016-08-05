package testJunit;

import com.google.common.base.Function;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class LoginTest {

    WebDriver driver;
 
    @BeforeMethod
    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.get("http://20.203.153.48:8090/fresherProject/login");
        driver.manage().window().maximize();
    }
    @Test
    public void testInvalidLogin() {
        String pageTitle = driver.getTitle();
        if (!pageTitle.equals("Login"))
        {
            System.out.println("Launched the incorrect webpage");
            afterMethod();
 
        }        
        

        WebElement TB_Username = driver.findElement(By.id("j_username"));        
        TB_Username.sendKeys("admin");
        
        WebElement TB_Password = driver.findElement(By.id("j_password"));        
        TB_Password.sendKeys("admin");
        

        WebElement BTN_Login = driver.findElement(By.className("btn"));        
        BTN_Login.click();
        //Thread.sleep(3000);
        
       /* //    Verify that error message is displayed for authentication failure.
        String InvalidLoginMessage = driver.findElement(By.xpath("//fieldset[@id='fsLogin']//div")).getText();
        if (InvalidLoginMessage.equals("Invalid ID or password."))
        {
            System.out.println("Correct message is displayed");
        }
        else
        {
            System.out.println("Incorrect message is displayed");
        } */
    }
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

}
