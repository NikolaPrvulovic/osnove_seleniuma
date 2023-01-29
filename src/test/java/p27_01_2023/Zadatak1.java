package p27_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        //1.Zadatak
        //Ucitati stranicu https://demoqa.com/modal-dialogs
        //Kliknuti na dugme Large modal
        //Proverite da li se prikazao dijalog i ispisite u konzoli odgovarajuce poruke

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Helper helper = new Helper();

        driver.get("https://demoqa.com/modal-dialogs");

        driver.findElement(By.id("showLargeModal")).click();
        if(helper.elementExist(driver, By.className("modal-content"))){
            System.out.println("Prikazan.");
        } else{
            System.out.println("Nije prikazan.");
        }


//        Thread.sleep(5000);

        driver.quit();
    }



}
