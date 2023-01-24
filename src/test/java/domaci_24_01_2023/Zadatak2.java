package domaci_24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {

        //Niz todo-a (niz stringova) koje treba da uneti. Niz je:
        //Visit Paris
        //Visit Prague
        //Visit London
        //Visit New York
        //Visit Belgrade
        //Maksimizirati prozor
        //Ucitati stranicu https://example.cypress.io/todo
        //Program petljom prolazi kroz niz todo-a i svaki unosi na stranicu
        //Nakon svakog unosa todo-a, unosi se enter
        //Cekanje od 5s
        //Zatvorite pretrazivac

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to("https://example.cypress.io/todo");

        ArrayList<String> nizToDo = new ArrayList<>();
        nizToDo.add("Visit Paris");
        nizToDo.add("Visit Prague");
        nizToDo.add("Visit London");
        nizToDo.add("Visit New York");
        nizToDo.add("Visit Belgrade");

        for (int i = 0; i < nizToDo.size(); i++) {
            driver.findElement(By.className("new-todo")).sendKeys(nizToDo.get(i));
            driver.findElement(By.className("new-todo")).sendKeys(Keys.ENTER);
        }

        Thread.sleep(5000);

        driver.quit();
    }
}
