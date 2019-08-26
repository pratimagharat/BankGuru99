package TestPractice.Guru99Bank.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	Properties pro;
	String sourceFolder;
	
	public void loadPropertiesFile() throws IOException
	{
		String rootfolder=System.getProperty("user.dir");
		
		try{
		File fileinput=new File(rootfolder+"/PropertyConfig/ConfigFile.properties");
		FileInputStream fis=new FileInputStream(fileinput);
		Properties prop=new Properties();
		prop.load(fis);
		fis.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException("config file not found at "+rootfolder+"/ProjectConfig/config.Properties");
		}
		}
	

	public String getBrowserName(){
		String Browser= pro.getProperty("Browser");
		if(Browser !=null)
			return Browser;
		else
			throw new RuntimeException("Browser value is not specified");
	}

	
	public String getUrl(){
		String devUrl= pro.getProperty("url");
		if(devUrl !=null)
			return devUrl;
		else
			throw new RuntimeException("DevUrl value is not specified");
	}
	
	public String getUserName(){
		String username= pro.getProperty("UserName");
		if(username !=null)
			return username;
		else
			throw new RuntimeException("UserName value is not specified");
	}

	public String getPassword(){
		String Password= pro.getProperty("Password");
		if(Password !=null)
			return Password;
		else
			throw new RuntimeException("Password value is not specified");
	}
	
	public String getInputExcelFile(){
		String InputExcelFile= pro.getProperty("InputExcelFile");
		if(InputExcelFile !=null)
			return InputExcelFile;
		else
			throw new RuntimeException("InputExcelFile value is not specified");
	}


	

}
