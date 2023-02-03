package domaci_03_02_2023;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class KatalonShopTests {
    //Zadatak
    //	Kreirati KatalonShopTests klasu:
    //	baseUrl: https://cms.demo.katalon.com
    //	Test #1:  Adding product with quantity to the cart
    //	Prioritet = 10
    //	Koraci:
    //Ucitati stranicu /product/flying-ninja/
    //Unesite kolicinu 3
    //Klik na Add to cart dugme
    //Verifikovati da poruka sadrzi tekst “Flying Ninja”.
    //Klik na Cart link iz navigacije
    //Verifikovati da u url-u stoji /cart ruta
    //Verifikovati da je broj proizvoda u korpi jednako 1
    //
    //	Test #2:  Removing product from cart
    //	Prioritet = 20
    //	Koraci:
    //Klik na Cart link iz navigacije
    //Verifikovati da u url-u stoji /cart ruta
    //Verifikovati da je broj proizvoda u korpi jednako 1
    //Klik na remove dugme iz prvog reda
    //Verifikovati da je broj proizvoda u korpi jedako 0

    //Test #3:  Verify error is displayed when username is missing
    //	Prioritet = 30
    //	Koraci:
    //Kliknite na my account link
    //Klik na login dugme
    //Verifikovati da je prikazana poruka Error: Username is required.
    //
    //Test #4:  Verify error is displayed when password is missing
    //	Prioritet = 40
    //	Koraci:
    //Kliknite na my account link
    //Unesite username customer
    //Klik na login dugme
    //Verifikovati da je prikazana poruka ERROR: The password field is empty.
    //
    //Test #5:  Verify error is displayed when password is wrong
    //	Prioritet = 50
    //	Koraci:
    //Kliknite na my account link
    //Unesite username customer
    //Unesite nevalidan pass invalidpassword
    //Klik na login dugme
    //Verifikovati da je prikazana poruka ERROR: The password you entered for the username customer is incorrect. Lost your password?
    //
    //
    //
    //Test #6:  Verify error is displayed when user does not exist
    //	Prioritet = 60
    //	Koraci:
    //Kliknite na my account link
    //Unesite username invaliduser
    //Unesite nevalidan pass (ex: pass1234)
    //Klik na login dugme
    //Verifikovati da je prikazana poruka ERROR: Invalid username. Lost your password?
    //
    //Test #7:  Verify successful login
    //	Prioritet = 70
    //	Koraci:
    //Kliknite na my account link
    //Unesite username customer
    //Unesite validan pass crz7mrb.KNG3yxv1fbn
    //Klik na login dugme
    //Verifikovati na stranici pise Hello Katalon Parlitul_Changed
    //	Dopunite pageve za sve sto je potrebno za ove testove, ako je potrebno kreirajte i nove pageve
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
        driver.get(this.baseURL);
    }

    @Test(priority = 10)
    @Description("Test #1:  Adding product with quantity to the cart")
    public void addingProductWithQuantityToTheCart(){
        driver.navigate().to(baseURL + "/product/flying-ninja/");
        driver.findElement(By.xpath("//input[contains(@type, 'number')]")).clear();
        driver.findElement(By.xpath("//input[contains(@type, 'number')]")).sendKeys("3");
        driver.findElement(By.xpath("//button[contains(@name, 'add')]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'message')]")).getText().contains("Flying Ninja"), "Message does not contain 'Flying Ninja'");
        driver.findElement(By.xpath("//li[contains(@class, 'item-8')]")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/cart"), "URL does not contain '/cart'");
        Assert.assertEquals(driver.findElements(By.xpath("//form[contains(@class,'cart-form')]//tbody/tr[contains(@class, 'cart-item')]")).size(),
                1,"Products number in cart is not 1");
    }

    @Test(priority = 20)
    @Description("Test #2:  Removing product from cart")
    public void removingProductFromCart(){
        driver.findElement(By.xpath("//li[contains(@class, 'item-8')]")).click();
        Assert.assertEquals(driver.findElements(By.xpath("//form[contains(@class,'cart-form')]//tbody/tr[contains(@class, 'cart-item')]")).size(),
                1,"Products number in cart is not 1");
        Assert.assertTrue(driver.getCurrentUrl().contains("/cart"), "URL does not contain '/cart'");
        Assert.assertEquals(driver.findElements(By.xpath("//form[contains(@class,'cart-form')]//tbody/tr[contains(@class, 'cart-item')]")).size(),
                1,"Products number in cart is not 1");
        driver.findElement(By.xpath("//td[contains(@class, 'remove')]/a[1]")).click();
        wait.until(ExpectedConditions.invisibilityOfAllElements(
                driver.findElements(By.xpath("//form[contains(@class,'cart-form')]//tbody/tr[contains(@class, 'cart-item')]"))));
    }

    @Test(priority = 30)
    @Description("Test #3:  Verify error is displayed when username is missing")
    public void verifyErrorIsDisplayedWhenUsernameMissing(){
        driver.findElement(By.xpath("//li[contains(@class, 'item-10')]")).click();
        driver.findElement(By.xpath("//button[contains(@name, 'login')]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[contains(@role, 'alert')]/li")).getText()
                .contains("Error: Username is required"), "Alert message does not contain: 'ERROR: The username field is empty'");
    }

    @Test(priority = 40)
    @Description("Test #4:  Verify error is displayed when password is missing")
    public void verifyErrorIsDisplayedWhenPasswordMissing(){
        driver.findElement(By.xpath("//li[contains(@class, 'item-10')]")).click();
        driver.findElement(By.xpath("//input[contains(@type, 'text')]")).sendKeys("customer");
        driver.findElement(By.xpath("//button[contains(@name, 'login')]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[contains(@role, 'alert')]/li")).getText()
                .contains("ERROR: The password field is empty"), "Alert message does not contain: 'ERROR: The password field is empty'");
    }

    @Test(priority = 50)
    @Description("Test #5:  Verify error is displayed when password is wrong")
    public void verifyErrorIsDisplayedWhenPasswordWrong(){
        driver.findElement(By.xpath("//li[contains(@class, 'item-10')]")).click();
        driver.findElement(By.xpath("//input[contains(@type, 'text')]")).sendKeys("customer");
        driver.findElement(By.xpath("//input[contains(@type, 'password')]")).sendKeys("invalidpassword");
        driver.findElement(By.xpath("//button[contains(@name, 'login')]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[contains(@role, 'alert')]/li")).getText()
                .contains("ERROR: The password you entered for the username customer is incorrect. Lost your password?"), "Alert message does not contain: 'ERROR: The password field is not incorrect'");
    }

    @Test(priority = 60)
    @Description("Test #6:  Verify error is displayed when user does not exist")
    public void verifyErrorIsDisplayedWhenUserDontExist(){
        driver.findElement(By.xpath("//li[contains(@class, 'item-10')]")).click();
        driver.findElement(By.xpath("//input[contains(@type, 'text')]")).sendKeys("invaliduser");
        driver.findElement(By.xpath("//input[contains(@type, 'password')]")).sendKeys("pass1234");
        driver.findElement(By.xpath("//button[contains(@name, 'login')]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[contains(@role, 'alert')]/li")).getText()
                .contains("ERROR: Invalid username. Lost your password?"), "Alert message does not contain: 'ERROR: Invalid username'");
    }

    @Test(priority = 70)
    @Description("Test #7:  Verify successful login")
    public void verifySuccessfulLogin(){
        driver.findElement(By.xpath("//li[contains(@class, 'item-10')]")).click();
        driver.findElement(By.xpath("//input[contains(@type, 'text')]")).sendKeys("customer");
        driver.findElement(By.xpath("//input[contains(@type, 'password')]")).sendKeys("crz7mrb.KNG3yxv1fbn");
        driver.findElement(By.xpath("//button[contains(@name, 'login')]")).click();
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//div[contains(@class, 'MyAccount-content')]/p[1]"))
                , "Hello Katalon Parlitul_Changed"));
    }

    @AfterMethod
    public void afterMethod(){

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
