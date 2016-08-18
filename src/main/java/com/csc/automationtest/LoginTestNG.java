package com.csc.automationtest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTestNG {

	private WebDriver driver;
	private String baseUrl;

	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://20.203.153.48:8090/fresherProject/login";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	public void testLogin() throws Exception {
		driver.get(baseUrl + "");
		Assert.assertEquals(driver.getTitle(), "Login");
		driver.findElement(By.id("j_username")).clear();
		driver.findElement(By.id("j_username")).sendKeys("admin");
		driver.findElement(By.id("j_password")).clear();
		driver.findElement(By.id("j_password")).sendKeys("admin");
		
		takeScreenshot(driver, "testLogin");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		if (driver.getTitle().equals("CSC Banking System")) {
			Assert.assertTrue(true, "Login Failed!");
		}

	}

	@Test(priority = 2, dependsOnMethods = { "testLogin" })
	public void testHome() throws Exception {
		takeScreenshot(driver, "testHome1");
		
		Assert.assertTrue(driver.getTitle().equals("CSC Banking System1"),
				"Cannot find title CSC Banking System");
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}
	}

	public static String getBaseUrl() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes()).getRequest();
		String url = "";
		url = getBaseUrl(request) + "/login";
		return url;
	}

	public static String getBaseUrl(HttpServletRequest request) {
		String scheme = request.getScheme() + "://";
		String serverName = request.getServerName();
		String serverPort = (request.getServerPort() == 80) ? "" : ":"
				+ request.getServerPort();
		String contextPath = request.getContextPath();
		return scheme + serverName + serverPort + contextPath;
	}

	public static void takeScreenshot(WebDriver driver, String name)
			throws IOException {
		if (driver instanceof TakesScreenshot) {
			File tempFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(tempFile,
					new File(String.format("target/surefire-reports/screenshots/%s.png", name)));
		}
	}
}
