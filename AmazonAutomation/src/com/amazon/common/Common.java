package com.amazon.common;

import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import static com.amazon.common.AmazonConstants.*;
import enums.URL;

public class Common{
	public static WebDriver driver=null;
	public Properties env=null;
	public InputStream env_f=null;
	public Properties obj=null;
	public Properties obj_f=null;
	
	public void openBrowserD(){
		System.setProperty(DRIVER_KEY,DRIVER_VALUE );
		driver=new ChromeDriver();
		driver.navigate().to(URL.BASEURL.getURL());
	}
	
	public void getElement(String Xpath){
		Actions act=new Actions(driver);
		WebElement element= driver.findElement(By.xpath(Xpath));
		act.moveToElement(element).build().perform();  
	}
	
	public void navigaetToUrl(String Url){
		driver.navigate().to(Url);
	}
	
}
