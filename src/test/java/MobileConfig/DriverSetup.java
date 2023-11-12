package MobileConfig;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DriverSetup {
	public static AndroidDriver<AndroidElement> driver;
	@BeforeSuite
	public void SetupDriver() throws MalformedURLException{
		 DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		 desiredCapabilities.setCapability("platformName", "Android");
		 desiredCapabilities.setCapability("appium:appPackage", "com.nopstation.nopcommerce.nopstationcart");
		 desiredCapabilities.setCapability("appium:appActivity", "com.bs.ecommerce.main.SplashScreenActivity");
		 URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

		 driver = new AndroidDriver<AndroidElement>(remoteUrl, desiredCapabilities);
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	@AfterSuite
	public void quitDriver() {
		driver.quit();
	}
	


}
