package com.fasttrack22;

import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.fasttrack22.config.TestBase;
import com.fasttrack22.keywords.UIKeywords;

public class RedbusValidation extends TestBase {
	

	@Test
	public static void verifyBusesRoute() throws InterruptedException {
		
		
	UIKeywords.launchUrl("https://www.redbus.in/");
	Thread.sleep(3000);
	//UIKeywords.getTitle();
	UIKeywords.enterText(By.cssSelector("#src"),"Nagpur");
	Thread.sleep(9000);
	UIKeywords.hitbutton(KeyEvent.VK_ENTER);
	Thread.sleep(5000);
	UIKeywords.enterText(By.cssSelector("#dest"),"Pune");
	Thread.sleep(9000);
	
	
	UIKeywords.getCalendarDate("1-Oct-2022");
	
	
	/*UIKeywords.enterText(By.cssSelector("#onward_cal"),"1-Oct-2022");
	Thread.sleep(3000);
	
	UIKeywords.hitbutton(KeyEvent.VK_ENTER);
	Thread.sleep(30000);*/
	
	UIKeywords.clickButton(By.xpath("//button[@id=\"search_btn\"]"));

	
	}

}
