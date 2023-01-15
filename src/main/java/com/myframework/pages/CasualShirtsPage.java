package com.fasttrack.pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;

import com.fasttrack22.keywords.UIKeywords;

public class CasualShirtsPage {
	
	public By itemCount=By.xpath("//span[@class=\"title-count\"]");
	public int getItemCount() {
		String totalItem=UIKeywords.driver.findElement(itemCount).getText();
		
		Pattern p=Pattern.compile("/d");
		Matcher m=p.matcher(totalItem);
		String count=m.group();
		
		return Integer.parseInt(count);
	}

}