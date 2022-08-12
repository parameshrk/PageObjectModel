package utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import page.Login;


import java.io.IOException;

import static utility.ConfigReader.*;

public class DoLogin extends OpenUrl{


    @BeforeClass
    public void doLogin() throws IOException
    {
        Login login = new Login(driver);
        login.setTxtUser(getUsername());
        login.setTxtPassword(getPassword());
        login.clickLogin();
    }

}
