package com.POF_AddressBook_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchContactPage {
	WebDriver driver;
	
	private By searchInputbox = By.cssSelector("input.v-textfield");

	
	
	public SearchContactPage(WebDriver driver) {
		System.out.println("Driver in edit contactpage #########"+driver);
		this.driver = driver; 
	       PageFactory.initElements(driver, this);
	}
	
	public void searchcontact(String searchtext) throws InterruptedException{
		WebDriverWait wait=new WebDriverWait(driver, 40);
		System.out.println("I am in Searchcontact Page############");
		
		WebElement searchInputbox1 = driver.findElement(searchInputbox);
		if(searchInputbox1.isDisplayed())
		searchInputbox1.clear();	
		searchInputbox1.sendKeys(searchtext);
		System.out.println(" on search field.........");
	}

}


