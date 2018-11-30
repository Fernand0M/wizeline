package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class SeleniumTest {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
    	System.setProperty("webdriver.gecko.driver", "C://Drivers//geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://testapp.galenframework.com/");
    }


    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}
