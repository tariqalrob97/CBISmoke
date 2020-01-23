package com.generic.setup;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;

public class PDPs extends SelTestCase {
	public static Random random = new Random();

	static String[] GHproducts = new String[] {
			"/frye-melissa-tote/shoes-accessories/bags-totes/400474?listIndex=1&uniqueId=400474",
			"/rough-26amp-3b-tumble-hobo-pack/shoes-accessories/bags-totes/554407?listIndex=2&uniqueId=554407",
			"/martell-studio-mixed-leather-26amp-3b-metal-bracelet/shoes-accessories/jewelry/559665?listIndex=4&uniqueId=559665",
			"/hat-attack-rancher-hat/shoes-accessories/hats-gloves-scarves/559655?listIndex=5&uniqueId=559655",
			"/ann-lightfoot-chrysoprase-bracelet/shoes-accessories/jewelry/559677?listIndex=14&uniqueId=559677",
			"/chan-luu-jasper-drop-earrings/shoes-accessories/jewelry/559678?listIndex=13&uniqueId=559678",
			"/satomi-studio-beaded-disc-earrings/shoes-accessories/jewelry/559672?listIndex=12&uniqueId=559672",
			"/satomi-studio-beaded-disc-earrings/shoes-accessories/jewelry/559672?listIndex=12&uniqueId=559672" };

	static String[] BDproducts = new String[] {};

	static String[] GRproducts = new String[] {};

	static String[] FGproducts = new String[] {};

	static String[] RYproducts = new String[] {"/latico-morgan-convertible-bag/store/accessories/538279?isCrossSell=true&strategy=65&gtmPageName=May%20We%20Suggest-PDP2",
			"/latico-diamond-tote-bag/538278?listIndex=6&uniqueId=538278",
			"/mar-y-sol-leah-shoulder-bag/543255?listIndex=1&uniqueId=543255",
			"/chan-luu-bead-bracelets/store/jewelry/543721?isCrossSell=true&strategy=69&gtmPageName=May%20We%20Suggest-PDP",
			"/satya-mixed-metal-cuff/store/jewelry/543724?isCrossSell=true&strategy=69&gtmPageName=May%20We%20Suggest-PDP",
			"/chan-luu-charm-necklace/store/jewelry/543723?isCrossSell=true&strategy=69&gtmPageName=May%20We%20Suggest-PDP"
			};

	public static void navigateToRandomPDP() throws URISyntaxException {
		getCurrentFunctionName(true);

		int randomIndex;
		String productURL;

		if (isGH()) {
			randomIndex = random.nextInt(GHproducts.length - 1);
			productURL = GHproducts[randomIndex];
		} else if (isRY()) {
			randomIndex = random.nextInt(RYproducts.length - 1);
			productURL = RYproducts[randomIndex];
		} else if (isGR()) {
			randomIndex = random.nextInt(GRproducts.length - 1);
			productURL = GRproducts[randomIndex];

		} else if (isFG()) {
			randomIndex = random.nextInt(FGproducts.length - 1);
			productURL = FGproducts[randomIndex];

		} else {
			randomIndex = random.nextInt(BDproducts.length - 1);
			productURL = BDproducts[randomIndex];
		}

		getDriver().get(new URI(getDriver().getCurrentUrl()).resolve(productURL).toString());

		getCurrentFunctionName(false);

	}//Navigate Method


}//Class
