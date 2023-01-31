package ch.card2brain.card2braine2e;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SignInTest {
    private static WebDriver webDriver;

    @BeforeTest
    public void init(){
        webDriver = new ChromeDriver();
        webDriver.get("http://167.86.76.193/home");
    }

    @AfterTest
    public void close(){
        webDriver.close();
    }
    @Test
    public void signInTest() {
        // click on button signin
        webDriver.findElement(By.cssSelector("button.btn.btn-secondary.ms-1")).click();
        // Fill in the users information
        webDriver.findElement(By.id("firstName")).sendKeys("Max");
        webDriver.findElement(By.id("lastName")).sendKeys("Musterman");
        webDriver.findElement(By.id("email")).sendKeys("Max@Musterman.ch");
        webDriver.findElement(By.id("password")).sendKeys("Hallo1234");
        //Submit
        webDriver.findElement(By.xpath("/html/body/app-root/div/main/app-signup/div/form/div[3]/div[2]/button")).click();

    }


}
