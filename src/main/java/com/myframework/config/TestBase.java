package com.myframework.config;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.myframework.keywords.UIKeywords;



public class TestBase {
	@Parameters("browser-name")
	@BeforeMethod
	public void setUP(@Optional String browserName) throws Exception {
		// TODO Auto-generated method stub
		if(browserName==null) {
			browserName="Chrome";
			System.out.println("Setting default browser as chrome");
		}
		if(browserName.isEmpty())
		{
			browserName="Chrome";
			System.out.println("Setting default browser as chrome");
		}
		UIKeywords.openBrowser(browserName);
	}
	
	
	public void teardown()
	{
		UIKeywords.closeBrowser();
		System.out.println("Browser close successfully");
	}
}



