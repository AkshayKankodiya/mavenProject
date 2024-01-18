package DriverFact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserAction {
    public WebDriver driver;

    public WebDriver openBrowser() {
        // set dynamic path for run all type
        String path = System.getProperty("user.dir") + "\\Webdriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",path);
        WebDriver driver = new ChromeDriver();

        //driver = new ChromeDriver();
        driver.manage().window().maximize();
       // driver.navigate().to("https://automationexercise.com/");
        return driver;
    }
    }





