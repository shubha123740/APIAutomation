package Test;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
 
public class OpenApp {
	public static AndroidDriver driver;
	
	@BeforeTest
	public static void OpenApplication() throws InterruptedException, MalformedURLException {
		
		//Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Samsung 8 API 26");
		//caps.setCapability("udid", "52039bd55a4dc367"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "8.0.0");
		//caps.setCapability("appPackage", "com.coalshastralive.android.app");
		//caps.setCapability("appActivity", "com.coalshastralive.android.app.activity.Login_Activity");
		caps.setCapability("noReset", "true");
		
		//Instantiate Appium Driver
		
				 driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		
	}
	@AfterTest	
	public static void closeApplication() throws InterruptedException, MalformedURLException {


			driver.quit();
			
			
	}
		}
		

