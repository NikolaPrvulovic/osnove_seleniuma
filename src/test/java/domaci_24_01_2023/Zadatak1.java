package domaci_24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        //Maksimizirati prozor
        //Ucitati stranicu https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        //Prijavite se na sistem
        //Username: Admin
        //Password: admin123
        //Cekanje od 5s
        //U input za pretragu iz navigacije unesite tekst Me
        //Kliknite na prvi rezultat pretrage (to ce biti Time)
        //Cekanje od 1s
        //Kliknite u headeru na svog avatara (to ce biti na ime: Paul Collings)
        //Klinkite na logout
        //Cekanje od 5s
        //Zatvorite pretrazivac

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(200);
        driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@placeholder='Search']")).sendKeys("Me");
        driver.findElement(By.className("oxd-main-menu-item")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[contains(@class, 'oxd-userdropdown-name')]")).click();
        driver.findElement(By.xpath("//*[contains(text(), 'Logout')]")).click();

        Thread.sleep(5000);

        driver.quit();
    }
}
