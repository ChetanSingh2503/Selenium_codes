package demo;

import org.openqa.selenium.WebDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SourceType;

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

import com.github.dockerjava.api.command.StopContainerCmd;

public class BookMyShow_Movies {
    WebDriver driver;
    public BookMyShow_Movies(){
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

    public void MoviesUrl(){
    // Navigate to url   https://in.bookmyshow.com/explore/home/chennai
    driver.get("https://in.bookmyshow.com/explore/home/chennai");

    // Go inside the Recommended Movie section Using Locator "XPath" /html/body/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div/div/div/div[2]/div/div[1]
    // Search for img url of all the movies present inside it Using Locator "Tag Name" Tagname | "img" | gettext() 

    // Give Print command  Tagname | "img" | gettext() 
    List <WebElement> recommended = driver.findElements(By.xpath("//a[@class='commonStyles__LinkWrapper-sc-133848s-11 style__CardContainer-sc-lnhrs7-5 kcFNYT']"));
    int listSize = recommended.size();
    System.out.println("No. of Recommended movies" + listSize);

    for(WebElement recommendedM: recommended){
        String URL = recommendedM.findElement(By.xpath("//a//img")).getAttribute("src");
        System.out.println(URL);
    }
    
    
    
    

    // Print Name of the 2nd item in the “Premiere” list Using Locator "XPath" /html/body/div[1]/div[1]/div[2]/div[3]/div[1]/div[5]/div/div/div/div[2]/div/div[1]/div[2]/a/div/div[3]/div[1]/div | getText() | Print
    String movieName = driver.findElement(By.xpath("(//div[@class='sc-7o7nez-0 iHsoLV'])[2]")).getText();
    System.out.println(movieName);

    // Print Language of the 2nd item in the “Premiere” list Using Locator "XPath" /html/body/div[1]/div[1]/div[2]/div[3]/div[1]/div[5]/div/div/div/div[2]/div/div[1]/div[2]/a/div/div[3]/div[2]/div | getText | print
    String movieLanguage = driver.findElement(By.xpath("(//div[@class='sc-7o7nez-0 kHxEsI'])[2]")).getText();
    System.out.println(movieLanguage);
    }
    
}
