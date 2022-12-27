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

}
