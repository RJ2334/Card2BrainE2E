package ch.card2brain.card2braine2e;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver webDriver = new ChromeDriver();

        webDriver.get("http://167.86.76.193/home");
        webDriver.close();

    }
}
