package com.generic.page;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;

import com.generic.setup.ExceptionMsg;
import com.generic.setup.SelTestCase;
import com.generic.util.SelectorUtil;
import com.generic.selector.PDPSelectors;


public class CSPDP extends SelTestCase {
	
	public static boolean validateTheRightPDP(String targetedItem) throws Exception {
		boolean isRightItem = false;
		try {
			getCurrentFunctionName(true);
			logs.debug("Validate if you are in the right PDP");
			
			String itemTitle = SelectorUtil.getElement(PDPSelectors.BDCSItemTitle.get()).getText();
			isRightItem = itemTitle.contains("Slipcover");
			 
			return isRightItem;
		}catch(NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "PDP Item Title selector was not found by selenium", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
		
	}
	
	public static void selectConfiguration() throws Exception {
		try {
			getCurrentFunctionName(true);
			String subStrArr = PDPSelectors.BDCSConfigOptions.get();
			List<WebElement> configOptions = new ArrayList<>();
			configOptions = SelectorUtil.getAllElements(subStrArr);
			int numberOfAvaibleOptions = configOptions.size();
			
			if (numberOfAvaibleOptions > 0) {
			    WebElement selectedElement = SelectorUtil.getRandomWebElement(configOptions);
				SelectorUtil.clickOnWebElement(selectedElement);
			logs.debug("The configuration Selected is :" + selectedElement.getText());
			}else {
				logs.debug("There is No configuration options");
			}
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Configuration selector was not found by seleniuem", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void selectFabric() throws Exception {
		try {
			getCurrentFunctionName(true);
			String subStrArr = PDPSelectors.BDCSFabricOptions.get();
			List<WebElement> FabricOptions = new ArrayList<>();
			FabricOptions = SelectorUtil.getAllElements(subStrArr);
			int numberOfAvaibleOptions = FabricOptions.size();
			
			if (numberOfAvaibleOptions > 0) {
			    WebElement selectedElement = SelectorUtil.getRandomWebElement(FabricOptions);
				SelectorUtil.clickOnWebElement(selectedElement);
			logs.debug("The Fabric Selected is :" + selectedElement.getText());
			}else {
				logs.debug("There is No Fabric options");
			}
			//Reset The Fabric by select the default option
			SelectorUtil.clickOnWebElement(FabricOptions.get(0));
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Fabric selector was not found by seleniuem", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static WebElement selectColor() throws Exception {
		try {
			getCurrentFunctionName(true); 
			WebElement selectedElement = null;
			String subStrArr = PDPSelectors.BDCSColorOptions.get();
			List<WebElement> ColorOptions = new ArrayList<>();
			ColorOptions = SelectorUtil.getAllElements(subStrArr);
			int numberOfAvaibleOptions = ColorOptions.size();
			
			if (numberOfAvaibleOptions > 0) {
			    selectedElement = SelectorUtil.getRandomWebElement(ColorOptions);
				SelectorUtil.clickOnWebElement(selectedElement);
			
			
			}else {
				logs.debug("There is No Color options");
			}
			getCurrentFunctionName(false);
			return selectedElement;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Color selector was not found by seleniuem", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static boolean validatePriceIsDisplayed() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed;
			logs.debug("Validate if price exist");
			String selector = PDPSelectors.BDCSPrice.get();
			isDisplayed = SelectorUtil.isDisplayed(selector);
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "price selector was not found by seleniuem", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void pickOneQuantity() throws Exception {
		try {
			
			String subStrArr = PDPSelectors.BDCSIncrement.get();
			WebElement increment = SelectorUtil.getElement(subStrArr);
			
			SelectorUtil.clickOnWebElement(increment);
			logs.debug("Select One Item");
		
			getCurrentFunctionName(false);
			
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Color selector was not found by seleniuem", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static String getBottomPrice() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Validate if bottom price is updated after seleting options");
			String selector;
		    selector = PDPSelectors.BDCSBottomPrice.get();
			SelectorUtil.initializeSelectorsAndDoActions(selector);
			String price = SelectorUtil.textValue.get();
			getCurrentFunctionName(false);
			return price;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Bottom of PDP Price selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	
	}
	
	public static void clickAddToCartButton() throws Exception {
		try {
			getCurrentFunctionName(true);
			String subStrArr = null;
			subStrArr = PDPSelectors.BDaddToCartBtn.get();
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Add to cart button selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void clickAddToOrderSwatch() throws Exception {
		try {
			getCurrentFunctionName(true);
			String subStrArr = null;
			subStrArr = PDPSelectors.OrderASwatchButton.get();
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Order a Swatch button selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static boolean validateOrderSwatch() throws Exception {
		try { 
			getCurrentFunctionName(true);
			boolean isDisplayed;
			isDisplayed = SelectorUtil.isDisplayed(PDPSelectors.OrderASwatchModal.get());
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Oreder a Swatch modal selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static boolean validateOrderSwatchDropdown() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed;
			isDisplayed = SelectorUtil.isDisplayed(PDPSelectors.OrderSwatchsDropdown.get());
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Oreder a Swatch Dropdown selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static boolean validateSearchSwatchIsDisplayed() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed;
			isDisplayed = SelectorUtil.isDisplayed(PDPSelectors.SearchSwatchInput.get());
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Swatch Search selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static boolean validateSearchSwatchWorkedAsWell(String searchTerm) throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isWorked = false;
			String selector = PDPSelectors.SearchSwatchInput.get();
			SelectorUtil.initializeSelectorsAndDoActions(selector, searchTerm);
			List<WebElement> searchResults = new ArrayList<>();
			searchResults = getAllSwatchSearchResult();
			Thread.sleep(5000);
			
			int numberOfAvaibleOptions = searchResults.size();
			
			if (numberOfAvaibleOptions > 0) {
			    WebElement selectedElement = SelectorUtil.getRandomWebElement(searchResults);
			    String descOfSelectedItem = selectedElement.getAttribute("alt");
			    isWorked = descOfSelectedItem.toLowerCase().contains(searchTerm.toLowerCase()) ? true : false ;
			}else {
				logs.debug("There is No Search Results to Validate it ..");
				
			}
			//Reset Or Clear the Search Input
			SelectorUtil.clickOnWebElement(SelectorUtil.getElement(PDPSelectors.ResetFilter.get()));
			getCurrentFunctionName(false);
			return isWorked;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Swatch Search selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static List<WebElement> getAllSwatchSearchResult() throws Exception{
		try {
			getCurrentFunctionName(true);
			String subStrArr = PDPSelectors.SearchSwatchResults.get();
			List<WebElement> searchResults = new ArrayList<>();
			searchResults = SelectorUtil.getAllElements(subStrArr);
			getCurrentFunctionName(false);
			return searchResults;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Search Result selector was not found by seleniuem", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static List<WebElement> getAllSuggestedSwatchs() throws Exception{
		try {
			getCurrentFunctionName(true);
			String subStrArr = PDPSelectors.SuggestedSwatchs.get();
			List<WebElement> searchResults = new ArrayList<>();
			searchResults = SelectorUtil.getAllElements(subStrArr);
			getCurrentFunctionName(false);
			return searchResults;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Suggested Swatchs selector was not found by seleniuem", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	//add single Swatch Or Multiple depend on the key value
	public static void clickAddSwatch(char key) throws Exception {
		try {
			getCurrentFunctionName(true);
			List<WebElement> allSwatches = getAllSuggestedSwatchs();
			if(key == 'S') {
				SelectorUtil.clickOnWebElement(allSwatches.get(0));
				logs.debug("Add a Swatch Successfully");
			}else {
				for(int i=1 ; i < 12 ; i++) {
					SelectorUtil.clickOnWebElement(allSwatches.get(i));
				}
				logs.debug("Add more than 10 swathes");
			}
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Add a Swatch button selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static boolean validateAddSwatchIsDisable() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisable;
			logs.debug("Validate if AddSwatch Buttom disabled ");
			String selector = PDPSelectors.firstSuggestedSwatch.get();
			isDisable = !SelectorUtil.getElement(selector).isEnabled();
			getCurrentFunctionName(false);
			return isDisable;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "price selector was not found by seleniuem", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static boolean validateAddMoreThan10Swatchs() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed;
			isDisplayed = SelectorUtil.isDisplayed(PDPSelectors.SwatchLimitMsg.get());
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Swatch Limitation Message selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void clickAddSwatchesToCartButton() throws Exception {
		try {
			getCurrentFunctionName(true);
			String subStrArr = null;
			subStrArr = PDPSelectors.AddSwatchesToCartBtn.get();
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Add Swatches to cart button selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static boolean validateNumAddedSwatchesIsRight() throws Exception {
		try {
			boolean isCorrectNum = true;
			getCurrentFunctionName(true);
			List<WebElement> addedSwatchesList = new ArrayList<>();
			addedSwatchesList = getAllAddedSwatches();
			int numberOfAddedItems = addedSwatchesList.size();
			
			if (numberOfAddedItems < 10) {
				isCorrectNum = false;
			}
			getCurrentFunctionName(false);
			return isCorrectNum;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Added Swatches Item selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static List<WebElement> getAllAddedSwatches() throws Exception{
		try {
			getCurrentFunctionName(true);
			String subStrArr = PDPSelectors.AddedSwatchesItems.get();
			List<WebElement> addedSwatchesList = new ArrayList<>();
			addedSwatchesList = SelectorUtil.getAllElements(subStrArr);
			getCurrentFunctionName(false);
			return addedSwatchesList;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Swatchs Item selector was not found by seleniuem", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	public static void closeMiniCart() throws Exception {
		try {
			getCurrentFunctionName(true);
			SelectorUtil.clickOnWebElement(SelectorUtil.getElement(PDPSelectors.closeMiniCart.get()));
			getCurrentFunctionName(false);
		}catch(NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Swatchs Item selector was not found by seleniuem", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
}
