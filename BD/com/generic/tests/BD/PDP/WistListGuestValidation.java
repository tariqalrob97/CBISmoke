package com.generic.tests.BD.PDP;

import com.generic.page.HomePage;
import com.generic.page.PDP;
import com.generic.page.PDP_BD;
import com.generic.page.PLP;
import com.generic.setup.SelTestCase;
import com.generic.setup.Common;
import com.generic.setup.GlobalVariables.browsers;

public class WistListGuestValidation extends SelTestCase {
	public static void validate() throws Exception {
		getCurrentFunctionName(true);
		if (isMobile())
			Common.refreshBrowser();
	    String selectedProductName = PDP.NavigateToPDP("Rugs");
	    Boolean bundle = PDP.getNumberOfItems() > 1;
		String ProductID = null;
		if (!isMobile() && bundle)
			ProductID = PDP.getProductID(0);
		PDP_BD.BDselectSwatches(bundle, ProductID);
		PDP.clickAddToWLGR();
		PDP.clickOnCreateNewWL();
		sassert().assertTrue(PDP.validateNameYourNewWLModalIsDisplayed(), "Name your new wish list modal is not dispayed");
        String WLName = PDP.getWishListName();
		PDP.createNewWL(WLName);		
		sassert().assertTrue(PDP.validateSelectRegistryOrWishListModalIsDisplayed(), " Select A Registry or Wish list modal is not dispayed");
		Thread.sleep(1000);
		sassert().assertTrue(PDP.validateCreatedWLisSelectedByDefault(WLName), "created wish list is not selected by default");
		PDP.clickOnCreateNewWLConfirmationBtn();

		sassert().assertTrue(PDP.validateConfirmationModalWithCorrectProductIsDisplayed(selectedProductName), " Confirmation Modal is not dispayed");
        logs.debug("selectedProductName"+selectedProductName);
		//validate if selected product displayed in the WL and click on add to cart button
		sassert().assertTrue(PDP.addedProductIsDisplayedInTheWL(selectedProductName), "Added product is not displayed in the Wish list");
		if (!isMobile()) {
		sassert().assertTrue(PDP.validateAddToCartModalIsDisplayed(), "Add to cart confirmation modal not displayed.");
		PDP.clickOnCheckout();
		sassert().assertTrue(PDP.addedProductIsDisplayedInShoppingCart(selectedProductName), "Product not added to the cart.");
		}
		
		getCurrentFunctionName(false);

	}
}