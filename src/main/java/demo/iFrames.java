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

public class iFrames {
    WebDriver driver;
    public iFrames(){
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

    public void iFramesText(){
        // Navigate to url
        driver.get("https://the-internet.herokuapp.com/nested_frames");

// Switch to topParentFrame  driver.switchTo().frame(1) 
driver.switchTo().frame("frame-top");

// Switch to inner Frame by Frame Name  driver.switchTo().frame(frame-left) 
driver.switchTo().frame("frame-left");

// declare a WebElement leftEle Using Locator "Tag Name" leftEle | body |  WebElement leftEle = driver.findElement(By.tagName("body"));
WebElement leftEle = driver.findElement(By.tagName("body"));


// declare a new variable and  store leftFrame Text   String  lefText= leftEle.getText();
String  lefText= leftEle.getText();

// "give the print command to print the text   System.out.println(lefText);
System.out.println(lefText);

// "
// switch to parent frame   driver.switchTO().parentFrame();
driver.switchTo().parentFrame();

// Switch to inner Frame by Frame Name Using Locator "Name" driver.switchTo().frame(frame-middle) 
driver.switchTo().frame("frame-middle");

// declare a WebElement middleEle Using Locator "Tag Name" middleEle | body |  WebElement middleEle = driver.findElement(By.tagName("body")
WebElement middleEle = driver.findElement(By.tagName("body"));

// declare a new variable and  store middleFrame Text   String  middleText= middleEle.getText();
String  middleText= middleEle.getText();

// "give the print command to print the text   System.out.println(middleText);
System.out.println(middleText);

// "
// switch to parent frame   
driver.switchTo().parentFrame();

// Switch to inner Frame by Frame Name Using Locator "Name" driver.switchTo().frame(frame-right) 
driver.switchTo().frame("frame-right");

// declare a WebElement rightEle Using Locator "Tag Name" rightEle | body |  WebElement rightEle = driver.findElement(By.tagName("body")
WebElement rightEle = driver.findElement(By.tagName("body"));

// declare a new variable and  store rightFrame Text   String  rightText= rightEle.getText();
String  rightText= rightEle.getText();

// "give the print command to print the text   System.out.println(rightText);
System.out.println(rightText);

// "
//  switch to the deafault frame    driver.switchTo().defaultContent();
driver.switchTo().defaultContent();

// switch to bottom frame  driver.switchTo().frame(2);
driver.switchTo().frame("frame-bottom");

// declare a WebElement bottomEle Using Locator "Tag Name" bottomEle | body |  WebElement bottomEle = driver.findElement(By.tagName("body")
WebElement bottomEle = driver.findElement(By.tagName("body"));

// declare a new variable and  store bottomFrame Text   String  bottomText= bottomEle.getText();
String  bottomText= bottomEle.getText();

// "give the print command to print the text   System.out.println(bottomText);
System.out.println(bottomText);

driver.switchTo().defaultContent();
// "
    }
    
}
