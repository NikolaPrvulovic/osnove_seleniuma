package p30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak4 {
    public static void main(String[] args){

        //Zadatak
        //Napisati program koji:
        //Ucitava stranicu https://mdbootstrap.com/docs/standard/components/toasts/
        //Vrsi klik na Basic example link iz desne navigacije
        //Ceka da url sadrzi #section-basic-example

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/");
        driver.findElement(By.xpath("//*[contains(@href, '#section-basic-example')]")).click();
        wait.until(ExpectedConditions.urlContains("#section-basic-example"));

        driver.quit();
    }
}
