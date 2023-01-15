package com.fasttrack.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fasttrack22.keywords.UIKeywords;

public class MenTshirtsPage {

	@FindBy(xpath="//div[@class=\"sort-sortBy\"]")
	public WebElement sortByFilter;
	
	@FindBy(xpath="//div[@class=\"desktop-navLink\"]/a[@href=\"/shop/men\"]")
	public WebElement countryOfOrigin;
	
	@FindBy(xpath="//div[@class='sort-sortBy']/span[contains(text(),'Recommended')]")
	public WebElement recommendedFilter;
	
	@FindBy(xpath="//div[@class='sort-sortBy']/span[contains(text(),'Recommended')]")
	public WebElement popularityFilter;
	
	public MenTshirtsPage(){
		/*sortByFilter=UIKeywords.driver.findElement(By.xpath("//div[@class=\"sort-sortBy\"]"));
		
		recommendedFilter=UIKeywords.driver.findElement(By.xpath("//div[@class='sort-sortBy']/span[contains(text(),'Recommended')]"));
		recommendedFilter=UIKeywords.driver.findElement(By.xpath("//div[@class='sort-sortBy']/span[contains(text(),'Recommended')]"));*/
		PageFactory.initElements(UIKeywords.driver, this);
	}
	
	public void clickonSortByFilter(){
		sortByFilter.click();
	}
	public void selectPopularityFilter() {
		UIKeywords.mouseMove(recommendedFilter);
		UIKeywords.click(popularityFilter);
	}
}

