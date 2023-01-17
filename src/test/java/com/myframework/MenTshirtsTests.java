package com.fasttrack22;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.fasttrack.pages.HomePage;
import com.fasttrack.pages.MenTshirtsPage;
import com.fasttrack22.config.TestBase;
import com.fasttrack22.keywords.UIKeywords;
import com.fasttrack22.util.Enviornment;
import com.fasttrack22.util.WaitFor;

public class MenTshirtsTests extends TestBase {
	
	UIKeywords keyword=new UIKeywords();
	
	@Test
	public void verifyIfSearchByPopularityYeildsProperResults()
	{
		UIKeywords.launchUrl(Enviornment.URL);
		HomePage home=new HomePage();
		//HomePage home=PageFactory.initElements(UIKeywords.driver, HomePage.class);
		home.hoverOnMenMenu();
		home.clickOnMenTshirt();
		
		MenTshirtsPage menTshirt=new MenTshirtsPage();
		WaitFor.elementToBePresent(menTshirt.sortByFilter);
		menTshirt.selectPopularityFilter();              
	}
}
