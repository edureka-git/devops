package com.POF_AddressBook_Scripts;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.POF_AddressBook.Driver;
import com.POF_AddressBook_Pages.SortContactPage;
import com.epam.reportportal.testng.ReportPortalTestNGListener;

@Listeners({ReportPortalTestNGListener.class})
public class SortContactTest extends Driver{
	SortContactPage sortcontactpage;
	
	@Test
	public void sortcontactbyfname() throws Exception{
		System.out.println("TestPage sortcontact Driver#########"+driver);
		sortcontactpage = new SortContactPage(driver);
		sortcontactpage.sortcontactbyfname(); 
		
		
		String firtstnameget1 = driver.findElement(By.xpath("//div[@class='v-grid-tablewrapper']/table/tbody/tr[@class='v-grid-row v-grid-row-stripe v-grid-row-has-data'][1]/td[@class='v-grid-cell'][1]")).getText(); 
		System.out.println("This is firstname#$#$#$#$"+firtstnameget1);
		
		if (firtstnameget1.equals("Alex")) {
			System.out.println("sort contact by firstname Successful");
		}
		else {
			System.out.println("Failed sorting contact by firstname");
		}
		
	}

	@Test
	public void sortcontactbylastname() throws Exception{
		System.out.println("TestPage sortcontact Driver#########"+driver);
		sortcontactpage = new SortContactPage(driver);
		sortcontactpage.sortcontactbylastname(); 
		
		
		String lastnameget1 = driver.findElement(By.xpath("//div[@class='v-grid-tablewrapper']/table/tbody/tr[@class='v-grid-row v-grid-row-stripe v-grid-row-has-data'][1]/td[@class='v-grid-cell'][2]")).getText(); 
		System.out.println("This is firstname#$#$#$#$"+lastnameget1);
		
		if (lastnameget1.equals("Anderson")) {
			System.out.println("sort contact by lastname Successful");
		}
		else {
			System.out.println("Failed sorting contact by lastname");
		}
		
	}
	
	@Test
	public void sortcontactbyemail() throws Exception{
		System.out.println("TestPage sortcontact Driver#########"+driver);
		sortcontactpage = new SortContactPage(driver);
		sortcontactpage.sortcontactbyemail(); 
		
		
		String emailget1 = driver.findElement(By.xpath("//div[@class='v-grid-tablewrapper']/table/tbody/tr[@class='v-grid-row v-grid-row-stripe v-grid-row-has-data'][1]/td[@class='v-grid-cell'][3]")).getText(); 
		System.out.println("This is firstname#$#$#$#$"+emailget1);
		
		if (emailget1.equals("alex@king.com")) {
			System.out.println("sort contact by email Successful");
		}
		else {
			System.out.println("Failed sorting contact by email");
		}
		
	}
}
