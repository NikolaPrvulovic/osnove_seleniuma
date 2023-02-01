package domaci_31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Zadatak2 {
    public static void main(String[] args){
        //Zadatak
        //Napisati program koji:
        //Ucitava stranu https://itbootcamp.rs/
        //Misem prelazi preko Vesti iz navigacionog menija
        //Ceka da se prikaze padajuci meni za Vesti
        //Misem prelazi preko Kursevi iz navigacionog menija
        //Ceka da se prikaze padajuci meni za Kursevi
        //Misem prelazi preko Prijava i pravilnik iz navigacionog menija
        //Ceka da se prikaze padajuci meni za Prijava i pravilnik
        //Koristan link. Mouse over preko seleniuma https://www.selenium.dev/documentation/webdriver/actions_api/mouse/#move-to-element

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://itbootcamp.rs/");


        List<WebElement> listaPadajucih = driver.findElements(By.xpath("//*[contains(@id, 'menu-main-menu')]/li[position()>1 and position()<6]"));

        for (int i = 0; i < listaPadajucih.size(); i++) {
            new Actions(driver).moveToElement(listaPadajucih.get(i)).perform();
            wait.until(ExpectedConditions.visibilityOf(listaPadajucih.get(i)));
        }

        driver.quit();
    }
}
