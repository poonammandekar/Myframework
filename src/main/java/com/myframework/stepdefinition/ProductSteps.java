package com.myframework.stepdefinition;

import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.myframework.keywords.UIKeywords;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class ProductSteps {

	@Given("Verify search result for polo men.")
	public void launchBrowser() {
		UIKeywords.openBrowser("Chrome");
	}
	
	@And("The Chrome browser shuold be open.")
	public void launchURL() {
		UIKeywords.launchUrl("https://www.myntra.com");
	}
	
	
	@When("User search for polo t shirt.")
	public void searchforPoloTshirt() {
		
	UIKeywords.enterText(By.xpath("//input[@placeholder='Search for products, brands and more']"),"polo men");
	UIKeywords.hitbutton(KeyEvent.VK_ENTER);
	
	
	}
	
	@Then("All result should be related to polo.")
	public void getSearchResult(){
	{
		List<String> productTitles=UIKeywords.getTexts(By.xpath("//h4[@class='product-product']"));
		System.out.println(productTitles);
		for(String productTitle:productTitles) {
			Assert.assertTrue(productTitle.contains("Polo"),"Product title doesn't contain polo: "+productTitle);
		}
	}
	}
}
