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


@Feature("SignIn and Login")
public class SignInTest {
    private  WebDriver webDriver;

    @BeforeTest
    public void init(){
        ChromeOptions options = new ChromeOptions();
        //options.setHeadless(true);
        //options.addArguments("--headless=new");
        System.setProperty("webdriver.chrome.whitelistedIps", "167.86.76.193");
        webDriver = new ChromeDriver(options);
        webDriver.get("http://167.86.76.193/home");
    }
    @AfterTest
    public void close(){
        webDriver.close();
        webDriver.quit();
    }
    @Feature("SignIn")
    @Test(groups = {"SignInAndLogin"})
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
        screenshot();
    }
    @Feature("LogIn")
    @Test(groups = {"SignInAndLogin"})
    public void logInTest() {
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
