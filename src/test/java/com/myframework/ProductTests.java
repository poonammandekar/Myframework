package com.myframework;


import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.myframework.keywords.UIKeywords;
import com.myframework.config.TestBase;




public class ProductTests extends TestBase {
	
	@Test
	public  void verifySearchResultForPoloMen() throws InterruptedException {
		UIKeywords.launchUrl("https://www.myntra.com");
		UIKeywords.enterText(By.xpath("//input[@placeholder='Search for products, brands and more']"),"polo men");
		UIKeywords.hitbutton(KeyEvent.VK_ENTER);
		
		List<String> productTitles=UIKeywords.getTexts(By.xpath("//h4[@class='product-product']"));
		System.out.println(productTitles);
		for(String productTitle:productTitles) {
			Assert.assertTrue(productTitle.contains("Polo"),"Product title doesn't contain polo: "+productTitle);
		}
	}
}
