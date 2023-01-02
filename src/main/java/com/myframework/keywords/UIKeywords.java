package com.myframework.keywords;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.apache.log4j.Logger;
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
	//private static final Logger log=Logger.getLogger(UIKeywords.class);
	
	
	public static void openBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("Chrome")) {
			ChromeOptions option=new ChromeOptions();
			option.addArguments("--disable-notifications","start-maximized");
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(option);
			System.out.println(browserName+"browser is launched successfully.");
		}
		else if(browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println(browserName+"browser is launched successfully.");
		}
		else if(browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			System.out.println(browserName+"browser is launched successfully.");
		}
		else if(browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			System.out.println(browserName+"browser is launched successfully.");
		}
	}
	
	public static void launchUrl(String url) {
		driver.get(url);
		System.out.println(url+ " is launched");
	}
	
	public static void closeBrowser() {
		driver.close();
		System.out.println("browser is closed successfully ");
	}
	
	public static void switchToWindow(String byTitle) {
		String parentWindow=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		String title=driver.getTitle();
		for(String window:windows) {
			if(driver.switchTo().window(window).getTitle().equals(byTitle));
			{
				System.out.println("Switched to window "+byTitle);
				break;
			}
		}
		
	}
	
	public static void enterText(By element,String text) {
		// TODO Auto-generated method stub
		driver.findElement(element).sendKeys(text);
	}
	
	public static void hitbutton(int keyCode)
	{
		Robot robo =null;
		try {
			robo=new Robot();
		}catch(AWTException e) {
			e.printStackTrace();
			System.out.println("Unable to instantiate robot class instance");
		}
		robo.keyPress(keyCode);
		robo.keyRelease(keyCode);
		System.out.println("Enter key is press");
		
	}
	
	public static List<String> getTexts(By element) {
		// TODO Auto-generated method stub
		
		List<WebElement> elements=driver.findElements(element);
		List<String> texts=new ArrayList<String>();
		for(WebElement elmnt:elements)
		{
			texts.add(elmnt.getText());
		}
		return texts;
	}

public static void clickbutton(By Element)
{
	driver.findElement(Element).click();
	System.out.println("men redio button pressed");
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

public static void maxWindow() {
	// TODO Auto-generated method stub
	driver.manage().window().maximize();
}

public static void mouseMove(String locatorType,String locatorValue) {
	// TODO Auto-generated method stub
	Actions act=new Actions(driver);
	act.moveToElement(getWebElement(locatorType,locatorValue)).perform();
}

}

