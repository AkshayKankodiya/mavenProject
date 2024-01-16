package DriverFact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserAction {
    public WebDriver driver;

    public WebDriver openBrowser() {
        System.setProperty("webdriver.chrome.driver", "D://Projects//Java//mavenProject//Webdriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //driver = new ChromeDriver();
        driver.manage().window().maximize();
       // driver.navigate().to("https://automationexercise.com/");
        return driver;
    }
    }





