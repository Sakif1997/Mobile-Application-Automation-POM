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
