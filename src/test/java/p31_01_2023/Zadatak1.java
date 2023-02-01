package p31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args){

        //Napisati program koji:
        //Krairajte folder za fajlove u okviru projekta pod nazivom test_data
        //U folder skinite i postavite proizvoljnu sliku
        //Ucitava stranu https://tus.io/demo.html
        //Skrola do dela za upload fajla
        //Aploadujte sliku
        //Cekajte da se pojava dugme za download fajla

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://tus.io/demo.html");
        new Actions(driver).scrollToElement(driver.findElement(By.xpath("//*[@id='js-file-input']"))).perform();
        driver.findElement(By.xpath("//*[@id='js-file-input']")).sendKeys(new File("test_data/happybug.gif").getAbsolutePath());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='js-upload-container']/a[1]")));




        driver.quit();
    }
}
