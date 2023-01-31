package p30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) {
        // Zadatak
        //Napisati program koji ucitava stranicu https://youtube.com
        // i u search baru unosi tekste Breskvica i ceka da se pojavi vise od 3 rezultata iz padajuceg menija i zatim klikce na prvi.

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://youtube.com");

        driver.findElement(By.xpath("//input[@id='search']")).click();
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("breskvica");
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//ul[@class='sbsb_b']/li"), 3));
        driver.findElement(By.xpath("//ul[@class='sbsb_b']/li[1]")).click();





        driver.quit();
    }
}
