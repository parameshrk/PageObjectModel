package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    /*WebDriver driver;
    WebElement element = driver.findElement(By.xpath("//input[@id='email']"));*/

    @FindBy (xpath = "//input[@id='email']")
    public WebElement txtUser;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement txtPassword;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement btnLogin;

    @FindBy(xpath = "//a[@class='btn btn-default']")
    public WebElement lnkForgotPass;

    @FindBy(xpath = "//label[@for='email']")
    public WebElement lblEmail;

    @FindBy(xpath = "//label[@for='password']")
    public WebElement lblPassword;

    public Login(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void setTxtUser(String username) {
        txtUser.sendKeys(username);
    }

    public void setTxtPassword(String password) {
        txtPassword.sendKeys(password);
    }

    public void clickLogin() {
        btnLogin.click();
    }

    public void clickForgotPass() {
        lnkForgotPass.click();
    }

}
