package domaci_26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {
        //Zadatak
        //Napisati program koji ucitava stranicu https://geodata.solutions/
        //Bira Country, State i City po vasoj zelji
        //Pritom potrebno je izvrsiti cekanje da se povaje State-ovi nakon izbora Country-a
        //I takodje je potrebno izvrsiti cekanje da se ucitaju gradovi nakon izbora State-a
        //Izabrerit Country, State i City tako da imate podatke da selektujete!

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://geodata.solutions/");
        driver.findElement(By.xpath("//*[@name='generate']")).click();

        WebElement element = driver.findElement(By.xpath("//*[@name='country']"));
        Select select = new Select(element);
        select.selectByVisibleText("Serbia");

        element = driver.findElement(By.xpath("//*[@name='state']"));
        select = new Select(element);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//*[@name='state']/option"), 1));
        select.selectByVisibleText("Central Serbia");

        element = driver.findElement(By.xpath("//*[@name='city']"));
        select = new Select(element);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//*[@name='city']/option"), 1));
        select.selectByVisibleText("Nis");

        Thread.sleep(5000);

        driver.quit();
    }
}
