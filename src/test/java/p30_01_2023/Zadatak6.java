package p30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Zadatak6 {
    public static void main(String[] args){

        // Zadatak
        //Napisati program koji:
        //Ucitava stranicu https://tus.io/demo.html
        //Hvata sve linkove sa stranice
        //Skrola do svakog linka
        //Od svakog linka cita href atribut i stampa ga na ekranu

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://tus.io/demo.html");

        List<WebElement> linkovi = driver.findElements(By.xpath("//h3"));

        for (int i = 0; i < linkovi.size(); i++) {
            new Actions(driver).moveToElement(linkovi.get(i)).perform();
            System.out.println(linkovi.get(i).getText());
        }

        driver.quit();
    }
}
