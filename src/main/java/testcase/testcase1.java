package testcase;


import com.google.common.annotations.VisibleForTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class testcase1 {

@Test
    public void test1() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://accounts.zoho.in/signin?servicename=AaaServer&serviceurl=%2Fhome");
        driver.findElement(By.xpath("//input[@id='login_id']")).sendKeys("tqa8769@gmail.com");
        //driver.findElement(By.xpath("//span[text()='Next']")).click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Akky@8283");
        driver.findElement(By.xpath("//button[@id='nextbtn']")).click();


}
}
