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
