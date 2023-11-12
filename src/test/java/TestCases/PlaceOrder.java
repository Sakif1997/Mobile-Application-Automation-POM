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
