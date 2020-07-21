package Test;

import io.appium.java_client.MobileElement;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Test.ReadExcelFile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Login extends OpenApp{
	
	
	@Test(dataProvider = "testdata1")
	public void login(String emails,String passwords) throws InterruptedException {
	System.out.println(driver+"driver");
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	//Assertion for Title of page
	String Title=driver.getTitle();
	Assert.assertEquals(Title, "CoalShastra");
	
	MobileElement email = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@text,'Email Address *')]");
	email.sendKeys(emails);
	
	MobileElement password = (MobileElement) driver.findElementByXPath("//*[contains(@text,'Password *')]");
	password.sendKeys(passwords);
	MobileElement loginButton = (MobileElement) driver.findElementByXPath("//*[contains(@text,'LOGIN')]");
	loginButton.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


	// Negative test for entering wrong credentials
		
	if(loginButton.isDisplayed())
	{
		Assert.assertTrue(true);
		System.out.println("Wrong credntials entered");
	}
	}
	
	
	@DataProvider(name = "testdata1")
	public Object[][] TestDataFeed() {

		ClassLoader classLoader = this.getClass().getClassLoader();
		ReadExcelFile config = new ReadExcelFile(classLoader.getResource("testData/TC2.xlsx").getFile());

		int rows = config.getRowCount(0);

		Object[][] credentials = new Object[rows][2];

		for (int i = 0; i < rows; i++) {
			credentials[i][0] = config.getData(0, i, 0);
			credentials[i][1] = config.getData(0, i, 1);
			
		}

		return credentials;
	}
}
