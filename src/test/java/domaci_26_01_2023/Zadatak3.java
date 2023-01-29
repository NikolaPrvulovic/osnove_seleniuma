package domaci_26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        //Zad
        //Napisati program koji:
        //Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
        //Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon klika element obrisao sa stranice i ispisuje odgovarajuce poruke (OVO JE POTREBNO RESITI PETLJOM)
        //POMOC: Brisite elemente odozdo.
        //(ZA VEZBANJE)Probajte da resite da se elemementi brisu i odozgo
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://s.bootsnipp.com/iframe/Dq2X");
        List<WebElement> listaElemenata = driver.findElements(By.xpath("//button[last()]"));
        for (int i = 0; i < listaElemenata.size(); i++) {
            listaElemenata.get(i).click();
            Thread.sleep(2000);
        }
        if(listaElemenata.size() != 0){
            System.out.println("Lista je prazna.");
        }else{
            System.out.println("Lista nije prazna.");
        }
        Thread.sleep(5000);

        driver.quit();
    }
}
