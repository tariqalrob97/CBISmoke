package com.generic.tests.GR.checkout;

import java.util.LinkedHashMap;
import com.generic.page.Cart;
import com.generic.page.CheckOut;
import com.generic.page.HomePage;
import com.generic.page.PayPal;
import com.generic.page.Registration;
import com.generic.page.Login;
import com.generic.setup.LoggingMsg;
import com.generic.setup.SelTestCase;

public class PayPalValidation extends SelTestCase {

	public static void validate(String userType, int productsCount, LinkedHashMap<String, String> userDetalis,
			LinkedHashMap<String, String> paymentDetails) throws Exception {

		// Perform login
		if (userType.contains("registered")) {
			String userMail = getSubMailAccount(userDetalis.get(Registration.keys.email));
			String userPassword = userDetalis.get(Registration.keys.password);
			Login.fillLoginFormAndClickSubmit(userMail, userPassword);
			sassert().assertTrue(Login.checkUserAccount(), LoggingMsg.USER_IS_NOT_LOGGED_IN_SUCCESSFULLY);
			if (SelTestCase.isMobile())
				HomePage.clickOnCloseButton();

		}

		// Add products to cart
		CheckOut.addRandomProductTocart(productsCount);

		// Navigating to Cart by URL
		CheckOut.navigatetoCart();

		Thread.sleep(1000);

		sassert().assertTrue(Cart.checkAddedItemTotalPriceDisplay(), "Cart page is not displayed");

		float subtotalValue = Float.parseFloat(Cart.getTotalPrice().replace("$", "").replace(",", "").trim());

		Cart.paypalBtnClick();
		String main = null;
		if (SelTestCase.isDesktop())
			main = CheckOut.paymentInnformation.switchToPayPalWindow();
		Thread.sleep(1000);
		if (PayPal.isPayPalModelDisplayed()) {
			String PayPalEmail = paymentDetails.get(CheckOut.paymentInnformation.keys.number);
			String PayPalPassword = paymentDetails.get(CheckOut.paymentInnformation.keys.CVCC);
			PayPal.signIn(PayPalEmail, PayPalPassword);
			sassert().assertTrue(PayPal.isPayPalShipToPageDisplayed(),
					"(PayPAl Ship to) page is not displayed");

			Thread.sleep(6000);

			if (userType.contains("registered")) {
				PayPal.clickOnContinueRegistered();
				PayPal.clickConfirmRegistered();
			}

			else {
				PayPal.clickOnContinue();

			}

			if (SelTestCase.isDesktop())
				CheckOut.paymentInnformation.switchBackToMainWindow(main);

			Thread.sleep(2000);
			CheckOut.clickCheckouStepFourConfirmationButton();

			if (CheckOut.isPaymentPageSelectedAndPayPalSelected()) {
				sassert().assertTrue(PayPal.isOrderSummaryDisplayed(), "Order summary is not displayed");
				float newSubTotal = Float.parseFloat(Cart.getTotalPrice().replace("$", "").replace(",", "").trim());
				sassert().assertTrue(subtotalValue == newSubTotal, "Subtotal value is incorrect");
				float shippingValue = Float.parseFloat(Cart.getShippingValue());
				float tax = Float.parseFloat(Cart.getTaxValue());
				CheckOut.clickPayPalOrderSubmit();
				Thread.sleep(3000);

				PayPal.closePayPalSubmitRegestration();
				sassert().assertTrue(PayPal.isSubmitConfermationMessageDisplayed(),
						"Order confirmation page is not displayed");

				sassert().assertTrue(PayPal.checkOrderNumberAndEmailAndShippingAddress(),
						"Order number or email or shipping address is not displayed");
				sassert().assertTrue(PayPal.checkConfirmationPageImg(), "Product image is not displayed");
				sassert().assertTrue(PayPal.isPayPalPayment(), "Payment type is PayPal");
				
				Thread.sleep(1500);
				CheckOut.printOrderIDtoLogs();
				
				float confirmationSubtotal = Float.parseFloat(PayPal.getConfirmationPageSubtotalValue());
				float confirmationTax = Float.parseFloat(PayPal.getConfirmationPageTaxValue());
				float confirmationShipping = Float.parseFloat(PayPal.getConfirmationPageShippingValue());
				float total = Float.parseFloat(PayPal.getConfirmationTotalValue());

				if (confirmationTax != tax)
					sassert().assertTrue(false, "Tax value is not same");
				if (confirmationSubtotal != subtotalValue)
					sassert().assertTrue(false, "Subtotal value is not same");
				if (confirmationShipping != shippingValue)
					sassert().assertTrue(false, "shipping value is not same");
				if (subtotalValue + tax + shippingValue != total)
					sassert().assertTrue(false, "Total value is not equales the sum of subtotal + tax + shipping");
			}
		}

	}

}