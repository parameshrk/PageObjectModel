package regression;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.Clients;
import page.Login;
import page.Menu;
import utility.DoLogin;

import java.io.IOException;

import static utility.ConfigReader.*;

public class AddClientTest extends DoLogin {

        @Test
        public void addClientTest() throws IOException {

            Menu menu = new Menu(driver);
            menu.clickAddClient();

            Clients clients = new Clients(driver);

            clients.setClientName("Priyanka3");
            clients.setClientSurname("bari");
            clients.setLanguage("Danish");
            clients.setClientAdd1("xyz");
            clients.setClientAdd2("abc");
            clients.setClientCity("PUNE");
            clients.setClientState("MH");
            clients.setClientZip("67676767");
            clients.setCountry("Nepal");
            clients.setGender("Female");
            clients.setBirthDate("07/21/1900");
            clients.setClientPhone("787878");
            clients.setClientFax("889899");
            clients.setClientMobile("787878787");
            clients.setClientEmail("a@b.com");
            clients.setClientWeb("www.xyz.com");
            clients.setClientVat("89898");
            clients.setClientTax("898989");
            clients.clickSave();


        }
}
