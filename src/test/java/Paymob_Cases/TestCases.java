package Paymob_Cases;

import Pages.createAccountPage;
import Pages.homePage;
import Pages.pageBase;
import TestBase.testBase;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utiles.excelReader;
import utiles.Screenshots;
import static utiles.assertionHelper.assertElementIsDisplayed;
import java.io.IOException;


public class TestCases extends testBase {
    homePage homeObj;
    createAccountPage createObj;
    pageBase pageObj;


    @DataProvider(name = "createAccount")
    public Object[][] getData() throws IOException {
        return excelReader.getExcelData("CreateAccountData.xlsx", 0);
    }

    @Test(dataProvider = "createAccount")
    public  void SingUp(String ftName, String ltName, String email, String pass, String conPass)
    {
        homeObj =new homePage(driver);
        createObj =new createAccountPage(driver);
        pageObj =new pageBase(driver);
        pageObj.clickByAction(homeObj.createAccountBTN);
        createObj.createAccount(ftName,ltName,email,pass,conPass);
        try {
            Screenshots.takeScreenshot(driver, "Account Created Successfully", createObj.successMessage);
        } catch (IOException e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
        }
        assertElementIsDisplayed(createObj.successMessage,"Success message Will be appeared if Account created");

    }

    @Test(dependsOnMethods = {"SingUp"})
    public void reachHomePage()
    {
        homeObj =new homePage(driver);
        createObj =new createAccountPage(driver);
        pageObj =new pageBase(driver);
        homeObj.homePageBTN.click();
        assertElementIsDisplayed(homeObj.homePageTitle,"user should be redirected to home page");
        try {
            Screenshots.takeScreenshot(driver, "User Redirected to Home Page", homeObj.homePageTitle);
        } catch (IOException e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
        }
        assertElementIsDisplayed(homeObj.homePageTitle,"Success message Will be appeared if Account created");

    }

    @Test(dependsOnMethods = {"reachHomePage"})
    public void addProductsToCard()
    {
        homeObj =new homePage(driver);
        createObj =new createAccountPage(driver);
        pageObj =new pageBase(driver);
        pageObj.scrollToElement(homeObj.hotSellerSection);
        pageObj.waitUntilVisible(homeObj.hotSellerSection,5);
        assertElementIsDisplayed(homeObj.hotSellerSection,"HotSeller Section appears with Products");
        try {
            Screenshots.takeScreenshot(driver, "HotSeller Section appears", homeObj.hotSellerSection);
        } catch (IOException e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
        }
        homeObj.hoverAndAddOnlyTwoProductsToCart();
        pageObj.scrollToElement(homeObj.homePageBTN);
        pageObj.waitUntilVisible(homeObj.cardIcon, 5);
        assertElementIsDisplayed(homeObj.successForAddProduct,"Success message Will be appeared if products added done");
        try {
            Screenshots.takeScreenshot(driver, "111", homeObj.cardIcon);
        } catch (IOException e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
        }


    }
}
