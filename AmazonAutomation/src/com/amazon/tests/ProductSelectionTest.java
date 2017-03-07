package com.amazon.tests;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.amazon.common.Common;
import com.amazon.tests.LoginAmazonTest;

import enums.Product;
import enums.URL;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import static com.amazon.common.AmazonConstants.*;

public class ProductSelectionTest extends Common {
	Actions act;
	WebElement element;
	@BeforeClass
	  public void beforeClass() {
		openBrowserD();
		 LoginAmazonTest loginfunctionality= new LoginAmazonTest();
		 loginfunctionality.ClickSignIn();
		 loginfunctionality.LogIn();
	  }
	
  @Test
  public void productPage(){
	  String address=URL.BASEURL.getURL() + URL.PRODUCT_SECTION.getURL() + "/" + PRODUCT_ID;
	  driver.navigate().to(address);
  }
  
  @Test
  public void verifyProductTitle(){
	  try{
		  Assert.assertEquals(Product.HITCHHIKERS_GUIDE.getProductTitle(), driver.findElement(By.xpath(XPATH_PRODUCT_TITLE)).getText());
	  }catch (Exception e){
		  Assert.fail();
	  }
  }
  
  @Test
  public void selectQty(){
	  
	  Select qty= new Select(driver.findElement(By.xpath(XPATH_QUANTITY)));
	  qty.selectByVisibleText("6");

  }
  
  @Test(dependsOnMethods={"selectQty"})
  public void addToCart(){
	  driver.findElement(By.xpath(XPATH_ADD_TO_CART)).click();
  }
  
  @Test(dependsOnMethods={"addToCart"})
  public void emptyCart(){
	  try{
		  driver.findElement(By.xpath(XPATH_VIEW_CART)).click();
		  List<WebElement> deleteBtns= driver.findElements(By.xpath(XPATH_DELETE_CART_BTN));
		  System.out.println(deleteBtns.size());
		  int i=0;
		  for (WebElement deleteBtn: deleteBtns){
			  deleteBtn.click();
			  System.out.println(i);
			  Thread.sleep(250);
			  i++;
			  
		  }
	  }catch(Exception e){
		  e.getStackTrace();
		  
	  }
  }
  @AfterClass
  public void afterClass() {
	 driver.close();
  }

}
