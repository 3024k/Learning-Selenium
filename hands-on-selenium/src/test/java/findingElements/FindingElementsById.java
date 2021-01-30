package findingElements;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindingElementsById {
	  protected WebDriver driver;

	  @Before
	  public void setUp(){
		  System.setProperty("webdriver.chrome.driver",
	            "./src/test/resources/chromedriver_version_87.exe");
		  driver = new ChromeDriver(); //Launch Chrome
	      driver.manage().window().maximize(); //Maximize the browser window
	  }

	  @Test
	  public void findElementsUsingId() throws InterruptedException{
		  driver.get("https://testpages.herokuapp.com/styled/find-by-playground-test.html");
		  System.out.println("Inside the findElementsUsingId function");
		  Thread.sleep(10);
		  WebElement element = driver.findElement(By.id("p1"));
		  String elementText = element.getText();
		  System.out.println("Locating using ID, Element text is: " + elementText);
	      assertEquals("This is a paragraph text", elementText);
	  }
	  @Test
	  public void findElementsUsingName() throws InterruptedException{
		  driver.get("https://testpages.herokuapp.com/styled/find-by-playground-test.html");
		  System.out.println("Inside the findElementsUsingName function");
		  Thread.sleep(10);
		  WebElement element = driver.findElement(By.name("pName2"));
		  String elementText = element.getText();
		  System.out.println("Locating using name, Element text is: " + elementText);
	      assertEquals("This is b paragraph text", elementText);
	  }
	  
	  @Test
	  public void findElementsUsingClassName() throws InterruptedException{
		  driver.get("https://testpages.herokuapp.com/styled/find-by-playground-test.html");
		  System.out.println("Inside the findElementsUsingClassName function");
		  Thread.sleep(10);
		  WebElement element = driver.findElement(By.className("page-navigation"));
		  String elementText = element.getText();
		  System.out.println("Locating using class, Element text is: \n" + elementText);
	      assertEquals("This is a paragraph text", elementText);
	  }
	  
	  @Test
	  public void findElementsUsingLinkText() throws InterruptedException{
	  	  driver.get("https://testpages.herokuapp.com/styled/index.html");
		  System.out.println("Inside the findElementsUsingLinkText function");
		  Thread.sleep(10);
		  WebElement element = driver.findElement(By.linkText("Basic Web Page Example"));
		  String elementText = element.getText();
		  System.out.println("Locating using linkText, Element text is: \n" + elementText);
	      assertEquals("Basic Web Page Example", elementText);
	  }
	  
	  @Test
	  public void findElementsUsingPartialLinkText() throws InterruptedException{
	  	  driver.get("https://testpages.herokuapp.com/styled/index.html");
		  System.out.println("Inside the findElementsUsingPartialLinkText function");
		  Thread.sleep(10);
		  WebElement element = driver.findElement(By.partialLinkText("Basic Web"));
		  String elementText = element.getText();
		  System.out.println("Locating using Partial linkText, Element text is: \n" + elementText);
	      assertEquals("Basic Web Page Example", elementText);
	  }
	  
	  @Test
	  public void findElementsUsingTagName() throws InterruptedException{
		  driver.get("https://testpages.herokuapp.com/styled/tag/table.html");
		  System.out.println("Inside the findElementsUsingTagName function");
		  Thread.sleep(10);
		  WebElement table = driver.findElement(By.id("mytable"));
		  List<WebElement> rows = table.findElements(By.tagName("tr"));
		  System.out.println("No of rows = "+rows.size());
		  //String elementText = element.getText();
		  //System.out.println("Locating using Partial linkText, Element text is: \n" + elementText);
	      assertEquals(5, rows.size());
	  }
		@After
		public void tearDown() throws Exception{
			System.out.println("Closing the driver");
			driver.quit();
		}

}
