package com.POF_AddressBook_Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.POF_AddressBook.Driver;
import com.POF_AddressBook_Pages.AddContactPage;
import com.epam.reportportal.testng.ReportPortalTestNGListener;

@Listeners({ReportPortalTestNGListener.class})
public class AddContactTest extends Driver{
	AddContactPage addcontactpage;
	//private By newcontactBtn = By.xpath("//div[@class='v-button v-widget']");
	@Test
	public void Addcontacttest1( ) throws Exception {
		//driver.navigate().refresh();
		System.out.println("In test 111111");
		System.out.println("Driver#########"+driver);
		addcontactpage = new AddContactPage(driver);
		addcontactpage.addcontactaddressbook("Sudheer12345", "Neelam", "9876543210", "sudheerkumarn@virtusa.com", "12/4/95"); 
		System.out.println("In the test1....!!");
		//WebDriverWait wait = new WebDriverWait(WebDriverRefrence,TimeOut);
		WebDriverWait wait = new WebDriverWait (driver, 20);
		
}
	@Test
	public void Addcontacttest2( ) throws Exception {
		driver.navigate().refresh();
		System.out.println("In test 22222");
		addcontactpage = new AddContactPage(driver);
		addcontactpage.addcontactaddressbook("Gopi12345", "Prashanth", "0987654321", "gopi@virtusa.com", "5/4/95"); 
		System.out.println("In the test2....!!");
		driver.navigate().refresh();
		String firtstnameget1 = driver.findElement(By.xpath("//div[@class='v-grid-tablewrapper']/table/tbody/tr[@class='v-grid-row v-grid-row-stripe v-grid-row-has-data'][1]/td[@class='v-grid-cell'][1]")).getText(); 
		System.out.println("This is firstname#$#$#$#$"+firtstnameget1);
				
		if (firtstnameget1.equals("Sudheer12345")) {
			System.out.println("Added contact Successfully");
		}
		else {
			System.out.println("Contact was not added");
		}
}
	
	@Test
	public void Addcontacttest3( ) throws Exception {
		//driver.navigate().refresh();
		System.out.println("In test 111111");
		System.out.println("Driver#########"+driver);
		addcontactpage = new AddContactPage(driver);
		addcontactpage.addcontactaddressbook("Sudheer3", "Neelam", "9876543210", "sudheerkumarn@virtusa.com", "12/4/95"); 
		System.out.println("In the test1....!!");
		
		
}
	
	@Test
	public void Addcontacttestempty( ) throws Exception {
		//driver.navigate().refresh();
		System.out.println("In test 33333");
		System.out.println("Driver#########"+driver);
		addcontactpage = new AddContactPage(driver);
		addcontactpage.addcontactaddressbook("", "", "", "", ""); 
		System.out.println("In the test3....!!");
		
}
	
	@Test
	public void Addcontactdobformat( ) throws Exception {
		//driver.navigate().refresh();
		System.out.println("In test 111111");
		System.out.println("Driver#########"+driver);
		addcontactpage = new AddContactPage(driver);
		addcontactpage.addcontactaddressbook("Sudheer4", "Neelam", "9876543210", "sudheerkumarn@virtusa.com", "abcdefghi"); 
		System.out.println("In the test1....!!");
		
}
	
	@Test
	public void Addcontacttestemailformat( ) throws Exception {
		//driver.navigate().refresh();
		System.out.println("In test 111111");
		System.out.println("Driver#########"+driver);
		addcontactpage = new AddContactPage(driver);
		addcontactpage.addcontactaddressbook("Sudheer5", "Neelam", "9876543210", "sudheerkumarn", "12/4/95"); 
		System.out.println("In the test1....!!");
		
		
}
	
	
	
	@Test
	public void CancelAddcontact() throws Exception{
		System.out.println("In Cancel button Test");
		addcontactpage.canceladdcontactaddressbook();
		WebElement cancelbtn1 = driver.findElement(By.xpath("//div[3]/div[@class='v-button v-widget' and 1]"));
		
		if(cancelbtn1.isDisplayed()){
			 cancelbtn1.click();
			 //cancelbtn1 = driver.findElement(By.xpath("//div[3]/div[@class='v-button v-widget' and 1]"));
			 if(cancelbtn1.isDisplayed()){
				 System.out.println("Failed to Cancel");
			 }
			 else {
				 System.out.println("Cancel successful");
			 }
		 }
		 else {
			System.out.println("Button not displayed");
		}
		
	}
}
