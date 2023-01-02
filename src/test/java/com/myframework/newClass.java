package com.myframework;

import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.myframework.config.TestBase;
import com.myframework.keywords.UIKeywords;

public class newClass extends TestBase{
	@Test
	public  void verifySearchResultForPoloWomen() throws InterruptedException {
		UIKeywords.launchUrl("https://www.myntra.com");
		UIKeywords.enterText(By.xpath("//input[@placeholder='Search for products, brands and more']"),"polo men");
		UIKeywords.hitbutton(KeyEvent.VK_ENTER);
		UIKeywords.clickbutton(By.linkText("Women"));
}
}