package com.fasttrack22;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasttrack.pages.CasualShirtsPage;
import com.fasttrack.pages.HomePage;
import com.fasttrack22.config.TestBase;
import com.fasttrack22.keywords.UIKeywords;
import com.fasttrack22.util.PropUtil;
import com.fasttrack22.util.WaitFor;
import com.fasttrack22.util.Enviornment;;


public class ProductTests extends TestBase {

	PropUtil repository=new PropUtil();
	
	@Test
	public  void verifySearchResultForPoloMen() throws InterruptedException {
		
		Enviornment env=new Enviornment();
		UIKeywords.launchUrl(Enviornment.URL);
		UIKeywords.maxWindow();
		UIKeywords.enterText(repository.getLocator("search_products_txtBx")[0],repository.getLocator("search_products_txtBx")[1],"polo men");
		UIKeywords.clickButton(repository.getLocator("search_icon")[0],repository.getLocator("search_icon")[1]);
		
		List<String> productTitles=UIKeywords.getTexts(repository.getLocator("product_titles_txt")[0],repository.getLocator("product_titles_txt")[1]);
		
		for(String productTitle:productTitles) {
			Assert.assertTrue(productTitle.contains("Polo"),"Product title doesn't contain polo: "+productTitle);
		}
		
	}
	
	
	/*public void verifyCategoryListForTopWears() {
		Enviornment env=new Enviornment();
		List<String> expected=new ArrayList<String>();
		expected.add("Tshirts");
		expected.add("Shirts");
		expected.add("Sweatshirts");
		expected.add("Kurtas");
		expected.add("Jackets");
		expected.add("Sweaters");
		expected.add("Blazers");
		UIKeywords.launchUrl(Enviornment.URL);
		UIKeywords.maxWindow();
		UIKeywords.mouseMove(repository.getLocator("men_menu")[0],repository.getLocator("men_menu")[1]);
		UIKeywords.clickButton(repository.getLocator("menu_topwear")[0],repository.getLocator("menu_topwear")[1]);
		WaitFor.elementToBePresent(repository.getLocator("categories_text")[0],repository.getLocator("categories_text")[1]);
		List<String> actualCategory=UIKeywords.getTexts(repository.getLocator("categories_text")[0],repository.getLocator("categories_text")[1]);
		System.out.println(actualCategory);
		for(int i=0;i<actualCategory.size();i++)
		{
			actualCategory.set(i,actualCategory.get(i).split("[(]")[0]);
		}
		Assert.assertTrue(actualCategory.containsAll(expected));
	}
	
	@Test
	public void verifyItemCountOfCasualShirts() {
		UIKeywords.launchUrl(Enviornment.URL);
		HomePage home=new HomePage();
		home.hoverOnMenMenu();
		home.clickOnCasualShirts();
		CasualShirtsPage casual=new CasualShirtsPage();
		int itemCount=casual.getItemCount();
		System.out.println(itemCount);
	}*/
}
