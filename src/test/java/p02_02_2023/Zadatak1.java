package p02_02_2023;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Zadatak1 {

    //.Zadatak
    //Kreirati klasu KatalonLoginTests za testove
    //Base url: https://cms.demo.katalon.com
    //Test #1: Visit login page from Nav bar
    //Koraci:
    //Ucitati home stranicu
    //Kliknuti na My account link
    //Verifikovati da je naslov stranice My account – Katalon Shop
    //Verifikovati da se u url-u stranice javlja /my-account
    //Za sve validacije ispisati odgovarajuce poruke u slucaju greske

    //Test #2: Check input types
    //Koraci:
    //Ucitati /my-account stranicu
    //Verifikovati da  polje za unos email-a za atribu type ima vrednost text
    //Verifikovati da polje za unos lozinke za atribut type ima vrednost password
    //Verifikovati da checkbox Remember me za atribut type ima vrednost checkbox
    //Verifikovati da je Remember me checkbox decekiran. Koristan link kako naci informaciu da li je checkbox cekiran ili ne.
    //Za sve validacije ispisati odgovarajuce poruke u slucaju greske

    //Test #3: Display error when credentials are wrong
    //Podaci:
    //email: invalidemail@gmail.com
    //password: invalid123
    //Koraci:
    //Ucitati /my-account stranicu
    //Unesite email
    //Unesite password
    //Kliknite na login dugme
    //Verifikovati da postoji element koji prikazuje gresku
    //Verifikovati da je prikazana greska ERROR: Invalid email address
    //Za sve validacije ispisati odgovarajuce poruke u slucaju greske
    //Verifikovati da smo idalje na login stranici posle greske, tako sto proveravamo da se url-u javlja /my-account
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseURL = "https://cms.demo.katalon.com";

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));


    }

    @BeforeMethod
    public void beforeMethod(){
        driver.get(baseURL);
    }

    @Test
    @Description("Test #1: Visit login page from Nav bar")
    public void visitLoginPageFromNavBar(){
        driver.navigate().to(baseURL + "/my-account");
        Assert.assertEquals(driver.getTitle(), "My account – Katalon Shop", "Wrong page title.");
        Assert.assertTrue(driver.getCurrentUrl().contains("/my-account"), "Wrong page URL.");
    }

    @Test
    @Description("Test #2: Check input types")
    public void checkInputTypes(){
        driver.navigate().to(baseURL + "/my-account");
        Assert.assertTrue(driver.findElement(By.xpath("//input[contains(@type, 'text')]")).getAttribute("type").contains("text"), "Email input type attribute does not contains 'text'");
        Assert.assertTrue(driver.findElement(By.xpath("//input[contains(@type, 'password')]")).getAttribute("type").contains("password"), "Password input type attribute does not contains 'password'");
        Assert.assertTrue(driver.findElement(By.xpath("//input[contains(@type, 'checkbox')]")).getAttribute("type").contains("checkbox"), "Checkbox input type attribute does not contains 'checkbox'");
        Assert.assertFalse(driver.findElement(By.xpath("//input[contains(@type, 'checkbox')]")).isSelected(), "Checkbox is checked!");
    }

    @Test
    @Description("Test #3: Display error when credentials are wrong")
    public void displayErrorWithWrongCredentials(){
        driver.navigate().to(baseURL + "/my-account");
        driver.findElement(By.xpath("//input[contains(@type, 'text')]")).sendKeys("invalidemail@gmail.com");
        driver.findElement(By.xpath("//input[contains(@type, 'password')]")).sendKeys("invalid123");
        driver.findElement(By.xpath("//button[contains(@type, 'submit')]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[contains(@role, 'alert')]")));
        Assert.assertTrue(driver.findElement(By.xpath("//ul[contains(@role, 'alert')]")).getText().contains("ERROR: Invalid email address"), "Invalid email adress is NOT displayed.");
        Assert.assertTrue(driver.getCurrentUrl().contains("/my-account"), "URL does not contain '/my-account'");
    }

    @AfterMethod
    public void afterMethod(){

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
