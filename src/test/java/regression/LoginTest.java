package regression;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import page.Login;
import utility.ConfigReader;

import java.io.IOException;

public class LoginTest {

    @Test
    public void loginTest() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.getUrl());

        Login login = new Login(driver);

        login.setTxtUser(ConfigReader.getUsername());
        login.setTxtPassword(ConfigReader.getPassword());
        login.clickLogin();
    }
}
