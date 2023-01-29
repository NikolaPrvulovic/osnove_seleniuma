package domaci_27_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        //Zadatak
        //Ucitati stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
        //Klik na svako dugme od PRIMARY do DARK
        //Sacekati da se toasts u desnom gornjem uglu pojavi
        //Pauza izmedju klikova 1s
        //Postavite implicitno cekanje za ucitavanje stranice i trazenje elemenata na 10s

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));



        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");

        List<WebElement> buttonList = driver.findElements(By.xpath("//*[@id='section-basic-example']/section[1]/div/section/div/button"));
        List<WebElement> toastList = driver.findElements(By.xpath("//div[contains(@id,'basic')]"));

        for (int i = 0; i < buttonList.size(); i++) {
            buttonList.get(i).click();

            wait.until(ExpectedConditions.visibilityOf(toastList.get(i)));

            if(toastList.get(i).isDisplayed()){
                System.out.println("Poruka za " + toastList.get(i).getText() + " JE prikazana.");
                System.out.println("__________________________________");
            } else{
                System.out.println("Poruka za " + toastList.get(i).getText() + " NIJE prikazana.");
                System.out.println("__________________________________");
            }
            Thread.sleep(1000);
        }





        driver.quit();
    }
}
