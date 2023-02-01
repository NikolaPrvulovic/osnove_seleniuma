package p31_01_2023;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Zadatak6 {
    public static void main(String[] args) throws IOException {

        //Zadatak (Za vezbanje)
        //Po tekstu zadataka 4, kreirajte screenshot i sacuvajte ga u folderu screenshots po imenom screenshot-[dan]-[mesec]

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://cms.demo.katalon.com/");

        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("dd-MM-yyy__hh-mm-ss").format(new Date());

        Files.copy(file.toPath(), new File("screenshots/screenshot1 - " + timestamp + ".jpg").toPath());

        driver.quit();
    }
}
