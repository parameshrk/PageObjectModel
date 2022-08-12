package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword {


    @FindBy(xpath = "//input[@id='email']")
    WebElement txtEmail;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnReset;


    public ForgotPassword(WebDriver driver)  //constructor
    {
        PageFactory.initElements(driver,this);
    }

    public void setTxtEmail(String email)
    {
        txtEmail.sendKeys(email);
    }

    public void clickResetButton()
    {
        btnReset.click();
    }
}


