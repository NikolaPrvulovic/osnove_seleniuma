package p30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Zadatak3 {
    public static void main(String[] args){
        //Zadatak
        //Napisati program koji
        //ucitava stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
        //Klik Primary dugme
        //Ceka da se pojavi toasts u gornjem desnom uglu
        //Ispisuje da se element pojavio
        //Ceka da se izgubi toasts u gornjem desnom uglu
        //Ispisuje da se elment izgubio
        //Klik na primary dugme
        //Ceka da se pojavi toasts u gornjem desnom uglu
        //Ispisuje da se element pojavio
        //Klik na x dugme iz toasts-a
        //Ceka da se element izgubi
        //Ispisuje da se element izgubio

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");
        List<WebElement> buttonList = driver.findElements(By.xpath("//button[contains(@id, 'basic')]"));
        List<WebElement> msgList = driver.findElements(By.xpath("//div[contains(@id, 'basic')]"));

        for (int i = 0; i < buttonList.size(); i++) {
            buttonList.get(i).click();
            wait.until(ExpectedConditions.visibilityOf(msgList.get(i)));
            System.out.println("Element " + msgList.get(i).getText() + " is visible!");
            wait.until(ExpectedConditions.invisibilityOf(msgList.get(i)));
            System.out.println("Element is unvisible!");
        }

        buttonList.get(0).click();
        wait.until(ExpectedConditions.visibilityOf(msgList.get(0)));
        System.out.println("Element " + msgList.get(0).getText() + " is visible!");
        driver.findElement(By.xpath("//div[contains(@id, 'basic')][1]//*[contains(@aria-label, 'Close')]")).click();
        wait.until(ExpectedConditions.invisibilityOf(msgList.get(0)));
        System.out.println("Element is unvisible!");

        driver.quit();
    }
}
