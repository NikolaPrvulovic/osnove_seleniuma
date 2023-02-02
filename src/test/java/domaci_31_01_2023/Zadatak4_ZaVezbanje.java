package domaci_31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;

public class Zadatak4_ZaVezbanje {
    public static void main(String[] args){

        //Zadatak (za vezbanje)
        //Napisati program koji:
        //Ucitava stranicu https://blueimp.github.io/jQuery-File-Upload/
        //Uploaduje sve cetiri slike odjenom (slike iz prvog zadatka)
        //Ceka da se prikazu 4 item-a a upload
        //Klik na upload
        //Ceka da se upload zavrsi

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        ArrayList<String> listaSlika = new ArrayList<>();
        listaSlika.add("front");
        listaSlika.add("left");
        listaSlika.add("right");
        listaSlika.add("back");

        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        for (int i = 0; i < listaSlika.size(); i++) {
            driver.findElement(By.xpath("//*[@type='file']")).sendKeys(new File("test_data/"+listaSlika.get(i)+".jpg").getAbsolutePath());
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='files']/tr[" + (i+1) + "]")));
        }

        driver.findElement(By.xpath("//*[@type='submit']")).click();
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath("//*[@role='progressbar']"))));

        driver.quit();
    }
}
