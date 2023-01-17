package com.fasttrack22;

import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasttrack22.config.TestBase;
import com.fasttrack22.keywords.UIKeywords;
import com.fasttrack22.util.PropUtil;

public class ProductTestCase extends TestBase{

	@Test

	public static void verifySearchResultForPoloMen() throws InterruptedException {
		PropUtil repository=new PropUtil();
		UIKeywords.openBrowser("Chrome");
		UIKeywords.launchUrl("https://www.myntra.com/");
		Thread.sleep(5000);
		UIKeywords.enterText(By.xpath(repository.getLocator("search_products_txtBx")),"Polo men");
		UIKeywords.hitbutton(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		List<String> productTitles=UIKeywords.getTexts(By.xpath(repository.getLocator("product_titles_txt")));
		
		for(String productTitle:productTitles) {
			Assert.assertTrue(productTitle.contains("polo"),"Product title doesn't contain polo: "+productTitle);
		}
		
		
	}
}
