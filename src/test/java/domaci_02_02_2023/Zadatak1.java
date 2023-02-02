package domaci_02_02_2023;

import helper__template.Helper;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Zadatak1 {
    //Kreirati BootstrapTableTests klasu koja ima:
    //Base url: https://s.bootsnipp.com
    //Test #1: Edit Row
    //Podaci:
    //First Name: ime polaznika
    //Last Name: prezime polaznika
    //Middle Name: srednje ime polanzika
    //Koraci:
    //Ucitati stranu /iframe/K5yrx
    //Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
    //Klik na Edit dugme prvog reda
    //Sacekati da dijalog za Editovanje bude vidljiv
    //Popuniti formu podacima.
    //Bice potrebno da pre unosa tekst pobrisete tekst koji vec postoji, za to se koristi metoda clear. Koristan link
    //Klik na Update dugme
    //Sacekati da dijalog za Editovanje postane nevidljiv
    //Verifikovati da se u First Name celiji prvog reda tabele javlja uneto ime
    //Verifikovati da se u Last Name celiji prvog reda tabele javlja uneto prezime
    //Verifikovati da se u Middle Name celiji prvog reda tabele javlja uneto srednje ime
    //Za sve validacije ispisati odgovarajuce poruke u slucaju greske
    //
    //Test #2: Delete Row
    //Podaci:
    //First Name: ime polaznika
    //Last Name: prezime polaznika
    //Middle Name: srednje ime polanzika
    //Koraci:
    //Ucitati stranu /iframe/K5yrx
    //Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
    //Klik na Delete dugme prvog reda
    //Sacekati da dijalog za brisanje bude vidljiv
    //Klik na Delete dugme iz dijaloga
    //Sacekati da dijalog za Editovanje postane nevidljiv
    //Verifikovati da je broj redova u tabeli za jedan manji
    //Za sve validacije ispisati odgovarajuce poruke u slucaju greske
    //
    //Test #3: Take a Screenshot
    //Koraci:
    //Ucitati stranu  /iframe/K5yrx
    //Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
    //Kreirati screenshot stranice.
    //Fajl cuvajte na putanji gde su vam bile slike od proslog domaceg. Na putanji: screenshots/slike.png
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseURL = "https://s.bootsnipp.com";
    private ArrayList<String> listaPodatakaPolaznika;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        this.driver.get(this.baseURL);
    }

    @BeforeMethod
    public void beforeMethod(){
        this.listaPodatakaPolaznika = new ArrayList<>();
        this.listaPodatakaPolaznika.add("Nikola");
        this.listaPodatakaPolaznika.add("Prvulovic");
        this.listaPodatakaPolaznika.add("Miodrag");
        this.driver.navigate().to(this.baseURL + "/iframe/K5yrx");
        Assert.assertEquals(this.driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com", "Title actual != title expected");
    }

    @Test (priority = 1)
    @Description("Test #1: Edit and Update Table Data")
    public void tableDataEdit(){
        this.driver.findElement(By.xpath("//tr[1]//button[@data-target='#edit']")).click();
        this.wait.until(ExpectedConditions.visibilityOf(this.driver.findElement(By.xpath("//div[@id='edit']//div[@class='modal-dialog']"))));
        
        List<WebElement> inputList = this.driver.findElements(By.xpath("//div[@id='edit']//div[@class='modal-body']/input"));
        List<WebElement> tableData = this.driver.findElements(By.xpath("//tbody/tr[1]/td[position()>1 and position()<5]"));
        for (int i = 0; i < inputList.size(); i++) {
            inputList.get(i).clear();
            inputList.get(i).sendKeys(this.listaPodatakaPolaznika.get(i));
        }
        this.driver.findElement(By.xpath("//button[@id='up']")).click();
        this.wait.until(ExpectedConditions.invisibilityOf(this.driver.findElement(By.xpath("//div[@id='edit']//div[@class='modal-dialog']"))));

        for (int i = 0; i < tableData.size(); i++) {
            Assert.assertEquals(tableData.get(i).getText(), this.listaPodatakaPolaznika.get(i), "Expected name != actual name");
        }
    }

    @Test(priority = 2)
    @Description("Test #2: Delete Row")
    public void deleteRow(){
        int rowsBeforeDelete = this.driver.findElements(By.xpath("//tbody/tr")).size();
        this.driver.findElement(By.xpath("//tr[1]//button[@data-target='#delete']")).click();
        this.wait.until(ExpectedConditions.visibilityOf(this.driver.findElement(By.xpath("//div[@id='delete']//div[@class='modal-body']"))));
        this.driver.findElement(By.xpath("//button[@id='del']")).click();
        Assert.assertEquals(this.driver.findElements(By.xpath("//tbody/tr")).size(), rowsBeforeDelete, "Number of rows expected != actual");
    }

    @Test (priority = 3)
    @Description("Test #3: Take a Screenshot")
    public void takeScreenshot() throws IOException {
        new Helper().takeScreenshot(this.driver, "screenshots/slike", ".png");
    }

    @AfterMethod
    public void afterMethod(){

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
