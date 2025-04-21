package Pages;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class createAccountPage extends pageBase{
    public createAccountPage(WebDriver driver) {
        super(driver);
    }

    //First name field
    @FindBy(id ="firstname")
    WebElement firstName;

    //Last name field
    @FindBy(id="lastname")
    WebElement lastName;

    //Email field
    @FindBy(id ="email_address")
    WebElement emailFiled;

    //password field
    @FindBy(id = "password")
    WebElement password;

    //confirm password field
    @FindBy(id = "password-confirmation")
    WebElement confirmPass;

    //button of submit data for create account
    @FindBy(xpath ="//button[@title='Create an Account']")
    WebElement createBTN;

    //element for success message that's appears after user have been created account
    @FindBy(xpath = "//div[contains(text(),'Thank you for registering')]")
    public WebElement successMessage;

    public void createAccount(String ftName, String ltName, String email, String pass, String conPass){
        firstName.sendKeys(ftName);
        lastName.sendKeys(ltName);
        emailFiled.sendKeys(email);
        password.sendKeys(pass);
        confirmPass.sendKeys(conPass);
        clickByAction(createBTN);
    }


}
