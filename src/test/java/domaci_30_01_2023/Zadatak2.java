package domaci_30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html");
        Select select = new Select(driver.findElement(By.xpath("//*[@id='delay-select']")));
        select.selectByVisibleText("2000ms");

        int num1 = 8;
        for (int i = 0; i < 5; i++) {
            new Actions(driver).moveToElement(driver.findElement(By.id("infinite-scroll-button"))).perform();
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("infinite-scroll-button")))); //vrti "Loading more items" dok ne pukne program
            driver.findElement(By.id("infinite-scroll-button")).click();

            wait.until(ExpectedConditions.numberOfElementsToBe(By.className("item"), num1));
            num1 += 3;
        }

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("disabled-text"))));
        driver.quit();
    }
}
