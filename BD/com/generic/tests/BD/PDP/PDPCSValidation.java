package com.generic.tests.BD.PDP;

import org.openqa.selenium.WebElement;

import com.generic.page.CSPDP;
import com.generic.page.PDP;
import com.generic.selector.PDPSelectors;
import com.generic.setup.SelTestCase;
import com.generic.util.SelectorUtil;

public class PDPCSValidation extends SelTestCase {

	public static void validate(String searchTerm) throws Exception { 
		getCurrentFunctionName(true);
		 
		PDP.NavigateToPDP(searchTerm);
		sassert().assertTrue(CSPDP.validateTheRightPDP(searchTerm), "You are in the wrong PDP");
		
		CSPDP.selectConfiguration();
		CSPDP.selectFabric();
		sassert().assertTrue(CSPDP.validatePriceIsDisplayed(),
				"The price for the item is not dispayed"); 
		
		CSPDP.selectColor(); 
		
		if(!isMobile()) {
			CSPDP.pickOneQuantity();
		}
		String bottomPrice = CSPDP.getBottomPrice();
		sassert().assertTrue(!bottomPrice.equals("$0.00"),
				"Bottom price is not updated correctly, Current price: " + bottomPrice);
		Thread.sleep(2500);
		sassert().assertTrue(PDP.validateAddToWLGRIsEnabled(false, " "), "Add to WL/GR button is not enabled");
		sassert().assertTrue(PDP.validateAddToCartIsEnabled(false, " "), "Add to Cart button is not enabled");
		CSPDP.clickAddToCartButton();
		sassert().assertTrue(PDP.validateProductIsAddedToCart(), "Product is not added successfully");
	
		if(isMobile()) {
			CSPDP.closeMiniCart();
		}
		
		CSPDP.clickAddToOrderSwatch();
		sassert().assertTrue(CSPDP.validateOrderSwatch(), "The Order a Swatch Modal is not dispayed");
		sassert().assertTrue(CSPDP.validateOrderSwatchDropdown(), "The Order a Swatch Dropdown is not dispayed");
		sassert().assertTrue(CSPDP.validateSearchSwatchIsDisplayed(), "The Swatch Search Input is not dispayed");
		//sassert().assertTrue(CSPDP.validateSearchSwatchWorkedAsWell("black"), "The Swatch Search did not Work successfully");
		
		//Add Single Swatch
		CSPDP.clickAddSwatch('S');
		sassert().assertTrue(CSPDP.validateAddSwatchIsDisable(), "The Order a Swatch Modal is not disable");
		
		//Add Multiple Swatch
		CSPDP.clickAddSwatch('M');
		sassert().assertTrue(CSPDP.validateAddMoreThan10Swatchs(), "The Swatch Limitation Not Working");
		CSPDP.clickAddSwatchesToCartButton();
		Thread.sleep(5000);
		//Check if number of swatches added is 10 or Not
		sassert().assertTrue(CSPDP.validateNumAddedSwatchesIsRight(), "Number of Added Swatches is not Correct");
		sassert().assertTrue(PDP.validateProductIsAddedToCart(), "Swatches is not added successfully");
		 
		getCurrentFunctionName(false);
	}
}
