package com.fasttrack.pages;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.fasttrack22.keywords.UIKeywords;

public class HomePage {

		private static final Logger log=Logger.getLogger(HomePage.class);
		@FindBy(xpath="//div[@class=\"desktop-navLink\"]/a[@href=\"/shop/men\"]")
		public WebElement menMenu;
		
		@FindBy(xpath="//a[@href=\"/men-tshirts\"]")
		public WebElement menTShirt;

		@FindBy(xpath="(//li[@class=\"desktop-oddColumnContent\"])[1]/descendant::a[contains(text(),\"Casual\")]")
		public WebElement casualShirts;
		
		/*public HomePage(){
			menMenu=UIKeywords.driver.findElement(By.xpath("//div[@class=\"desktop-navLink\"]/a[@href=\"/shop/men\"]"));
			menTShirt=UIKeywords.driver.findElement(By.xpath("//a[@href=\"/men-tshirts\"]"));
			
		}*/
		
		@FindBy(css="div.desktop-query>input.desktop-searchBar")
		public WebElement searchComponent; 
		
		@FindBy(css="h3.product-brand")
		public List<WebElement> productTexts;
		
		public HomePage(){
			PageFactory.initElements(UIKeywords.driver, this);
		}
		public void hoverOnMenMenu()
		{
			UIKeywords.mouseMove(menMenu);
		}
		
		public void clickOnMenTshirt() {
			UIKeywords.click(menTShirt);
		}
		public void clickOnCasualShirts() {
			// TODO Auto-generated method stub
			casualShirts.click();
			log.info("Clicked on Casual Shirts");
		}
		
		public void searchProduct(String productName)
		{
			UIKeywords.enterText(searchComponent,productName);
			UIKeywords.hitbutton(KeyEvent.VK_ENTER);
		}
		public List<String> getSearchResultTexts() {
			// TODO Auto-generated method stub
			List<String> productTexts=new ArrayList<String>();
			for(WebElement product:this.productTexts) {
				productTexts.add(product.getText());
			}
			return productTexts;
		}
}
