package p31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args){

        //Napisati program koji:
        //Ucitava stranu https://blueimp.github.io/jQuery-File-Upload/
        //Uploadujte sliku
        //Ceka se da se pojavi slika u listi uploadovanih fajlova
        //Koristite uslov da broj elemenata bude 1.
        //Klik na Start dugme u okviru item-a koji se uploadovao
        //Ceka se da se pojavi delete dugme pored itema
        //Klik na delete dugme pored itema
        //Ceka se da se element obrise
        //Koristite da broj elemenata bude 0

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        driver.findElement(By.xpath("//*[@name='files[]']")).sendKeys(new File("test_data/happybug.gif").getAbsolutePath());

        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//*[@class='files']/tr"), 1));

        driver.findElement(By.xpath("//td//*[contains(@class, 'start')]")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td//*[contains(@class, 'delete')]")));
        driver.findElement(By.xpath("//td//*[contains(@class, 'delete')]")).click();

        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//*[@class='files']/tr"), 0));




        driver.quit();
    }
}
