package com.POF_AddressBook_Scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.POF_AddressBook.Driver;
import com.POF_AddressBook_Pages.SearchContactPage;
import com.epam.reportportal.testng.ReportPortalTestNGListener;

@Listeners({ReportPortalTestNGListener.class})
public class SearchContactTest extends Driver{
	SearchContactPage searchcontactpage;
	
	
	@Test
	public void searchcontact() throws Exception{
		System.out.println("TestPage searchcontact Driver#########"+driver);
		searchcontactpage = new SearchContactPage(driver);
		searchcontactpage.searchcontact("Mike");
		System.out.println("In the Searchcontact....!!");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		//WebDriverWait wait=new WebDriverWait(driver, 1000);
		
		String firtstnameget1 = driver.findElement(By.xpath("//div[@class='v-grid-tablewrapper']/table/tbody/tr[@class='v-grid-row v-grid-row-stripe v-grid-row-has-data'][1]/td[@class='v-grid-cell'][1]")).getText(); 
		System.out.println("This is firstname_search"+firtstnameget1);
		
		if (firtstnameget1.equals("Mike")) {
			System.out.println("search contact Successful");
		}
		else {
			System.out.println("Search contact Failed");
		}
		
	}

}
