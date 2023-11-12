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
	//scroll 139,1900,806,139
	public By CountryName= By.xpath("//android.widget.TextView[@text=\"Bangladesh\"]");
	public By SelectState = By.id("com.nopstation.nopcommerce.nopstationcart:id/stateSpinner");
	public By StateName = By.xpath("//android.widget.TextView[@text=\"ঢাকা\"]");
	public By Company = By.id("com.nopstation.nopcommerce.nopstationcart:id/etCompanyName");
	public By City = By.id("com.nopstation.nopcommerce.nopstationcart:id/etCity");
	//scroll 316, 1691,677,601
	public By StreetAddress1 = By.id("com.nopstation.nopcommerce.nopstationcart:id/etStreetAddress");
	public By ZipCOde = By.id("com.nopstation.nopcommerce.nopstationcart:id/etZipCode");
	public By Number = By.id("com.nopstation.nopcommerce.nopstationcart:id/etPhone");
	public By ContinueButton = By.id("com.nopstation.nopcommerce.nopstationcart:id/btnContinue");
	public By NextDayAirVisibleOption = By.xpath("//android.widget.TextView[@text=\"Next Day Air\"]");
	//Scroll 403, 1448,656, 833
	public By ContinueButton2 =By.id("com.nopstation.nopcommerce.nopstationcart:id/btnContinue");
	public By PaymentPageVisible = By.xpath("//android.widget.TextView[@text=\"bKash Payment ($20.00)\"]");
	//Scrolling 149, 1743, 837, 90
	//scrolling 226, 1736, 875, 188
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
