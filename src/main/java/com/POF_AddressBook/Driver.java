package com.POF_AddressBook;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Driver {
	public static WebDriver driver;
	public static Properties properties;
	
	@BeforeClass
	public void initialization() throws Exception 
	{
		System.out.println("In the Driver class###########");
		FileInputStream fi = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/resources/configuaration.properties");
				properties = new Properties();
				properties.load(fi);
				String browserType = properties.getProperty("browser");
				browserType.equals("chrome");
				String chromePath = null;
				String osName=System.getProperty("os.name");
				ChromeOptions options = new ChromeOptions();
				if(osName.indexOf("Windows")!=-1)
					chromePath=System.getProperty("user.dir")+"/drivers/windows/chromedriver.exe";
				else if(osName.indexOf("Linux")!=-1){
					options.setBinary("/opt/google/chrome/google-chrome");
					chromePath=System.getProperty("user.dir")+"/drivers/linux/chromedriver";
				}

				// Setting the webdriver.chrome.driver property to set executable's
				System.setProperty("webdriver.chrome.driver", chromePath);
				

				options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
				options.addArguments("--no-sandbox"); // Bypass OS security model
				//options.addArguments("--headless");//Run's tests without opning the browser --sudheer
				 driver = new ChromeDriver(options);

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("http://10.7.177.68:8083/");
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
