package p31_01_2023;

import helper__template.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Zadatak5 {
    public static void main(String[] args) throws IOException {

        //Napisati program koji:
        //Ucitava stranicu https://cms.demo.katalon.com/
        //Hvata  sve href atribute svih linkova iz navigacije
        //Za svaki link proverava status da je veci ili jednak od 200 i manji od 400
        //Koristan link za citanje status koda nekog url-a

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://cms.demo.katalon.com/");


        List<WebElement> listaHref = driver.findElements(By.xpath("//ul[@class=' nav-menu']/li/a"));

        Helper helper = new Helper();

        for (int i = 0; i < listaHref.size(); i++) {
            int href = helper.getHTTPResponseStatusCode(listaHref.get(i).getAttribute("href"));
            if(href >= 200 && href < 400){
                System.out.println("Status za element >> " + listaHref.get(i).getText() + " << je u opsegu 200-400");
            } else {
                System.out.println("Status za element >>" + listaHref.get(i).getText() + "<< nije u opsegu.");
            }

        }

        driver.quit();
    }
}
