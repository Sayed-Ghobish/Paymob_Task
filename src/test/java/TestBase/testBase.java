package TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class testBase {
    public static WebDriver driver;

    @BeforeTest()
    public void openBrowser()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    @AfterTest()
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
