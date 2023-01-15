package com.myframework.keywords;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.interactions.Actions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class UIKeywords {

	public static RemoteWebDriver driver;
	private static final Logger log=Logger.getLogger(UIKeywords.class);
	
	
	public static void openBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("Chrome")) {
			ChromeOptions option=new ChromeOptions();
			option.addArguments("--disable-notifications","start-maximized");
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(option);
			log.info(browserName+"browser is launched successfully.");
		}
		else if(browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			log.info(browserName+"browser is launched successfully.");
		}
		else if(browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			log.info(browserName+"browser is launched successfully.");
		}
		else if(browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			log.info(browserName+"browser is launched successfully.");
		}
	}
	
	public static void launchUrl(String url) {
		driver.get(url);
		log.info(url+ " is launched");
	}
	
	public static void closeBrowser() {
		driver.close();
		log.info("browser is closed successfully ");
	}
	
	public static void switchToWindow(String byTitle) {
		String parentWindow=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		String title=driver.getTitle();
		for(String window:windows) {
			if(driver.switchTo().window(window).getTitle().equals(byTitle));
			{
				log.info("Switched to window "+byTitle);
				break;
			}
		}
		
	}

	public static void enterText(String LocatorType, String LocatorValue,String text) {
		// TODO Auto-generated method stub
		getWebElement(LocatorType,LocatorValue).sendKeys(text);;
	}
	
	public static void hitbutton(int keyCode)
	{
		Robot robo =null;
		try {
			robo=new Robot();
		}catch(AWTException e) {
			e.printStackTrace();
			log.error("Unable to instantiate robot class instance");
		}
		robo.keyPress(keyCode);
		robo.keyRelease(keyCode);
		log.info("Enter key is press");
		
	}

	public static List<String> getTexts(String LocatorType, String LocatorValue) {
		// TODO Auto-generated method stub
		
		List<WebElement> elements=getWebElements(LocatorType,LocatorValue);
		List<String> texts=new ArrayList<String>();
		for(WebElement elmnt:elements)
		{
			texts.add(elmnt.getText());
		}
		return texts;
	}

	public static void clickButton(String locatorType,String locatorValue)  {
		// TODO Auto-generated method stub
		getWebElement(locatorType,locatorValue).click();
		
	}

	public static void getCalendarDate(String string) {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		
	}

	public static void maxWindow() {
		// TODO Auto-generated method stub
		driver.manage().window().maximize();
	}

	public static void mouseMove(String locatorType,String locatorValue) {
		// TODO Auto-generated method stub
		Actions act=new Actions(driver);
		act.moveToElement(getWebElement(locatorType,locatorValue)).perform();
	}

	public static WebElement getWebElement(String locatorType,String locatorValue) {
		WebElement element=null;
		if(locatorType.equalsIgnoreCase("xpath"))
		{
			element=driver.findElement(By.xpath(locatorValue));
		}
		if(locatorType.equalsIgnoreCase("id"))
		{
			element=driver.findElement(By.id(locatorValue));
		}if(locatorType.equalsIgnoreCase("name"))
		{
			element=driver.findElement(By.name(locatorValue));
		}if(locatorType.equalsIgnoreCase("tagname"))
		{
			element=driver.findElement(By.tagName(locatorValue));
		}if(locatorType.equalsIgnoreCase("class"))
		{
			element=driver.findElement(By.className(locatorValue));
		}if(locatorType.equalsIgnoreCase("linktext"))
		{
			element=driver.findElement(By.linkText(locatorValue));
		}if(locatorType.equalsIgnoreCase("partiallinktext"))
		{
			element=driver.findElement(By.partialLinkText(locatorValue));
		}
		if(locatorType.equalsIgnoreCase("css"))
		{
			element=driver.findElement(By.cssSelector(locatorValue));
		}
		
		return element;
	}
	
	
	public static List<WebElement> getWebElements(String locatorType,String locatorValue) {
		List<WebElement> elements=null;
		if(locatorType.equalsIgnoreCase("xpath"))
		{
			elements=driver.findElements(By.xpath(locatorValue));
		}
		if(locatorType.equalsIgnoreCase("id"))
		{
			elements=driver.findElements(By.id(locatorValue));
		}if(locatorType.equalsIgnoreCase("name"))
		{
			elements=driver.findElements(By.name(locatorValue));
		}if(locatorType.equalsIgnoreCase("tagname"))
		{
			elements=driver.findElements(By.tagName(locatorValue));
		}if(locatorType.equalsIgnoreCase("class"))
		{
			elements=driver.findElements(By.className(locatorValue));
		}if(locatorType.equalsIgnoreCase("linktext"))
		{
			elements=driver.findElements(By.linkText(locatorValue));
		}if(locatorType.equalsIgnoreCase("partiallinktext"))
		{
			elements=driver.findElements(By.partialLinkText(locatorValue));
		}
		if(locatorType.equalsIgnoreCase("css"))
		{
			elements=driver.findElements(By.cssSelector(locatorValue));
		}
		
		return elements;
	}
	
	
	public static By returnLocator(String locatorType,String locatorValue)
	{
		By by=null;
		if(locatorType.equalsIgnoreCase("xpath"))
		{
			 by=By.xpath(locatorValue);
		}
		if(locatorType.equalsIgnoreCase("id"))
		{
			by=By.id(locatorValue);
		}if(locatorType.equalsIgnoreCase("name"))
		{
			by=By.name(locatorValue);
		}if(locatorType.equalsIgnoreCase("tagname"))
		{
			by=By.tagName(locatorValue);
		}if(locatorType.equalsIgnoreCase("class"))
		{
			by=By.className(locatorValue);
		}if(locatorType.equalsIgnoreCase("linktext"))
		{
			by=By.linkText(locatorValue);
		}if(locatorType.equalsIgnoreCase("partiallinktext"))
		{
			by=By.partialLinkText(locatorValue);
		}
		if(locatorType.equalsIgnoreCase("css"))
		{
			by=By.cssSelector(locatorValue);
		}
		return by;
	}

	public static void mouseMove(WebElement menMenu) {
		// TODO Auto-generated method stub
		Actions act=new Actions(driver);
		act.moveToElement(menMenu).perform();
	}

	public static void click(WebElement element) {
		// TODO Auto-generated method stub
		element.click();
	}

	public static void enterText(WebElement searchComponent, String productName) {
		// TODO Auto-generated method stub
		searchComponent.sendKeys(productName);
	}
	
	
}

