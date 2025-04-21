package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class homePage extends pageBase{
    public homePage(WebDriver driver) {
        super(driver);
    }

    //Create account button
    @FindBy(xpath ="//a[contains(@href, '/customer/account/create')]")
    public WebElement createAccountBTN;

    // button for navigate to home page
    @FindBy(xpath = "//a[@aria-label='store logo']")
    public WebElement homePageBTN;

    //home page element for verify user redirected to it
    @FindBy(id = "maincontent")
    public WebElement homePageTitle;

    //element for hot seller section
    @FindBy(xpath ="//h2[text()='Hot Sellers']")
    public WebElement hotSellerSection;

    //element for products list
    @FindBy(xpath = "//div[@class='products-grid grid']//li[@class='product-item']")
    List<WebElement> allProducts;

    // element for success message that's appears when user adding product to cart
    @FindBy(xpath = "//div[contains(@class,'message-success')]")
    public WebElement successForAddProduct;

    //element for card icon
    @FindBy(xpath = "//a[@class='action showcart' and contains(@href,'/cart')]")
    public WebElement cardIcon;

    //used to add product to cart
    public void hoverAndAddOnlyTwoProductsToCart() {
        int addedCount = 0;
        int productIndex = 0;

        while (addedCount < 2) {
            if (productIndex >= allProducts.size()) {
                System.out.println("Not enough products found to add 2 items to cart.");
                break;
            }

            WebElement product = allProducts.get(productIndex);

            try {
                hoverOverElement(product);
                List<WebElement> sizeOptions = product.findElements(By.xpath(".//div[contains(@class,'swatch-attribute size')]//div[contains(@class,'swatch-option')]"));
                if (!sizeOptions.isEmpty()) {
                    sizeOptions.get(0).click();
                }
                List<WebElement> colorOptions = product.findElements(By.xpath(".//div[contains(@class,'swatch-attribute color')]//div[contains(@class,'swatch-option')]"));
                if (!colorOptions.isEmpty()) {
                    colorOptions.get(1).click();
                }

                WebElement addToCart = product.findElement(By.xpath(".//button[contains(@class,'tocart')]"));
                waitTillVisible(addToCart, 5);
                addToCart.click();
                scrollToElement(allProducts.get(0));
                addedCount++;

            } catch (Exception e) {
                System.out.println("Skipping product due to exception: " + e.getMessage());
            }
            productIndex++;
        }
    }

}
