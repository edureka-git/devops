package com.POF_AddressBook_Scripts;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import java.io.File;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import com.POF_AddressBook.Driver;
import com.POF_AddressBook_Pages.AddContactPage;
import com.epam.reportportal.testng.ReportPortalTestNGListener;


@Listeners({ReportPortalTestNGListener.class})
public class AddContactTest extends Driver{
	
	//private static Logger Log = Logger.getLogger(Logger.class.getName());
	private static Logger logger;
	//= Logger.getLogger(AddContactTest.class);
	
	
	AddContactPage addcontactpage;
	//private By newcontactBtn = By.xpath("//div[@class='v-button v-widget']");
	/*
	 * This test is to add contacts with all the positive details
	 */
	@Test
	public void Addcontact( ) throws Exception {
		//Log.setLevel(Level.INFO);
		//BasicConfigurator.configure();
		//Log.info("## Adding the contact with all the details **********");
		System.out.println("In AddContact Log sysout");
		
		//driver.navigate().refresh();
		addcontactpage = new AddContactPage(driver);
		addcontactpage.addcontactaddressbook("Sudheer12345", "Neelam", "9876543210", "sudheerkumarn@virtusa.com", "12/4/95"); 
		//WebDriverWait wait = new WebDriverWait(WebDriverRefrence,TimeOut);
		WebDriverWait wait = new WebDriverWait (driver, 20);
		
}
	
	/*
	 * This test is to add contacts with an invalid email address
	 */
	@Test
	public void Addcontactinvalidemail( ) throws Exception {
		//BasicConfigurator.configure();
		//Log.info("## Adding the contact with wrong email");
		
		driver.navigate().refresh();
		addcontactpage = new AddContactPage(driver);
		addcontactpage.addcontactaddressbook("Gopi12345", "Prashanth", "0987654321", "gopi@virtusa.com", "5/4/95"); 
		driver.navigate().refresh();
		String firtstnameget1 = driver.findElement(By.xpath("//div[@class='v-grid-tablewrapper']/table/tbody/tr[@class='v-grid-row v-grid-row-stripe v-grid-row-has-data'][1]/td[@class='v-grid-cell'][1]")).getText(); 
		if (firtstnameget1.equals("Sudheer12345")) {
			System.out.println("Added contact Successfully");
		}
		else {
			System.out.println("Contact was not added");
		}
}
	
	/*
	 * This test is to add contact with possitive details(duplicate test), using this coz couldn't identify the odd number test in the mvn application.
	 */
	@Test
	public void Addcontacttest3( ) throws Exception {
		
		//driver.navigate().refresh();
		addcontactpage = new AddContactPage(driver);
		addcontactpage.addcontactaddressbook("Sudheer3", "Neelam", "9876543210", "sudheerkumarn@virtusa.com", "12/4/95"); 
		
}
	/*
	 * This test is to add contacts with empty details
	 */
	@Test
	public void Addcontactempty( ) throws Exception {
		//BasicConfigurator.configure();
		//Log.info("## Adding an empty contact");
		
		//driver.navigate().refresh();
		addcontactpage = new AddContactPage(driver);
		addcontactpage.addcontactaddressbook("", "", "", "", ""); 
		System.out.println("In the test3....!!");
		
}
	/*
	 * This test is to add contacts with an invalid dob format
	 */
	@Test
	public void Addcontactdobformat( ) throws Exception {
		//BasicConfigurator.configure();
		//Log.setLevel(Level.INFO);
		//Log.info("## Adding a contact with an wrong date format ***********");
		logger.info("## Adding a contact with an wrong date format ***********");
		
		//driver.navigate().refresh();
		addcontactpage = new AddContactPage(driver);
		addcontactpage.addcontactaddressbook("Sudheer4", "Neelam", "9876543210", "sudheerkumarn@virtusa.com", "abcdefghi"); 
		//BasicConfigurator.configure();
		logger.info("## Adding a contact with an wrong date format ***********");
}
	
	/*
	 * This test is to add contacts with an invalid email format
	 */
	@Test
	public void Addcontacttestemailformat( ) throws Exception {
		//BasicConfigurator.configure();
		//Log.info("## Adding a contact with wrong email format");
		
		//driver.navigate().refresh();
		addcontactpage = new AddContactPage(driver);
		addcontactpage.addcontactaddressbook("Sudheer5", "Neelam", "9876543210", "sudheerkumarn", "12/4/95"); 
		
			

		
		
}
	
	
	/*
	 * This test is to check cancel button
	 */
	@Test
	public void CancelAddcontact() throws Exception{
		//BasicConfigurator.configure();
		//Log.info("## Clicking on cancel btn");
		/*try
		{*/
		System.out.println("In Cancel button Test");
		addcontactpage.canceladdcontactaddressbook();
		WebElement cancelbtn1 = driver.findElement(By.xpath("//div[3]/div[@class='v-button v-widget' and 1]"));
		
		if(cancelbtn1.isDisplayed()){
			cancelbtn1.click();
			System.out.println("In Cancel button Is displayed");
			Assert.assertTrue(true);
			 //cancelbtn1 = driver.findElement(By.xpath("//div[3]/div[@class='v-button v-widget' and 1]"));
			 if(cancelbtn1.isDisplayed()){
				 System.out.println("In Cancel button Is Not working");
				 Assert.assertTrue(false);
				 //Log.info("## Failed Cancel btn not working");
			 }
			 else {
				 System.out.println("In Cancel button Is working");
				 //Log.info("## Failed Cancel btn Working successfully");
			 }
		 }
		 else {
			 System.out.println("In Cancel button Is Not displayed");
			 //Log.info("## Failed cancel btn is not displayed");
		}
		
		
		
		/*catch(Exception e)
		{
			e.printStackTrace();
			snapins();
			Assert.fail();
			}
	}*/
}
}
