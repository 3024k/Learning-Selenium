package gettingStartedWithSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.*;
import static  org.junit.Assert.*;

public class MyBlogPageLoad {
  protected WebDriver driver;

  @Before
  public void setUp(){
	  System.setProperty("webdriver.chrome.driver",
            "./src/test/resources/chromedriver_version_87.exe");

    driver = new ChromeDriver(); //Launch Chrome
      driver.manage().window().maximize(); //Maximize the browser window
      driver.get("https://humayunashik.blogspot.com/");
  }

  @Test
  public void loadMyBlog(){
	  System.out.println("Inside the function");
      new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
          public Boolean apply(WebDriver d){
        	  System.out.println(d.getTitle());
              return d.getTitle().startsWith("Humayun Ahmed Ashik");
          }
      });
      assertEquals("Humayun Ahmed Ashik", driver.getTitle());
      }
  
	@After
	public void tearDown() throws Exception{
		System.out.println("Closing the driver");
		driver.quit();
	}

}
