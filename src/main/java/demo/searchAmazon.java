package demo;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
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
///


public class searchAmazon {
    WebDriver driver;
    public searchAmazon(){
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

    public void searchingAmazon(){
    // Navigate to google homepage  
    driver.get("https://www.google.com/");
    
    // Enter Amazon in searchbox Using Locator "Name" q | "Amazon"
    WebElement searchBox = driver.findElement(By.name("q"));
    searchBox.sendKeys("Amazon");
   
    // Press enter key Using Locator "XPath" //input[@value='Google Search']
    driver.findElement(By.xpath("//input[@value='Google Search']")).click();
   
    // Verify if Amazon.com  or Amazon.in is present Using Locator "Partial Link Text" //span[contains(text(),'amazon.in')]
    Boolean amazonLink = driver.findElement(By.partialLinkText("Amazon.in")).isDisplayed();

    System.out.println("check if amazon link is present on the page: " + amazonLink);
    }

}
