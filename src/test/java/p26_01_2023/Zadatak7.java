package p26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak7 {
    public static void main(String[] args) throws InterruptedException {

        // Zadatak (ZA VEZBANJE)
        //Ucitati stranicu https://netoglasi.rs/
        //Ispisati sve nazive kategorija iz leve navigacije
        //Validirati da je kategorija Automobili na prvom mestu
        //Klik na kategoriju Automobili
        //Validarati da je kategorija Automobili na prvom mestu

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://netoglasi.rs/");

        Thread.sleep(2000);
        List<WebElement> lista = driver.findElements(By.xpath("//*[contains(@class, 'category-list')]"));

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).getText());

        }

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getText().contains("Automobili")) {
                System.out.println("Automobili je na poziciji " + i + " u koloni.");
            }
            Thread.sleep(2000);
        }

        driver.findElement(By.xpath("//*[contains(@href, '/automobili')]")).click();

        System.out.println();
        System.out.println();

        for (int i = 0; i < lista.size(); i++) {
            if (!lista.get(i).getText().contains("Automobili")) {
                System.out.println("Automobili kategorija vise nije u listi.");
            }
        }

        Thread.sleep(5000);

        driver.quit();
    }
}
