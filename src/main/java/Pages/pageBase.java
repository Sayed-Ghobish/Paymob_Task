package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class pageBase {

    protected WebDriver driver;

    public pageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //method for waiting element until Visible
    public void waitTillVisible(WebElement element, int timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //method for waiting to specific time
    public void waitUntilVisible(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    //method for hover
    public void hoverOverElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }


    //method for click
    public void clickByAction(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});",element);
    }

}
