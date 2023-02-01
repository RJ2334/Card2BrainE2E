package ch.card2brain.card2braine2e;

import io.qameta.allure.Attachment;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


@Feature("SignIn and Login")
public class LoginInTest {
    private WebDriver webDriver;

    @BeforeTest
    public void init() throws MalformedURLException {
        //options.setHeadless(true);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-dev-shm-usage");
        webDriver = new ChromeDriver(options);
        webDriver.get("http://167.86.76.193/home");

        System.out.println(webDriver.getTitle());
        //webDriver = new ChromeDriver(options);
    }

    @AfterTest
    public void close() {
        webDriver.close();
        webDriver.quit();
    }

    @Feature("LogIn")
    @Test(groups = {"SignInAndLogin"})
    public void logInTest() {
        webDriver.get("http://167.86.76.193/home");
        // click on button signin
        webDriver.findElement(By.cssSelector("#navbar > form:nth-child(1) >button.btn.btn-primary.ms-1")).click();
        // Fill in the users information
        webDriver.findElement(By.cssSelector("#floatingInput")).sendKeys("Max@Musterman.ch");
        webDriver.findElement(By.cssSelector("#floatingPassword")).sendKeys("Hallo1234");
        //Submit
        webDriver.findElement(By.cssSelector("body > app-root > div > main > app-login > div > div > div > div > div > form > div.d-grid > button")).click();
        //screenshot();
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
    }

}
