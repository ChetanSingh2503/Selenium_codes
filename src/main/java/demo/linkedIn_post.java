package demo;

import org.openqa.selenium.WebDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class linkedIn_post {
    WebDriver driver;
    public linkedIn_post(){
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }
    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void createPost() throws InterruptedException{

        // Creating an Actions object
        Actions actions = new Actions(driver);
        
   // navigate to url    url | https://www.linkedin.com/ 
   driver.get("https://www.linkedin.com/ ");

  // enter username or Email in the webElement  userName Using Locator "XPath" userName | //input[@id='session_key'] | "7510014155"
  driver.findElement(By.xpath("//input[@name='session_key']")).sendKeys("7510014155");

  // enter password in webelement Password Using Locator "XPath" password | //input[@id='session_password'] | "Demo***123"
  driver.findElement(By.xpath("//input[@name='session_password' or @name='password']")).sendKeys("Demo***123");
  
  //   login |  //button[contains(text(),'Sign in')]
  driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();

  // click on start a post button  Using Locator "XPath"
  driver.findElement(By.xpath(" //div[@class='share-box-feed-entry__top-bar']")).click();

  // click on photo icon  Using Locator "XPath" photo |  //button[@aria-label='Add a photo']/span[@class='share-promoted-detour-button__icon-container']
  WebElement photoIcon = driver.findElement(By.xpath("//button[@aria-label='Add a photo']/span[@class='share-promoted-detour-button__icon-container']"));
  photoIcon.click();
  //photoIcon.click();
  driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\cheta\\Downloads\\IMG-20230317-WA0002_compress37.jpg");
  System.out.println("img sent");
  Thread.sleep(3000);

  for (int i = 0; i <= 3; i++) {
    actions.sendKeys(Keys.TAB).build().perform();
    Thread.sleep(500); // Add a short delay between TAB presses
}

// Pressing ENTER
actions.sendKeys(Keys.ENTER).build().perform();
actions.sendKeys(Keys.ENTER).build().perform();

  


  // click on photo icon  
  //driver.findElement(By.id("ember2258")).click();

  // click on Done button Using Locator "XPath" Done | //span[text()='Done']
  //driver.findElement(By.className("share-actions__primary-action artdeco-button artdeco-button--2 artdeco-button--primary ember-view")).click();
  driver.findElement(By.xpath("//span[text()='Next']")).click();
  driver.findElement(By.xpath("//button[@class='share-actions__primary-action artdeco-button artdeco-button--2 artdeco-button--primary ember-view']")).click();

  Boolean postedOrNot = driver.findElement(By.xpath("//div[@data-test-artdeco-toast-item-type='success']")).isDisplayed();
  System.out.println("Verify if the post get posted: " + postedOrNot);
  
  
    }

    
}
