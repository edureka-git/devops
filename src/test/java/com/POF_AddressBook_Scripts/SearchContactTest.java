package com.POF_AddressBook_Scripts;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.POF_AddressBook.Driver;
import com.POF_AddressBook_Pages.SearchContactPage;
import com.epam.reportportal.testng.ReportPortalTestNGListener;

@Listeners({ReportPortalTestNGListener.class})
public class SearchContactTest extends Driver{
	SearchContactPage searchcontactpage;
	private static Logger Log = Logger.getLogger(Logger.class.getName());
	
	@Test
	public void searchcontact() throws Exception{
		Log.info("## Search contact");
		
		searchcontactpage = new SearchContactPage(driver);
		searchcontactpage.searchcontact("Mike");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		//WebDriverWait wait=new WebDriverWait(driver, 1000);
		String firtstnameget1 = driver.findElement(By.xpath("//div[@class='v-grid-tablewrapper']/table/tbody/tr[@class='v-grid-row v-grid-row-stripe v-grid-row-has-data'][1]/td[@class='v-grid-cell'][1]")).getText(); 
		if (firtstnameget1.equals("Mike")) {
			Log.info("## search contact Successful");
		}
		else {
			Log.error("## search contact Failed");
			throw new Exception();
		}
	
	}

}