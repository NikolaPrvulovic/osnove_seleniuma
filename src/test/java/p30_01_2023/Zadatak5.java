package p30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Zadatak5 {
    public static void main(String[] args) {

        //Zadatak
        //Napisati program koji:
        //Ucitava stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
        //Vrsi klik na Primary dugme, Secondary, Sucess, Danger
        //Ceka da broj toasts-a bude 4
        //Ispisuje poruku, toasts su prikazani
        //Ceka da broj toasts-a bude 0
        //Ispisuje poruku, toasts su se izgubili

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");

        List<WebElement> buttonList = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            buttonList.add(driver.findElement(By.xpath("//button[contains(@id, 'basic')][position()>"+ i +" and position()<5]")));
        }

        for (int i = 0; i < buttonList.size(); i++) {
            buttonList.get(i).click();
        }

        wait.until(ExpectedConditions.attributeContains(By.xpath("//div[contains(@id, 'basic')]"), "class", "show"));
        System.out.println("Toasts su prikazani.");

        wait.until(ExpectedConditions.attributeContains(By.xpath("//div[contains(@id, 'basic')]"), "class", "hide"));
        System.out.println("Toasts su se izgubili.");



        driver.quit();
    }
}
