package com.fasttrack22.util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.fasttrack22.keywords.UIKeywords;

public class WaitFor {

	private static FluentWait<WebDriver> wait=null;
	
	static{
		wait=new FluentWait<WebDriver>(UIKeywords.driver);
		wait.withTimeout(Duration.ofSeconds(30));
		wait.pollingEvery(Duration.ofMillis(500));
		wait.withMessage("wait is finished and element is not avilable");
	}
	
	

	public static void elementToBePresent(String locatorType, String locatorValue) {
		// TODO Auto-generated method stub
		wait.ignoring(NoSuchElementException.class, ElementClickInterceptedException.class);
		wait.until(ExpectedConditions.presenceOfElementLocated(UIKeywords.returnLocator(locatorType, locatorValue)));
	}



	public static void elementToBePresent(WebElement element) {
		// TODO Auto-generated method stub
		wait.ignoring(NoSuchElementException.class, ElementClickInterceptedException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}



	public static void time(int durationInSeconds) {
		// TODO Auto-generated method stub
		long startTime=System.currentTimeMillis();
		long endTime=startTime+(durationInSeconds*1000);
		while(startTime<=endTime)
		{
			startTime=System.currentTimeMillis();
		}
	}
}
