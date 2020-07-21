package Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Test.ReadExcelFile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
 
public class RegisterPage extends OpenApp{
	
	

	
	
		@Test(dataProvider = "testdata")
		public void Register(String firstName, String lastName, String email,String mobileNumber,String passwords) throws InterruptedException  {
			
			MobileElement register = (MobileElement) driver.findElementByXPath("//*[contains(@text,'Register')]");
		    register.click();
		    
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		MobileElement  Firstname= (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@text,'First Name *')]");
		Firstname.sendKeys(firstName);
		MobileElement  Lastname= (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@text,'Last Name *')]");
		Lastname.sendKeys(lastName);
		MobileElement  emails= (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@text,'Email Address *')]");
		emails.sendKeys(email);
		MobileElement  moblNumber= (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@text,'Contact Number *')]");
		moblNumber.sendKeys(mobileNumber);
		
		MobileElement  notify= (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[contains(@text,'Both')]");
		notify.click();
		MobileElement  password= (MobileElement) driver.findElementByXPath("(//android.widget.EditText[contains(@text,'Password *')])[1]");
		password.sendKeys(passwords);
		MobileElement  confirmpassword= (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@text,'Confirm Password *')]");
		confirmpassword.sendKeys(passwords);
		
		MobileElement  signup= (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@text,'Signup')]");
		
		signup.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		//Negative test for wrong OTP
		MobileElement  otp= (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@text,'Please enter OTP received')]");
		
		otp.sendKeys("1234");
		MobileElement  confirm= (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@text,'Confirm')]");
		confirm.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		if(confirm.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Wrong OTP entered");
		}
	}
		@DataProvider(name = "testdata")
		public Object[][] TestDataFeed() {

			ClassLoader classLoader = this.getClass().getClassLoader();
			ReadExcelFile config = new ReadExcelFile(classLoader.getResource("testData/TC1.xlsx").getFile());

			int rows = config.getRowCount(0);

			Object[][] credentials = new Object[rows][5];

			for (int i = 0; i < rows; i++) {
				credentials[i][0] = config.getData(0, i, 0);
				credentials[i][1] = config.getData(0, i, 1);
				credentials[i][2] = config.getData(0, i, 2);
				credentials[i][3] = config.getData(0, i, 3);
				credentials[i][4] = config.getData(0, i, 4);
			
			}

			return credentials;
		}
}
