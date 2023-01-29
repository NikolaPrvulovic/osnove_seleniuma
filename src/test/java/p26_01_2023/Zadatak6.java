package p26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak6 {
    public static void main(String[] args) throws InterruptedException {
        //Zadatak
        //Ucitati stranicu https://cms.demo.katalon.com/
        //Maksimizovati prozor
        //Proveriri da li je je crno MENU dugme vidljivo (Ispisati poruke u konzoli)
        //Prostavite duzinu prozora na 700px i visinu na 700px
        //Proverite da li je crno MENU dugme vidljivo (Ispisati poruke u konzoli)


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://cms.demo.katalon.com/");

        System.out.println("FullScreen mode: ");

        if(driver.findElement(By.className("menu-toggle")).isDisplayed()){
            System.out.println("Menu button is visible.");
        }else {
            System.out.println("Menu button is NOT visible.");
        }

        System.out.println();
        Thread.sleep(2000);

        Dimension dimension = new Dimension(700, 700);
        driver.manage().window().setSize(dimension);

        Thread.sleep(2000);

        System.out.println("Window size: " + dimension + "px");

        if(driver.findElement(By.className("menu-toggle")).isDisplayed()){
            System.out.println("Menu button is visible.");
        }else {
            System.out.println("Menu button is NOT visible.");
        }

        driver.quit();
    }
}
