package p31_01_2023;

import helper__template.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak3 {
    public static void main(String[] args){

        //Napisati program koji
        //Kreirati folder downloads folder u projektu
        //Ucitava stranu https://cms.demo.katalon.com/product/flying-ninja/
        //Cita href atribut sa glavne slike sa stranice
        //Koristi link iz href atributa za skidanje slike
        //Sliku sacuvajte u folderu downloads pod nazivom flying-ninja.jpg
        //Koristan link za skidanje fajlova u javi
        //Azurirajte gitignore da ignorise downloads folder

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://cms.demo.katalon.com/product/flying-ninja/");
        String url = driver.findElement(By.xpath("//div[@class='flex-viewport']/figure/div[1]/a")).getAttribute("href");

        Helper help = new Helper();
        help.downloadFile(url, ("downloads/flying-ninja.jpg"));


        driver.quit();
    }
}
