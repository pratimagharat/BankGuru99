package TestPractice.Guru99Bank.TestBase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;




public class BaseTest {
	static String sourceFolder;
	static ConfigReader configfilereader;
	protected static WebDriver driver;
	protected static ExcelUtility datareader;
	static{
		if(System.getProperty("user.dir").contains("target"))
		
			sourceFolder=System.getProperty("user.dir").replace("/target", "");
		else
			sourceFolder=System.getProperty("user.dir");
		
		
	configfilereader=new ConfigReader();
	try {
		configfilereader.loadPropertiesFile();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		
	// load excel Data
			try {
				 datareader = new ExcelUtility(sourceFolder);
				datareader.readData(configfilereader.getInputExcelFile());
			} catch (Exception e) {
				e.printStackTrace();
			}

		
	}
	public void invokeBrowser()
	{
		if(configfilereader.getBrowserName().equalsIgnoreCase("chrome"))
		{
			System.getProperty("webDriver.chrome.driver", sourceFolder+"Drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
	}

}
