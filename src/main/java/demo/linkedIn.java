package demo;

import org.openqa.selenium.WebDriver;
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

import com.github.dockerjava.api.command.StopContainerCmd;

public class linkedIn {
    WebDriver driver;
    public linkedIn(){
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

    public void linkedIn_view() throws InterruptedException{
    //Navigate to URL   https://in.linkedin.com/ 
    driver.get("https://www.linkedin.com/ ");

    //   SendKeys to the Username Field Using Locator "XPath" xpath | //input[@autocomplete ="username"] | "chetan7510014155@gmail.com"
    WebElement username = driver.findElement(By.xpath("//input[@autocomplete ='username']"));
    username.clear();
    username.sendKeys("7510014155");
    Thread.sleep(2000);

    // SendKeys to the Password Field Using Locator "XPath" xpath | //input[@autocomplete ="current-password"] | "***********"
    WebElement password = driver.findElement(By.xpath("//input[@autocomplete ='current-password']"));
    password.clear();
    password.sendKeys("Demo***123");
    Thread.sleep(2000);

    // Sign in by clicking to the Sign in button Using Locator "XPath" xpath | //button[contains(text(), 'Sign in')] | click
    driver.findElement(By.xpath("//button[contains(text(), 'Sign in')]")).click();
    System.out.println("Sign Done");
    Thread.sleep(5000);

    //Go to profile
    driver.findElement(By.xpath("//div[@class='t-16 t-black t-bold']")).click();
    Thread.sleep(3000);

    // Getting the count of Who's viewed your profile and printing it Using Locator "XPath" xpath | //strong[1] | get text | System.out.println(" ")
    String viewCount = driver.findElement(By.xpath("(//span[contains(text(),'profile views')])[9]")).getText();
    System.out.println(viewCount);

    // Getting the count of 'Impressions of your post` and printing it Using Locator "XPath" xpath | //strong[2] | getText | System.out.println(" ")
    String impressionCount = driver.findElement(By.xpath("//span[contains(text(),'post impression')][1]")).getText();
    System.out.println(impressionCount);

    //Go to HomePage
    driver.findElement(By.xpath("//span[@title='Home']")).click();
    Thread.sleep(5000);

    // Click on Create Post Button to upload the post Using Locator "ID" ID | navigation-create-post-Create-a-post | click
    WebElement post = driver.findElement(By.xpath("//span[text()='Start a post']"));
    post.click();
    

    // Send Keys to Post and Select sharing with connections option Using Locator "Class" Name ql-editor | "Hey!!" | share-unified-settings-entry-button__chevron-icon | click | //label[@for='sharing-shared-generic-list-radio-CONNECTIONS_ONLY'] | click | ID "ember1312" | click
    
    driver.findElement(By.className("share-unified-settings-entry-button__chevron-icon")).click();
    driver.findElement(By.xpath("(//strong[contains(text(),'Connections only')])[1]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[@class='share-box-footer__primary-btn artdeco-button artdeco-button--2 artdeco-button--primary ember-view']")).click();

    driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys("Hey!!");

    // Make the Post Using Locator "ID" ID | ember575 | click
    driver.findElement(By.xpath("//button[@class='share-actions__primary-action artdeco-button artdeco-button--2 artdeco-button--primary ember-view']")).click();
    Thread.sleep(2000);

    // Go to the Posts section and check if the post is successfully posted or not  Using Locator "Class" Name "Show all posts" | click | //span[@dir="ltr" and contains(text(),'Hey!!')] | isDisplayed()
    Boolean postedOrNot = driver.findElement(By.xpath("//div[@data-test-artdeco-toast-item-type='success']")).isDisplayed();
    System.out.println("Verify if the post get posted: " + postedOrNot);

    }
    
}
