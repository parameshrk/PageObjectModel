package regression;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import page.ForgotPassword;
import page.Login;
import utility.ConfigReader;

import java.io.IOException;

public class ForgotPassTest {

    @Test
    public void forgotPasswordTest() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
       // driver.get("http://[::1]/invoiceplane/index.php/sessions/login");

        driver.get(ConfigReader.getUrl());

        Login Login = new Login(driver);

        Login.clickForgotPass();

        ForgotPassword forgotPassword = new ForgotPassword (driver);

       // forgotPassword.setTxtEmail("rkparamesh92@gmai.com");

        forgotPassword.setTxtEmail(ConfigReader.getUsername());

        forgotPassword.clickResetButton();


    }
}
