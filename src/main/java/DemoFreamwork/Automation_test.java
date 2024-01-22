package DemoFreamwork;


import DriverFact.BrowserAction;
import DriverFact.ListenersTest;
import DriverFact.ListnersWithScreenshotAllure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.TestNG;
import org.testng.annotations.*;

@Listeners({ListnersWithScreenshotAllure.class})

public class Automation_test {
    public WebDriver driver;
    Automation_Page page;
    TestNG testng = new TestNG();




    @BeforeTest
    public void setup() {
        Reporter.log("driver setup");
        BrowserAction browserAction = new BrowserAction();
        driver = browserAction.openBrowser();
        page = new Automation_Page(driver);

    }

    @Test(priority = 0)
    public void setupBrowserTest() throws InterruptedException {
        Reporter.log("go to the url ");
        page.setupBrowserpage();

    }

    @Test(priority = 1, dependsOnMethods = "setupBrowserTest")
    public void randomEmailTest() throws InterruptedException {
        Reporter.log("randome email ");
        page.randomEmailPage();

    }

    @Test(priority = 2, dependsOnMethods = "randomEmailTest")
    public void fillFormTest() throws InterruptedException {
        Reporter.log("form fillings ");
        page.fillFormPage();

        /*page.clickSetting(page.radioBtnMale);
        page.inputtext(page.fNameTextbox, ConstantData.FIRSTNAME);*/
    }



    @AfterClass
    public void closeDriver() {
        driver.quit();
    }


    @BeforeClass
    public void sampleTest() {

    }
        /*page.clickSetting(page.radioBtnMale);
        page.inputtext(page.fNameTextbox, ConstantData.FIRSTNAME);*/

}
