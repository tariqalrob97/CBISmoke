package com.generic.setup;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;

public class PDPs extends SelTestCase {
	public static Random random = new Random();
	
	public static class GranetHill {
		
		static String[] products = new String[] {
				  "/frye-melissa-tote/shoes-accessories/bags-totes/400474?listIndex=1&uniqueId=400474", 
				  "/rough-26amp-3b-tumble-hobo-pack/shoes-accessories/bags-totes/554407?listIndex=2&uniqueId=554407", 
				  "/martell-studio-mixed-leather-26amp-3b-metal-bracelet/shoes-accessories/jewelry/559665?listIndex=4&uniqueId=559665", 
				  "/hat-attack-rancher-hat/shoes-accessories/hats-gloves-scarves/559655?listIndex=5&uniqueId=559655",
				  "/ann-lightfoot-chrysoprase-bracelet/shoes-accessories/jewelry/559677?listIndex=14&uniqueId=559677",
				  "/chan-luu-jasper-drop-earrings/shoes-accessories/jewelry/559678?listIndex=13&uniqueId=559678",
				  "/satomi-studio-beaded-disc-earrings/shoes-accessories/jewelry/559672?listIndex=12&uniqueId=559672",
				  "/satomi-studio-beaded-disc-earrings/shoes-accessories/jewelry/559672?listIndex=12&uniqueId=559672"			  
				};
		
		
		
		public static void navigateToRandomPDP() throws URISyntaxException {
			getCurrentFunctionName(true);

			int randomIndex = random.nextInt(products.length-1);
			
			getDriver().get(new URI(getDriver().getCurrentUrl()).resolve(products[randomIndex]).toString());
			
			getCurrentFunctionName(false);

		}
		
		
		
	
	}//GH
	
	public static class BallrdDesigns {
		
		
		
		
		
		
	}//BD
	
	public static class Ryllace {
		
		
		
		
		
		
	}//RY
	
	public static class GrandInRoad {
		
		
		
		
		
		
	}//GR
	
	public static class FrontGate {
		
		
			
		
		
	}//FG
	

}
