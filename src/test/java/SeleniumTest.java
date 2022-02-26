import org.openqa.selenium.By;
//import necessary Selenium WebDriver classes
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SeleniumTest {
  //declare Selenium WebDriver
  private WebDriver webDriver;	
  
  @Test
  public void checkUrl() {
	  //Load website as a new page
	  webDriver.navigate().to("http://localhost:8090/devops-git-project/MaterialServlet/dashboard");
	  
	  //Assert the Url to check that we are indeed in the correct website
	  Assert.assertEquals(webDriver.getCurrentUrl(), "http://localhost:8090/devops-git-project/MaterialServlet/dashboard");
	  
	  System.out.println("Url: "+webDriver.getCurrentUrl());
  }
  
  @Test
  public void checkDashboardTitle() {
	  //Load website as a new page
	  webDriver.navigate().to("http://localhost:8090/devops-git-project/MaterialServlet/dashboard");
	  
	  //Assert the title to check that we are indeed in the correct website
	  Assert.assertEquals(webDriver.getTitle(), "E-Learning Platform");
	  
	  System.out.println("Dashboard Title: "+webDriver.getTitle());
	  
	  //Retrieve link using it's name and click on it
	  webDriver.findElement(By.linkText("Read More")).click();

	  //Assert the new title to check that the title contain Wikipedia and the button had successfully bring us to the new page
	  Assert.assertTrue(webDriver.getTitle().contains("Wikipedia"));
	  System.out.println("Wikipedia Title: "+webDriver.getTitle());
  }
  
  @Test
  public void checkCreateTitle() {
	  //Load website as a new page
	  webDriver.navigate().to("http://localhost:8090/devops-git-project/MaterialServlet/dashboard");
	  
	  //Retrieve link using it's name and click on it
	  webDriver.findElement(By.linkText("Add New Material")).click();

	  //Assert the new title to check that the title contain Wikipedia and the button had successfully bring us to the new page
	  Assert.assertTrue(webDriver.getTitle().contains("Create Platform Material"));
	  System.out.println("Create Title: "+webDriver.getTitle());
  }
  
  @Test
  public void checkEditTitle() {
	  //Load website as a new page
	  webDriver.navigate().to("http://localhost:8090/devops-git-project/MaterialServlet/dashboard");
	  
	  //Retrieve link using it's name and click on it
	  webDriver.findElement(By.linkText("Edit")).click();

	  //Assert the new title to check that the title contain Wikipedia and the button had successfully bring us to the new page
	  Assert.assertTrue(webDriver.getTitle().contains("Edit Material"));
	  System.out.println("Edit Title: "+webDriver.getTitle());
  }
  
  @BeforeTest
  public void beforeTest() {
	  //Setting system properties of ChromeDriver
	  //to amend directory path base on your local file path
	  String chromeDriverDir = "C:\\Program Files\\Google\\Chrome\\chromedriver.exe";

	  System.setProperty("webdriver.chrome.driver", chromeDriverDir);

	  //initialize FirefoxDriver at the start of test
	  webDriver = new ChromeDriver();  
  }

  @AfterTest
  public void afterTest() {
	  //Quit the ChromeDriver and close all associated window at the end of test
	  webDriver.quit();			
  }

}
