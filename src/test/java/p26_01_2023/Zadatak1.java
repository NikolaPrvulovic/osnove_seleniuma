package p26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        //Zadatak
        //Napisti proram koji :
        //Ucitava stranicu https://s.bootsnipp.com/iframe/oV91g
        //Hvatamo sve page-eve iz paginacije tabele
        //Zatim petljom prolazimo kroz paginaciju tako sto kliknemo na svaki broj
        //Izmedju iteracija napravite pauzu od 1s
        //Zatvorite pretrazivac

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://s.bootsnipp.com/iframe/oV91g");
        List<WebElement> lista = driver.findElements(By.xpath("//ul[@id='myPager']/li/a[contains(@class, 'page')]"));

        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).click();
            Thread.sleep(2000);
        }
//        Thread.sleep(5000);

        driver.quit();
    }
}
