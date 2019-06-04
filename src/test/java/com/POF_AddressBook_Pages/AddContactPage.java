package com.POF_AddressBook_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddContactPage {
	WebDriver driver;
	//private int timeout = 15;
	//private final String pageLoadedText = "";
    //private final String pageUrl = "/";
	private By newcontactBtn = By.xpath("//div[@class='v-button v-widget']");
	private By savecontacttBtn = By.xpath("//div[@class='v-button v-widget primary v-button-primary']");
	public By cancelcontactBtn = By.xpath("//div[3]/div[@class='v-button v-widget' and 1]");
	private By firstnameTextbox = By.xpath("//input[@id='gwt-uid-5']");
	private By lastnameTextbox = By.xpath("//input[@id='gwt-uid-7']");
	private By phoneInputbox = By.xpath("//input[@id='gwt-uid-9']");
	private By emailInputbox = By.xpath("//input[@id='gwt-uid-11']");
	private By dobInputbox = By.xpath("//input[@id='gwt-uid-13']");
	private By firtstnameget = By.xpath("//div[@class='v-grid-tablewrapper']/table/tbody/tr[@class='v-grid-row v-grid-row-stripe v-grid-row-has-data']/td[@class='v-grid-cell'][1]");
	public AddContactPage(WebDriver driver) {
		   this.driver = driver; 
	       PageFactory.initElements(driver, this);
	}
	public  void addcontactaddressbook(String firstname , String lastname, String phone, String email, String dob) throws Exception {
		WebDriverWait wait=new WebDriverWait(driver, 40);
		
		//WebElement firtstnameget1 = driver.findElement(firtstnameget);
		WebElement newcontactbtn1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='v-button v-widget']")));
		newcontactbtn1.click();
		 if(newcontactbtn1.isDisplayed())
		 newcontactbtn1.click();
		 
		 Thread.sleep(5000);
		WebElement firstname1 = driver.findElement(firstnameTextbox);
		if(firstname1.isDisplayed())
		firstname1.sendKeys(firstname);
		WebElement lastname1 = driver.findElement(lastnameTextbox);
		if(lastname1.isDisplayed())
		 lastname1.sendKeys(lastname);
		 WebElement phone1 = driver.findElement(phoneInputbox);
		 if(phone1.isDisplayed())
		 phone1.sendKeys(phone);
		 WebElement email1 = driver.findElement(emailInputbox);
		 if(email1.isDisplayed())
		 email1.sendKeys(email);
		 WebElement dob1 = driver.findElement(dobInputbox);
		 if(dob1.isDisplayed())
		 dob1.sendKeys(dob);
		 WebElement savebtn1 = driver.findElement(savecontacttBtn);
		 if(savebtn1.isDisplayed())
		 savebtn1.click();
	}
	
	public  void canceladdcontactaddressbook() throws Exception {
		WebDriverWait wait=new WebDriverWait(driver, 40);
		WebElement newcontactbtn1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='v-button v-widget']")));
		newcontactbtn1.click();
		 if(newcontactbtn1.isDisplayed())
		 newcontactbtn1.click();
		 Thread.sleep(5000);
		 WebElement cancelbtn1 = driver.findElement(cancelcontactBtn);
	}
}
