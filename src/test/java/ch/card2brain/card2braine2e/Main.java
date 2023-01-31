package ch.card2brain.card2braine2e;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Main {
    private static WebDriver webDriver;

    public static void main(String[] args) {
        webDriver = new ChromeDriver();


        webDriver.get("http://167.86.76.193/home");
        String title = webDriver.getTitle();
        System.out.println(title);

        //signIn();

        login();
        //logout();


        webDriver.close();

    }


    private static void signIn(){

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

    private static void login(){

        // click on button signin
        webDriver.findElement(By.xpath("//*[@id=\"navbar\"]/form[1]/button[2]")).click();
        webDriver.findElement(By.id("email")).sendKeys("Max@Musterman.ch");
        webDriver.findElement(By.id("password")).sendKeys("Hallo1234");
        //Submit
        webDriver.findElement(By.xpath("/html/body/app-root/div/main/app-signup/div/form/div[3]/div[2]/button")).click();

    }

    private static void logout(){

        //UserLogout
        webDriver.findElement(By.xpath("//*[@id=\"navbar\"]/form[2]/button")).click();

    }
}
