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
		sortcontactpage.sortcontact(); 
		
		
		String firtstnameget1 = driver.findElement(By.xpath("//div[@class='v-grid-tablewrapper']/table/tbody/tr[@class='v-grid-row v-grid-row-stripe v-grid-row-has-data'][1]/td[@class='v-grid-cell'][1]")).getText(); 
		System.out.println("This is firstname#$#$#$#$"+firtstnameget1);
		
		if (firtstnameget1.equals("Alex")) {
			System.out.println("sort contact Successful");
		}
		else {
			System.out.println("Failed sorting contact");
		}
		
	}

}
