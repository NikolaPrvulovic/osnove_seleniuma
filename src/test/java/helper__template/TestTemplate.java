package helper__template;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class TestTemplate {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseURL = "";

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get(this.baseURL);
    }

    @BeforeMethod
    public void beforeMethod(){

    }

    @Test
    public void test(){

    }

    @AfterMethod
    public void afterMethod(){

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
