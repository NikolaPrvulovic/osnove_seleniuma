package p31_01_2023;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

public class Zadatak4 {
    public static void main(String[] args) throws IOException {

        //Napisati program koji:
        //Kreirati screenshots folder u projektu
        //Ucitava stranicu https://cms.demo.katalon.com/
        //Kreira screenshot stranice
        //Sacuvati screenshot u folderu screenshots pod imenom screenshot1.jpg
        //Koristan link

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://cms.demo.katalon.com/");

        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(file.toPath(), new File("screenshots/screenshot1.jpg").toPath());

        driver.quit();
    }
}
