package p30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args){

        //Zadatak
        //Napisati program koji ucitava stranicu https://s.bootsnipp.com/iframe/klDWV
        // i ceka da se ucita progress bar na 100% a zatim ispisuje tekst u konzoli “Stranica ucitana”

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://s.bootsnipp.com/iframe/klDWV");

        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[@class='glow']"))));
        System.out.println("Element is invisible. (invisibilityOf)");

        driver.get("https://s.bootsnipp.com/iframe/klDWV");
        wait.until(ExpectedConditions.attributeToBe(By.xpath("//*[@class='glow']"), "style", "width: 100%;"));
        System.out.println("Element's attribute is at 100%. (attributeToBe)");

        driver.get("https://s.bootsnipp.com/iframe/klDWV");
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@class='percentage']"), "100%"));
        System.out.println("Element's text is 100%. (textToBe)");

        driver.quit();
    }
}
