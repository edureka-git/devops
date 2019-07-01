package com.POF_AddressBook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.epam.reportportal.message.ReportPortalMessage;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import java.lang.reflect.Method;

public class Driver {
	public static WebDriver driver;
	public static Properties properties;
	private static Logger Log = Logger.getLogger(Driver.class);
	private static Logger logger; //rp
	protected String methodName;
	public static String screenshot_file_path_name;
	
	@BeforeMethod
	public void nameBefore(Method method)
	{
	    methodName= method.getName();       
	}
	public void snapins ()throws Exception
	{
		TakesScreenshot src = (TakesScreenshot)driver;
		File SrcFile=src.getScreenshotAs(OutputType.FILE);
		screenshot_file_path_name = methodName+System.currentTimeMillis()+".png";
		//File DestFile=new File("C:\\Users\\sudheerkumarn\\Documents\\POF_AddressBook\\snaps\\"+methodName+System.currentTimeMillis()+".png");
		File DestFile=new File("C:\\Users\\sudheerkumarn\\Documents\\POF_AddressBook\\snaps\\"+screenshot_file_path_name);
		//File DestFile=new File(System.getProperty("user.dir")+"\\RP_Snaps\\"+screenshot_file_path_name);
	  	FileUtils.copyFile(SrcFile, DestFile);
		
		ReportPortalMessage message = new ReportPortalMessage(new File("C:\\Users\\sudheerkumarn\\Documents\\POF_AddressBook\\snaps\\"+screenshot_file_path_name), "rp_message");
	  	//ReportPortalMessage message = new ReportPortalMessage(DestFile, "rp_message");
	  	//System.out.println("RP loggggg *************"+message);
	}
	
	@BeforeClass
	public void initialization() throws Exception 
	{
		//System.out.println("In the Driver class###########");
		//BasicConfigurator.configure();
		Log.info("## Initialzing Driver *********");
		FileInputStream fi = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/resources/configuaration.properties");
				properties = new Properties();
				properties.load(fi);
				String browserType = properties.getProperty("browser");
				browserType.equals("chrome");
				//BasicConfigurator.configure();
				Log.info("## Initialzing Chrome Driver");
				String chromePath = null;
				String osName=System.getProperty("os.name");
				ChromeOptions options = new ChromeOptions();
				if(osName.indexOf("Windows")!=-1)
					chromePath=System.getProperty("user.dir")+"/drivers/windows/chromedriver.exe";
				else if(osName.indexOf("Linux")!=-1){
					options.setBinary("/opt/google/chrome/google-chrome");
					chromePath=System.getProperty("user.dir")+"/drivers/linux/chromedriver";
				}
				System.setProperty("webdriver.chrome.driver", chromePath);

				// uncomment this to run in ubuntu
				//String chromePath = "/home/sudheer/Documents/Reportportal/drivers/chromedriver";
				//String chromePath = "C:\\Users\\sudheerkumarn\\Documents\\Eclipse\\BDD\\POF_AddressBook\\drivers\\windows\\chromedriver.exe";
				//String chromePath = System.getProperty("user.dir")+"/drivers/windows/chromedriver.exe";
				
				// Setting the webdriver.chrome.driver property to set executable's
				//System.setProperty("webdriver.chrome.driver", chromePath);
				//ChromeOptions options = new ChromeOptions();
				// uncomment this to run in ubuntu
				
				options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
				options.addArguments("--no-sandbox"); // Bypass OS security model
				options.addArguments("--headless");//Run's tests without opning the browser --sudheer
				 driver = new ChromeDriver(options);

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("http://localhost:9090/addressbook");
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
		Log.info("## Closing Browser");
	}

}
