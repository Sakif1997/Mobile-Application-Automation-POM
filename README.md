
# Mobile App Automation

This project is for end-to-end testing of the [Download APK File](https://drive.google.com/file/d/1nUfd53CBXU2eYFbIkkWvPlmfXjN136bu/view?usp=drive_link)  Android application using the Page Object Model (POM) pattern. The following testing procedure will cover a wide range of functionalities, including Add Item to Cart,Proceed to Checkout,Choose Guest Checkout, Enter Shipping Information, Proceed to Payment,Enter Payment Details,Place an order and verify the order confirmation.



## Target/goals
following scenarios, which will be replicated
### Customer Add Product Procedure 
1. Opening Mobile Application
2. click "electronics" from "OUR CATEGORIES" list from home page 
3. click to "Mattress Bedroom" product details page  
4. click plus button to increase Qty by "2"  
5. click add to cart button to add the product in his cart
### Customer Placing Order Procedure
1. go to shopping cart by clicking top cart icon
2. click checkout button from shopping cart page
3. select checkout as guest from shopping cart page
4. input all the details in checkout billing details page and click continue
5. select "Next Day Air" as shipping method and click continue
6. select "Check/Money Order" as payment method and click continue
7. click next button on payment information page
8. click confirm button to place the order
9. order place successfully with popup message "Your order has been successfully processed!"

## Prerequisites
#### Appium Server GUI: Download and install the Appium Server GUI from Appium official website.
#### Appium Inspector.exe: Download and install Appium Inspector.exe, which is bundled with the Appium Desktop application.
#### Android Studio: Download and install Android Studio, which is needed for generate Emulator.[note: For lower Configuration you can also do testing without using emulator by your real device]

## Test Work
### Info of testing in Real Device(this test conducted in real device)
#### FollowUp the below steps:
Mobile App Installation: Install the mobile app [Download APK File](https://drive.google.com/file/d/1nUfd53CBXU2eYFbIkkWvPlmfXjN136bu/view?usp=drive_link) on the real device under test.  
Enable USB debugging on the real device.  
Connect the device to your machine using a USB cable. 
Run CMD to make sure the device is connected by this command:
```ruby
adb devices
```
Then press Enter
Another Important instruction to get application location just give a command below and tap to the app and press enter immediately
```ruby
adb shell dumpsys window | find "mCurrentFocus"
```  
Picture for demonstration  
![device connected and current stats](https://github.com/Sakif1997/Mobile-Application-Automation-POM/assets/45315685/3af1331e-96db-438b-be89-a8b7e6d086e8)  
```ruby
adb shell dumpsys window windows | find "mCurrentFocus"
```    
 or  
 ![new](https://github.com/Sakif1997/Mobile-Application-Automation-POM/assets/45315685/19a37421-d673-4d93-ad76-9dee75b843cf)

  
Launch Appium Server Gui and Appium Inspector from the Appium Desktop application.  
Fillup Remote Path and Desired Capabilities Following from CMD: Instructions showed in image  
![helps to connect device and also mentioned app directory to start and helps to inspect elements](https://github.com/Sakif1997/Mobile-Application-Automation-POM/assets/45315685/58b7e3d7-ac7e-423a-889a-e33bbd0a9d6e)

Now Press Start Session to Inspect or catch path of the elements  
Video Instruction link:  
https://drive.google.com/file/d/1KU-hg9RtOfzPeMs472NGu4TIpLVHrO6a/view?usp=drive_link   
![ins](https://github.com/Sakif1997/Mobile-Application-Automation-POM/assets/45315685/bece682a-d6f4-47de-b91e-b704d2353834)


### Automation Part
The following instructions will help you navigate those testing pages. As I am following the page object model, I will create some packages. At the package level, there is a list of classes where you can create methods, use methods for particular pages, and run and test the testing pages separately and parallelly as well.  


1. Set Environment
i) pom.xml [dependencies set]  
ii) DriverSetup[create separate package ]

2. Page Object Model: create methods, using methods for separate page and create test cases of those pages  
i) Driver Control/setup 
ii) Methods and Page objects[package name: PageObjectsAndMethods]  
iii) TestCases [package name: TestPageCases ]

3. Create Allure report 
i) pom.xml [dependencies set for allure report]
ii) Testng.xml [to run all test file togather]  
![packages](https://github.com/Sakif1997/Mobile-Application-Automation-POM/assets/45315685/d0e538c2-5001-40eb-811e-fef5a87a16ea)


##  Set Environment
Setting up dependencies on testing frameworks that will contain the testing process:  
Create a Maven Project  
Set pom.xml file   
pom.xml file Code:  
Set Under Dependencies
```ruby
     <dependency>
				<groupId>org.testng</groupId>
				<artifactId>testng</artifactId>
				<version>7.5</version>
				<scope>test</scope>
		</dependency>
		<dependency>
				<groupId>org.seleniumhq.selenium</groupId>
				<artifactId>selenium-java</artifactId>
				<version>3.141.59</version>
		</dependency>
		<!--  https://mvnrepository.com/artifact/io.appium/java-client  -->
		<dependency>
				<groupId>io.appium</groupId>
				<artifactId>java-client</artifactId>
				<version>7.6.0</version>
		</dependency>
		<!--  https://mvnrepository.com/artifact/org.apache.commons/commons-lang3  -->
		<dependency>
				<groupId>org.apache.commons</groupId>
				<artifactId>commons-lang3</artifactId>
				<version>3.12.0</version>
		</dependency>
		<!--  https://mvnrepository.com/artifact/commons-io/commons-io  -->
		<dependency>
				<groupId>commons-io</groupId>
				<artifactId>commons-io</artifactId>
				<version>2.11.0</version>
		</dependency>
		<dependency>
		<!--  https://mvnrepository.com/artifact/commons-validatorcommons-validator  -->
				<groupId>commons-validator</groupId>
				<artifactId>commons-validator</artifactId>
				<version>1.7</version>
				</dependency>
		<dependency>
				<groupId>io.qameta.allure</groupId>
				<artifactId>allure-testng</artifactId>
				<version>2.19.0</version>
		</dependency>
```
## BrowserControl/Setup
Create MobileConfig class under Package  
The package will hold DriverSetup in which we run the automation Code 
Inside DriverSetup Class:   
MobileConfig.DriverSetup class is responsible for setting up and configuring the Appium AndroidDriver
 * for mobile automation testing. It includes methods annotated with @BeforeSuite and @AfterSuite to be executed
 * before and after the entire test suite, respectively.  
"I prefer to connect my real device for test run to avoid emulator latency"
```ruby
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
```


## Page Object model
### Methods
Create a package that includes methods and Methods make it easier to implement parallel testing. My method page contains methods that cover more test scenarios in less time.  
##### Methods and Usages:
* To retrieves a single AndroidElement based on the specified locator (By object).
```ruby
public AndroidElement getElement(By locator) {
		return driver.findElement(locator);
	}
```

* To finds an element using the specified locator and performs a click action on it.  
```ruby
public void clickElement(By locator) {
		getElement(locator).click();
	}
```
* To finds an element using the specified locator and enters the provided text into the input field.  
```ruby
public void FieldValue(By locator,String text) {
		getElement(locator).sendKeys(text);
	}
```
* To waits for the visibility of the element identified by the specified locator. 
```ruby
public void WaitElementVisible(By locator) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(locator));

	}
``` 
* To performs a scrolling action from one point to another on the mobile device screen.  
```ruby
public void Scrolling(int p1, int p2, int m1, int m2){
		(new TouchAction<>(driver))
		  .press(PointOption.point(p1, p2)).waitAction()
		  .moveTo(PointOption.point(m1, m2))
		  .release()
		  .perform();
	}
```
* To perform ScreenShot for Allure report to track desire testing screen location
```ruby
public void takeScreenshot(String name) {
		Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
	}
```
Combind Picture of My Class:  
![Method](https://github.com/Sakif1997/Mobile-Application-Automation-POM/assets/45315685/11fb27b3-80ba-48a2-88de-9132ecc5bb63)


### Scenario Replication Classes

### Targeted Scenario:  Customer Add Product Procedure
PackageName: Utilities  
ClassName: ElementsUptoAddTOCart
Overview of this class:
 * The ElementsUptoAddTOCart class represents a set of methods for the Customer Add Product Procedure in a mobile application.
 * This class extends the Methods class, inheriting common utility methods for interacting with mobile elements.
 * The procedure involves opening the mobile application, navigating through categories, selecting a product,
 * adjusting the quantity, and adding the product to the cart.

Here, I build a class that has the xpaths,id required to produce scenarios.  
"Those elements Xpath and id or Inherited from Appium Inspector"  

```ruby
package Utilities;
import org.openqa.selenium.By;


public class ElementsUptoAddTOCart extends Methods{
	public By AcceptButton = By.id("com.nopstation.nopcommerce.nopstationcart:id/btnAccept");
	public By Categories = By.xpath("//android.widget.ImageButton[@content-desc=\"NopStation Cart\"]");
	public By Electronics = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[7]/android.widget.TextView");
	public By ElectronicsPage = By.id("com.nopstation.nopcommerce.nopstationcart:id/categoryNameTextView");
	public By MatressBedroom = By.xpath("(//android.widget.ImageView[@content-desc=\"Placeholder\"])[17]");
	public By MatressBedroomPageVisible = By.id("com.nopstation.nopcommerce.nopstationcart:id/image_view");
	public By MatressQuantity = By.id("com.nopstation.nopcommerce.nopstationcart:id/btnPlus");
	public By AddToCart = By.id("com.nopstation.nopcommerce.nopstationcart:id/btnAddToCart");
	public void GoToSelect() {
		clickElement(AcceptButton);
		clickElement(Categories);
		takeScreenshot("CategoryList");
		clickElement(Electronics);
		WaitElementVisible(ElectronicsPage);
		Scrolling(124, 1580, 726, 550);
		clickElement(MatressBedroom);
		WaitElementVisible(MatressBedroomPageVisible);
		takeScreenshot("MasterBedroomPage");
		Scrolling(341, 1335, 616, 698);
		clickElement(MatressQuantity);
		takeScreenshot("QuantityAdded");
		clickElement(AddToCart);
	}
}
```
### Test Run of Customer Add Product Procedure
PackageName: TestCases  
ClassName: CartElements  
Overview of this TestCase class:  
* The test scenario is implemented in the 'addToCart' method, which calls the 'GoToSelect' method
*   from the ElementsUptoAddTOCart class. The 'GoToSelect' method executes the steps described in the
 *   test scenario, interacting with the mobile app elements to add the product to the shopping cart.
```ruby
package TestCases;
import java.net.MalformedURLException;
import org.testng.annotations.Test;
import MobileConfig.DriverSetup;
import Utilities.ElementsUptoAddTOCart;

public class AddProducts extends DriverSetup{
	ElementsUptoAddTOCart addcart = new ElementsUptoAddTOCart();
	
	@Test (description = "Scenario01: Customer add products in his shopping cart\r\n"
			+ "\r\n"
			+ "Given: Mike on home page after opening nopCart mobile app\r\n"
			+ "When: Mike click \"electronics\" from \"OUR CATEGORIES\" list from home page\r\n"
			+ "And: Mike click to \"Mattress Bedroom\" product details page\r\n"
			+ "And: Mike click plus button to increase Qty by \"2\"\r\n"
			+ "Then: Mike click add to cart button to add the product in his cart")
	public void addToCart() throws MalformedURLException{
		addcart.GoToSelect();
	}

}
```
Execution Result image:  
![Scenario 1](https://github.com/Sakif1997/Mobile-Application-Automation-POM/assets/45315685/01bd7bbf-961f-4c7e-88ff-d212da700882)  

### Targeted Scenario:  Customer Placing Order Procedure
PackageName: Utilities  
ClassName: CartElements  
Overview of this class:
 * Utilities.CartElements class defines elements and methods related to the "Customer Placing Order" scenario.
 * The scenario involves navigating through the shopping cart, checkout, and payment process, ultimately
 * placing an order as a guest.
 *  Define By objects representing various elements on different pages of the order placement process.
 * Implement a method, Scenario2Generate, which performs the step-by-step actions for placing an order.
 *   These actions include navigating through the shopping cart, providing billing details, selecting
 *   shipping and payment methods, and confirming the order.
```ruby
package Utilities;

import org.openqa.selenium.By;

public class CartElements extends Methods{
	public By CartIcon = By.id("com.nopstation.nopcommerce.nopstationcart:id/menu_cart");
	public By ShoppingCartPageVisible = By.id("com.nopstation.nopcommerce.nopstationcart:id/rand1");
	public By CHeckout = By.id("com.nopstation.nopcommerce.nopstationcart:id/btnCheckOut");
	public By CHeckoutAsGuest = By.id("com.nopstation.nopcommerce.nopstationcart:id/btnGuestCheckout");
	public By BillingAddressVisible = By.id("com.nopstation.nopcommerce.nopstationcart:id/shipToSameAddressCheckBox");
	public By FirstName = By.id("com.nopstation.nopcommerce.nopstationcart:id/etFirstName");
	public By lastName = By.id("com.nopstation.nopcommerce.nopstationcart:id/etLastName");
	public By Email = By.id("com.nopstation.nopcommerce.nopstationcart:id/etEmail");
	public By SelectCountry = By.id("com.nopstation.nopcommerce.nopstationcart:id/countrySpinner");
	public By CountryName= By.xpath("//android.widget.TextView[@text=\"Bangladesh\"]");
	public By SelectState = By.id("com.nopstation.nopcommerce.nopstationcart:id/stateSpinner");
	public By StateName = By.xpath("//android.widget.TextView[@text=\"ঢাকা\"]");
	public By Company = By.id("com.nopstation.nopcommerce.nopstationcart:id/etCompanyName");
	public By City = By.id("com.nopstation.nopcommerce.nopstationcart:id/etCity");
	public By StreetAddress1 = By.id("com.nopstation.nopcommerce.nopstationcart:id/etStreetAddress");
	public By ZipCOde = By.id("com.nopstation.nopcommerce.nopstationcart:id/etZipCode");
	public By Number = By.id("com.nopstation.nopcommerce.nopstationcart:id/etPhone");
	public By ContinueButton = By.id("com.nopstation.nopcommerce.nopstationcart:id/btnContinue");
	public By NextDayAirVisibleOption = By.xpath("//android.widget.TextView[@text=\"Next Day Air\"]");
	public By ContinueButton2 =By.id("com.nopstation.nopcommerce.nopstationcart:id/btnContinue");
	public By PaymentPageVisible = By.xpath("//android.widget.TextView[@text=\"bKash Payment ($20.00)\"]");
	public By CheckOrMoneyOrder = By.xpath("//android.widget.TextView[@text=\"Check / Money Order\"]");
	public By PressContinue = By.id("com.nopstation.nopcommerce.nopstationcart:id/btnContinue");
	public By PaymentInfoPageVisible = By.xpath("//android.widget.TextView[@text = \"Payment information\"]");
	public By nextButton = By.xpath("//android.widget.Button[@text = \"Next\"]");
	public By ConfirmPagevisible = By.xpath("//android.widget.TextView[@text = \"Billing address\"]");
	public By ConfirmButton = By.xpath("//android.widget.Button[@text = \"CONFIRM\"]");
	public By VisiblePopupMessage = By.id("com.nopstation.nopcommerce.nopstationcart:id/md_text_message");
	public String PopUpMessage = "Your order has been successfully processed!";
	public void Scenario2Generate() {
		clickElement(CartIcon);
		WaitElementVisible(ShoppingCartPageVisible);
		clickElement(CHeckout);
		takeScreenshot("CartPage");
		clickElement(CHeckoutAsGuest);
		WaitElementVisible(BillingAddressVisible);
		FieldValue(FirstName, "Sakif");
		FieldValue(lastName, "Ah");
		FieldValue(Email, "sakif@gmail.com");
		clickElement(SelectCountry);
		Scrolling(153, 1851, 583, 531);
		Scrolling(385, 1886,635,610 );

		clickElement(CountryName);
		clickElement(SelectState);
		clickElement(StateName);
		FieldValue(Company, "Own");
		FieldValue(City, "Dhaka");
		takeScreenshot("Details Input");
		Scrolling(316, 1691,677,601);
		FieldValue(StreetAddress1, "Dhanmondi");
		FieldValue(ZipCOde, "1200");
		FieldValue(Number, "09875361");
		clickElement(ContinueButton);
		WaitElementVisible(NextDayAirVisibleOption);
		clickElement(NextDayAirVisibleOption);
		Scrolling(403, 1448,656, 833);
		clickElement(ContinueButton2);
		WaitElementVisible(PaymentPageVisible);
		Scrolling(149, 1743, 837, 90);
		Scrolling(226, 1736, 875, 188);
		clickElement(CheckOrMoneyOrder);
		takeScreenshot("Payment Details");
		clickElement(PressContinue);
		WaitElementVisible(PaymentInfoPageVisible);
		clickElement(nextButton);
		WaitElementVisible(ConfirmPagevisible);
		clickElement(ConfirmButton);
		WaitElementVisible(VisiblePopupMessage);
		takeScreenshot("Confirmation message");
	}
}

```
### Test Run of Customer Placing Order Procedure
PackageName: TestCases  
ClassName: PlaceOrder 
Overview of this TestCase class:  
* PlaceOrder class represents the automation script for the "Customer Placing Order Procedure."
 * It extends the DriverSetup class, inheriting the setup and teardown methods for the AndroidDriver.
  * The scenario involves the steps for a customer to place an order, from adding items to the cart
 * to confirming the order placement successfully.


```ruby
package TestCases;
import java.net.MalformedURLException;
import org.testng.annotations.Test;
import MobileConfig.DriverSetup;
import Utilities.CartElements;
import Utilities.ElementsUptoAddTOCart;

public class PlaceOrder extends DriverSetup{
	ElementsUptoAddTOCart addtocart = new ElementsUptoAddTOCart();
	CartElements cart = new CartElements();
	@Test (description = "Scenario 02 : Given: Mike go to shopping cart by clicking top cart icon\r\n"
			+ "When: Mike click checkout button from shopping cart page\r\n"
			+ "And: Mike select checkout as guest from shopping cart page\r\n"
			+ "Then: Mike input all the details in checkout billing details page and click continue\r\n"
			+ "And: Mike select \"Next Day Air\" as shipping method and click continue\r\n"
			+ "And: Mike select \"Check/Money Order\" as payment method and click continue\r\n"
			+ "And: Mike click next button on payment information page\r\n"
			+ "Then: Mike click confirm button to place the order\r\n"
			+ "And: Verify order place successfully with popup message \"Your order has been successfully processed!\"")
	public void OrderReplace() throws MalformedURLException{
		addtocart.GoToSelect();
		cart.Scenario2Generate();
		
	}
}

```
Execution Result image:  
![Scenario2](https://github.com/Sakif1997/Mobile-Application-Automation-POM/assets/45315685/d123439f-0f59-4419-be2b-fbef75d99dd7)
  



## Allure Report Creation

To create an allure report, first set dependency in the pom.xml file.  
```ruby
        <dependency>
				<groupId>io.qameta.allure</groupId>
				<artifactId>allure-testng</artifactId>
				<version>2.19.0</version>
		</dependency>
```
* Create some methods for allure report (like allure ScreenShot) which is added already
```ruby
public void takeScreenshot(String name) {
		Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES)));
	}
```
     
* then run the testing.xml file  
* then refresh the whole package and see a "allure-results" file created under Maven Dependencies  
-after runing the testng.xml file and refresh the whole package allure reasult appear
![ConvertToTestNg](https://github.com/Sakif1997/Mobile-Application-Automation-POM/assets/45315685/df15b9fc-1152-4f09-a0ff-5fbcb21ba56e)

* To get allure report open the whole package terminal  
* then write in terminal to clean previous files>   
```ruby
allure generate ./allure-results --clean
```

* then write in terminal to create allure report>   
```ruby
allure open ./allure-report
```
* terminal gives us http to show us an allure report file directory
Terminal image:  
![Terminal](https://github.com/Sakif1997/Mobile-Application-Automation-POM/assets/45315685/7324597c-ff59-4b4a-9ca1-543680de2589)



### Allure Report Overview Image
#### Scenario 1 Cases  
![Scenario1Suite](https://github.com/Sakif1997/Mobile-Application-Automation-POM/assets/45315685/c6a1452c-eda8-4118-96f0-a953fcae222e)  
![Scenario1Suite2](https://github.com/Sakif1997/Mobile-Application-Automation-POM/assets/45315685/6b9e53e6-4aaf-4a9f-8b45-38c886d15162)
![Scenario1Suite3](https://github.com/Sakif1997/Mobile-Application-Automation-POM/assets/45315685/57ffc418-bb06-48df-bc60-1f583b764dce)

#### Scenario 2 Cases  
![Scenario2Suite1](https://github.com/Sakif1997/Mobile-Application-Automation-POM/assets/45315685/874f7756-840a-4ad3-9994-30a4e096fe60)
![Scenario3Suite2](https://github.com/Sakif1997/Mobile-Application-Automation-POM/assets/45315685/b73122fe-5231-404a-8992-ec54076b6abf)
![Scenario2Suite3](https://github.com/Sakif1997/Mobile-Application-Automation-POM/assets/45315685/2978a04f-a183-467e-84f0-501e9876299d)
![Scenario2Suite4](https://github.com/Sakif1997/Mobile-Application-Automation-POM/assets/45315685/c0152061-7d92-4abf-8ab5-8b5edd1f375b)

## Video of Test Execution  
https://drive.google.com/file/d/1ua-UF1miyATyFo5dKQfzebNfTMbbEwZi/view?usp=drive_link
