package p27_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {

        // Zadatak
        //Napisati program koji ucitava stranicu Zadatak4.html
        //Skinite Zadatak4.html sa drajva. Otvorite u pretrazivacu duplim klikom na fajl i Downloads-a i ikopirajte url. To je url za get u programu
        //I na stranici dodaje 5 poruka “IT Bootcamp”
        //Potrebno  je u svakoj iteraciji kliknuti na dugme Show in
        //Sacekati da se novi element pojavi pre nego sto se doda sledeci

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Helper helper = new Helper();

        driver.get("file:///D:/JAVA/Zadatak4.html");

        for (int i = 0; i < 5; i++) {
            driver.findElement(By.id("showInBtn")).click();

            if(helper.elementExist(driver, By.xpath( "//div[@id='id-"+ i +"']"))){
                System.out.println("Element id-" + i + " je prikazan.");
            }
        }

//        Thread.sleep(5000);

        driver.quit();
    }
}
