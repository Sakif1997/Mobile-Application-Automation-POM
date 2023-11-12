package Utilities;

import static MobileConfig.DriverSetup.driver;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Allure;

public class Methods{
	public AndroidElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public void clickElement(By locator) {
		getElement(locator).click();
	}
	public void FieldValue(By locator,String text) {
		getElement(locator).sendKeys(text);
	}
	public void WaitElementVisible(By locator) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(locator));

	}
	public void Scrolling(int p1, int p2, int m1, int m2){
		(new TouchAction<>(driver))
		  .press(PointOption.point(p1, p2)).waitAction()
		  .moveTo(PointOption.point(m1, m2))
		  .release()
		  .perform();
	}
	public void takeScreenshot(String name) {
		Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
	}

}
