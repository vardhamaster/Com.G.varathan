package Com.G.Varathan.TestBase;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Com.G.Varathan.util.Testutil;

public class Base
{
	private static final String Webdrivermanger = null;
	private static final String WebDrivermanger = null;
	File f;
	FileInputStream fis;
	Properties pro;
   public static WebDriver driver;

   public Base()
   {
	   try
	   {
		   f=new File(".//src//main//java//Com//G//Varathan//Config//conf.properties");
	   fis=new FileInputStream(f);
	   pro=new Properties();
	   pro.load(fis);
	   }
	   catch (Exception e)
	   {

		   System.out.println(e.getMessage());
	   }
   }
   public void open()
   {
	   String browser=pro.getProperty("Browsername");
	   if (browser.equalsIgnoreCase("Chrome"))
	   {
		   //Webdrivermanger.ChromeDriver().setup();
		System.setProperty("webdriver.chrome.driver", pro.getProperty("Chromepath"));
		driver=new ChromeDriver();
     	}
	   else
		   if (browser.equalsIgnoreCase(""))
		   {
			   System.setProperty("webdriver.gecko.driver",pro.getProperty("geckopath"));
			   driver=new FirefoxDriver();
		   }
        
	   else
	   {
		System.out.println("given browser name is wrong");   
	   }
	   driver.get(pro.getProperty("url"));
	   Testutil.max();
	   Testutil.implicit();
	   Testutil.screenshot();
   }
}
