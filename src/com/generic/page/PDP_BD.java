package com.generic.page;

import java.text.MessageFormat;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.generic.selector.PDPSelectors;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.SelTestCase;
import com.generic.util.SelectorUtil;

public class PDP_BD extends SelTestCase{

	
	// done - SMK
	public static String BDgetBottomPrice(String ProductID,boolean bundle) throws Exception {
		try {
			getCurrentFunctionName(true);
			String price = "";
			String selector;
			if(isMobile())
			selector = PDPSelectors.BDallSizes.get();
			else
			if(bundle)
			    selector = MessageFormat.format(PDPSelectors.BDListBoxBundle, ProductID) +">option:nth-child(2)";
			else
				selector = PDPSelectors.BDallSizes.get();
			String optionText = SelectorUtil.getElement(selector).getText();
            price = optionText.substring(optionText.lastIndexOf("$") + 1);
			getCurrentFunctionName(false);
			return price;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Bottom price  selector was not found by seleniuem", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	// done - SMK
	public static boolean BDselectSwatches(Boolean bundle, String ProductID) throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean	isPriceShownInOption = false;
				if(bundle) {
					isPriceShownInOption =	BDselectSwatchesBundle(ProductID);
				}else {
					isPriceShownInOption = true;
					PDP.FGGRselectSwatchesSingle();
				}
			getCurrentFunctionName(false);
			return isPriceShownInOption;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed + "select swatch was failed", new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static boolean BDselectSwatchesBundle(String ProductID) throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isSizeShownAsListbox = false;
			int numberOfSwatchContainers = PDP.getNumberofSwatchContainersBundle();
			if ( (numberOfSwatchContainers == 0) || PDP.getSwatchContainersdivClassBundle(0, ProductID).contains("no-options")) {
				logs.debug("No options to select");
			} else {
				String  ListSelector;
				if(isMobile())
				  ListSelector = PDPSelectors.BDallSizes.get();
				else
				  ListSelector = MessageFormat.format(PDPSelectors.BDListBoxBundle, ProductID);

				for (int i = 0; i < numberOfSwatchContainers; i++) {
					
					if (PDP.getSwatchContainersdivClassBundle(i, ProductID).contains("listbox") || !SelectorUtil.isNotDisplayed(PDPSelectors.BDallSizes.get())) {
						isSizeShownAsListbox = true;
						PDP.selectNthListBoxFirstValueBundle(ListSelector, i);
					} else {
							if(isMobile()) {
								SelectorUtil.initializeSelectorsAndDoActions(MessageFormat.format(PDPSelectors.BDimageOption.get(),1, i + 1, 1));
								WebElement element = SelectorUtil.getElement(MessageFormat.format(PDPSelectors.BDimageOption.get(),1, i + 1, 1));
								Actions action = new Actions(getDriver());
								action.moveToElement(element).click().build().perform();
					
							}else {
								PDP.selectNthOptionFirstSwatchBundle("css,#" + ProductID + " "
									+ MessageFormat.format(PDPSelectors.BDimageOption.get(), i + 1, 1).replace("css,", ""));
	
							}
					}
				}

			}
		
			getCurrentFunctionName(false);
			return isSizeShownAsListbox;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Select swatches has falied, a selector was not found by selenium", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
}
