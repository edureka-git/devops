package com.POF_AddressBook_Scripts;

import com.POF_AddressBook.*;
import java.io.File;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.POF_AddressBook.Driver;
import com.POF_AddressBook_Pages.EditContactPage;
import com.epam.reportportal.message.ReportPortalMessage;
import com.epam.reportportal.testng.ReportPortalTestNGListener;

@Listeners({ReportPortalTestNGListener.class})
public class EditConactTest extends Driver{
	EditContactPage editcontactpage;
	private static Logger Log = Logger.getLogger(EditConactTest.class);
	/*
	 * This test is to Edit contact
	 */
	@Test
	public void editcontact() throws Exception{
		//BasicConfigurator.configure();
		Log.info("## Edit contact");
		
		editcontactpage = new EditContactPage(driver);
		editcontactpage.editcontact("FNedit", "LNtestedit", "1567942", "editedemail", "12/4/95"); 
		String firtstnameget1 = driver.findElement(By.xpath("//div[@class='v-grid-tablewrapper']/table/tbody/tr[@class='v-grid-row v-grid-row-stripe v-grid-row-has-data'][1]/td[@class='v-grid-cell'][1]")).getText(); 
		if (firtstnameget1.equals("FNedit")) {
			System.out.println("edit contact Successful");
			//BasicConfigurator.configure();
			Log.info("## Edit contact Successful");
		}
		else {
			Log.error("## Failed during edit contact");
			//BasicConfigurator.configure();
			throw new Exception() ;
		}
	
	
		//BasicConfigurator.configure();
		Log.error("## Failed during edit contact");
		/*String rp_message = "test message for Report Portal";
		ReportPortalMessage message = new ReportPortalMessage(new File(System.getProperty("user.dir")+"\\RP_Snaps\\"+Driver.screenshot_file_path_name), rp_message);
		Log.info(message);*/
		System.out.println("edit contact Unsuccessful");
		/*e.printStackTrace();
		snapins();
		Assert.fail();*/
		

}
}
