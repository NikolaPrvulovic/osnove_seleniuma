package p26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        //Zadatak
        //Napisti program koji:
        //Ucitava stranicu https://s.bootsnipp.com/iframe/z80en
        //Hvata sve elemente iz tabele i stampa tekst svakog elementa. Kako da od nekog elementa procitamo tekst imate na sledecem linku
        //Ceka 5s
        //Zatvara pretrazivac
        //Stampa treba da bude kao u primeru:
        //John	Doe	john@example.com
        //Mary	Moe	mary@example.com
        //July	Dooley	july@example.com
        //
        //HINT: bice vam lakse da radite ulancano trazenje. findElement().findELement()...

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://s.bootsnipp.com/iframe/z80en");
        List<WebElement> lista =  driver.findElements(By.xpath("//div[@id='lorem']/table/tbody/tr"));

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).getText());
            System.out.println();

        }
        Thread.sleep(5000);

        driver.quit();
    }
}
