package com.amazon.tests;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.amazon.common.Common;
import static com.amazon.common.AmazonConstants.*;
//Check for broken links in footer
public class HyperLinkTest extends Common{
	Actions act;
	WebElement element;
	@BeforeClass
	  public void beforeClass() {
		openBrowserD();
	  }
  @Test
  public void linkCheck() throws InterruptedException {
	 WebElement footer;
	  int linkcount=1;
	  for(int i=0; i<linkcount; i++){
		  footer= driver.findElement(By.xpath(XPATH_FOOTER));
		  List<WebElement> footlinks=footer.findElements(By.tagName("a"));
		  linkcount=footlinks.size();
		  footlinks.get(i).click();
		  Thread.sleep(3000);
		  if (driver.getTitle().contains("404")){
			  System.out.println(footlinks.get(i).getText() + " " + "Broken Link");
		  }
		  driver.navigate().back();
	  }
	  System.out.println("Total=" + linkcount );
 	  
  }
}
