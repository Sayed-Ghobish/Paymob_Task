package utiles;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class assertionHelper {

    //Assert that the element is displayed.
    public static void assertElementIsDisplayed(WebElement element, String message) {
        Assert.assertTrue(element.isDisplayed(), message + "Element doesn't appear");
    }
}
