package domaci_26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

        //Zadatak
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
        //Validira da li je novi todo dodat na stranici
        //Na kraju programa proci petljom i izbrisati svaki todo sa stranice (klikom na x dugme svakog todo-a)
        //Validirati da je na kraju programa broj todo-a na stranici 0.
        //Cekanje od 5s
        //Zatvorite pretrazivac

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        ArrayList<String> toDo = new ArrayList<>();
        toDo.add("Visit Paris");
        toDo.add("Visit Prague");
        toDo.add("Visit London");
        toDo.add("Visit New York");
        toDo.add("Visit Belgrade");

        driver.manage().window().maximize();
        driver.get("https://example.cypress.io/todo");

        List<WebElement> listaElemenata = driver.findElements(By.xpath("//ul[@class='todo-list']/li"));
        int counter = 1;
        for (int i = 0; i < toDo.size(); i++) {
            WebElement element = driver.findElement(By.className("new-todo"));
            element.sendKeys(toDo.get(i));
            element.sendKeys(Keys.ENTER);


            listaElemenata = driver.findElements(By.xpath("//ul[@class='todo-list']/li/div/label"));
            for (int j = 0; j < listaElemenata.size(); j++) {
                if(listaElemenata.get(j).getText().contains(toDo.get(i))){
                    System.out.println(toDo.get(i) +" USPESNO dodat.");
                }
            }
            Thread.sleep(1000);
        }

        //petlja ispod nije htela da radi (sa i++) kad se u lokatoru stavi /li[(i+1)]//button, tj obrise samo jedan element
        //pa nakon toga nije htela da radi ni sa counterom, pa sam probao preko /li[last()]//button, tu je bilo dobro,
        //ali je znala da preskace ponekad element sa tekstom "Walk a dog", cak ni Thread.sleep tu nije pomogao,
        //pa sam hvatanje liste elemenata stavio van petlje, brisalo je 1 poslednji element i pucalo
        //na kraju sam morao da ubacim taj lokator unutar petlje
        //i na kraju posto listaElemenata.size()-1 ode u -1 morao sam da stavim IF uslov DA BI RADILO KAKO TREBA

        for (int i = listaElemenata.size(); i >= 0; i--) {
            listaElemenata = driver.findElements(By.xpath("//ul[@class='todo-list']/li"));
            Actions actions = new Actions(driver);
            if(listaElemenata.size()-1 > -1){
                actions.moveToElement(listaElemenata.get(listaElemenata.size()-1)).perform();
                WebElement deleteButton = driver.findElement(By.xpath
                        ("//ul[@class='todo-list']/li[last()]//button[contains(@class, 'destroy')]"));
                Thread.sleep(1000);
                deleteButton.click();

            } else {
                break;
            }

        }
        Thread.sleep(2000);
        listaElemenata = driver.findElements(By.xpath("//ul[@class='todo-list']/li"));
        if(listaElemenata.size() != 0){
            System.out.println("Lista elemenata NIJE prazna");
        }else{
            System.out.println("Lista elemenata JE prazna");
        }


        driver.quit();
    }
}
