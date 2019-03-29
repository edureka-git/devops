package com.POF_AddressBook_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SortContactPage {
	WebDriver driver;
	
	private By firstnamehead = By.xpath("//th[1]/div[@class='v-grid-column-header-content v-grid-column-default-header-content' and 1]");
	private By lastnamehead = By.xpath("//th[2]/div[@class='v-grid-column-header-content v-grid-column-default-header-content' and 1]");
	private By emailhead = By.xpath("//th[3]/div[@class='v-grid-column-header-content v-grid-column-default-header-content' and 1]");
	private By firtstnameget = By.xpath("//div[@class='v-grid-tablewrapper']/table/tbody/tr[@class='v-grid-row v-grid-row-stripe v-grid-row-has-data'][1]/td[@class='v-grid-cell'][1]");
		
	
	public SortContactPage(WebDriver driver) {
		System.out.println("Driver in sort contactpage #########"+driver);
		this.driver = driver; 
	       PageFactory.initElements(driver, this);
	}
	
	public  void sortcontactbyfname() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 40);
		System.out.println("I am in sortcontact Page############");
		//WebElement firtstnameget1 = driver.findElement(firtstnameget);
		WebElement firstnamehead1= driver.findElement(firstnamehead);
		if(firstnamehead1.isDisplayed())
		firstnamehead1.click();
		
		
	}
	
	public  void sortcontactbylastname() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 40);
		System.out.println("I am in sortcontact Page############");
		//WebElement firtstnameget1 = driver.findElement(firtstnameget);
		WebElement lastnamehead1= driver.findElement(lastnamehead);
		if(lastnamehead1.isDisplayed())
			lastnamehead1.click();
		
		
	}
	
	public  void sortcontactbyemail() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 40);
		System.out.println("I am in sortcontact Page############");
		//WebElement firtstnameget1 = driver.findElement(firtstnameget);
		WebElement emailhead1= driver.findElement(emailhead);
		if(emailhead1.isDisplayed())
			emailhead1.click();
		
		
	}

}
