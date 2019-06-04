package com.POF_AddressBook_Scripts;

import javax.validation.constraints.AssertFalse;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.POF_AddressBook.Driver;
import com.POF_AddressBook_Pages.SortContactPage;
import com.epam.reportportal.testng.ReportPortalTestNGListener;

@Listeners({ReportPortalTestNGListener.class})
public class SortContactTest extends Driver{
	private static Logger Log = Logger.getLogger(Logger.class.getName());
	SortContactPage sortcontactpage;
	
	
	@Test
	public void sortcontactbyfname() throws Exception{
		Log.info("## Sortng contact by Fname");
		
		sortcontactpage = new SortContactPage(driver);
		sortcontactpage.sortcontactbyfname(); 
		String firtstnameget1 = driver.findElement(By.xpath("//div[@class='v-grid-tablewrapper']/table/tbody/tr[@class='v-grid-row v-grid-row-stripe v-grid-row-has-data'][1]/td[@class='v-grid-cell'][1]")).getText(); 
		if (firtstnameget1.equals("Alex")) {
			Log.info("## sort contact by firstname Successful");
		}
		else {
			Log.error("## sort contact by firstname Failed");
			throw new Exception();
		}
		
	}

	@Test
	public void sortcontactbylastname() throws Exception{
		Log.info("## Sortng contact by Lname");
		
		sortcontactpage = new SortContactPage(driver);
		sortcontactpage.sortcontactbylastname(); 
		String lastnameget1 = driver.findElement(By.xpath("//div[@class='v-grid-tablewrapper']/table/tbody/tr[@class='v-grid-row v-grid-row-stripe v-grid-row-has-data'][1]/td[@class='v-grid-cell'][2]")).getText(); 
		if (lastnameget1.equals("Anderson")) {
			Log.info("## sort contact by lastname Successful");
		}
		else {
			Log.error("## sort contact by lastname Failed");
			throw new Exception();
		}
		
	}
	
	@Test
	public void sortcontactbyemail1() throws Exception{
		Log.info("## Sortng contact by Email");
		
		sortcontactpage = new SortContactPage(driver);
		sortcontactpage.sortcontactbyemail(); 
		//String emailget1 = driver.findElement(By.xpath("//div[@class='v-grid-tablewrapper']/table/tbody/tr[@class='v-grid-row v-grid-row-stripe v-grid-row-has-data'][1]/td[@class='v-grid-cell'][3]")).getText(); 
		String emailget1 = driver.findElement(By.xpath("//samplexpath123456")).getText(); 
		if (emailget1.equals("alex@king.com")) {
			Log.info("## sort contact by email Successful");
			Assert.assertTrue(true);
		}
		else {
			Log.info("## sort contact by email Failed");
			throw new Exception();
		}
		}
		
}
