package domaci_31_01_2023;

import helper__template.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Zadatak3 {
    public static void main(String[] args) throws IOException {

        //Zadatak
        //Napisati program koji:
        //Ucitava stranicu https://itbootcamp.rs/
        //Skrola do slajdera na dnu stranice (u kome su slike Java, Php, Selenium, …)
        //Cita sve linkove slika iz slajdera
        //Proverava url svake slike, i za sve slike koje imaju status veci i jednak od 200 a manji od 300,
        // skida i smesta u folder itbootcamp_slider u okviru projekta
        //Azurirajte gitignore da ignorise itbootcamp_slider folder

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://itbootcamp.rs/");

        new Actions(driver).moveToElement(driver.findElement(By.xpath("//div[contains(@class, 'slider_bkgd')]")));

        List<WebElement> listaElemenata = driver.findElements(By.xpath("//div[contains(@class, 'owl-item')]/div/img"));
        Helper helper = new Helper();
        for (int i = 0; i < listaElemenata.size(); i++) {

            if(helper.getHTTPResponseStatusCode(listaElemenata.get(i).getAttribute("src"))>=200 &&
                    helper.getHTTPResponseStatusCode(listaElemenata.get(i).getAttribute("src"))<300){
                helper.downloadFile(listaElemenata.get(i).getAttribute("src"), "itbootcamp_slider/image"+ i + ".jpg");
            } else{
                System.out.println("Elements HTTP Status Code is not valid.");
            }

        }


        driver.quit();
    }
}
