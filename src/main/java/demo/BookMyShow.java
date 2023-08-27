package demo;
import java.util.List;
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

public class BookMyShow {
    WebDriver driver;
    public BookMyShow(){
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

    public void hyperlinksCount(){
    // Navigate to URL   https://in.bookmyshow.com/explore/home/chennai
    driver.get("https://in.bookmyshow.com/explore/home/chennai");

    // Seach for all the links Available with the TagName Using Locator "Tag Name" links | "a" | driver.findElements(by.TagName("a"))
    List <WebElement> links = driver.findElements(By.tagName("a"));

    // Get the No. of links present  using getsize() method
    int linksCount = links.size();

    System.out.println("No. of links present on the site: " + linksCount);
   
    }

    
}
