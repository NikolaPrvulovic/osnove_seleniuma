package p27_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        //Zadatak
        //Napisati program koji ucitava stranicu https://github.com/orgs/embedly/repositories?q=&type=all&language=&sort=
        //Klik na Type drawdown
        //Klik na Public iz drowdowna
        //Proverava da li je Clear dugme u desnom uglu prikazano
        //Kilk na Clear filter u desnom uglu

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Helper help = new Helper();

        driver.get("https://github.com/orgs/embedly/repositories?q=&type=all&language=&sort=");

        driver.findElement(By.xpath("//div[contains(@class, 'd-flex flex-column')]/div[2]/details[1]/summary")).click();

        if(help.elementExist(driver, By.xpath("//div[@class='SelectMenu-list']//span[contains(text(), 'Public')]"))){
            System.out.println("Public je prikazan.");
            driver.findElement(By.xpath("//div[@class='SelectMenu-list']//span[contains(text(), 'Public')]")).click();
        }else{
            System.out.println("Public NIJE prikazan.");
        }

        if(help.elementExist(driver, By.xpath("//a[contains(@class, 'issues-reset-query')]"))){
            System.out.println("Clear je prikazan.");
            driver.findElement(By.xpath("//a[contains(@class, 'issues-reset-query')]")).click();
        } else{
            System.out.println("Clear nije prikazan.");
        }




//        Thread.sleep(5000);

        driver.quit();
    }
}
