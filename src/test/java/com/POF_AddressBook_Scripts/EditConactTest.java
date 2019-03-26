package com.POF_AddressBook_Scripts;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.POF_AddressBook.Driver;
import com.POF_AddressBook_Pages.EditContactPage;
import com.epam.reportportal.testng.ReportPortalTestNGListener;

@Listeners({ReportPortalTestNGListener.class})
public class EditConactTest extends Driver{
	EditContactPage editcontactpage;
	
	@Test
	public void editcontact() throws Exception{
		System.out.println("TestPage Editcontact Driver#########"+driver);
		editcontactpage = new EditContactPage(driver);
		editcontactpage.editcontact("FNedit", "LNtestedit", "1567942", "editedemail", "12/4/95"); 
		System.out.println("In the editcontacttest....!!");
		
		
		String firtstnameget1 = driver.findElement(By.xpath("//div[@class='v-grid-tablewrapper']/table/tbody/tr[@class='v-grid-row v-grid-row-stripe v-grid-row-has-data'][1]/td[@class='v-grid-cell'][1]")).getText(); 
		System.out.println("This is firstname#$#$#$#$"+firtstnameget1);
		
		if (firtstnameget1.equals("FNedit")) {
			System.out.println("edit contact Successful");
		}
		else {
			System.out.println("Failed editing contact");
		}
		
	}

}
