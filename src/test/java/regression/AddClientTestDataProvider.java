package regression;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.Clients;
import page.Login;
import page.Menu;
import utility.DoLogin;

import java.io.IOException;

import static utility.ConfigReader.*;
import static utility.GetMyData.gettingData;


public class AddClientTestDataProvider {

    WebDriver driver;

    @BeforeClass
    public void doLogin() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(getUrl());

        Login login = new Login(driver);

        login.setTxtUser(getUsername());
        login.setTxtPassword(getPassword());
        login.clickLogin();
    }



    @Test (dataProvider = "getData")
    public void addClientTest(String name ,String surname ,
                              String language ,String address1 ,String address2 ,
                              String city ,String state ,String zip ,String country ,
                              String gender ,String birthdate ,String phone ,
                              String fax ,String mobile ,String email ,
                              String web ,String vat ,String tax ,String expected,
                              String xpathActual) throws IOException {

        Menu menu = new Menu(driver);
        menu.clickAddClient();

        Clients clients = new Clients(driver);

        clients.setClientName(name);
        clients.setClientSurname(surname);
        clients.setLanguage(language);
        clients.setClientAdd1(address1);
        clients.setClientAdd2(address2);
        clients.setClientCity(city);
        clients.setClientState(state);
        clients.setClientZip(zip);
        clients.setCountry(country);
        clients.setGender(gender);
        clients.setBirthDate(birthdate);
        clients.setClientPhone(phone);
        clients.setClientFax(fax);
        clients.setClientMobile(mobile);
        clients.setClientEmail(email);
        clients.setClientWeb(web);
        clients.setClientVat(vat);
        clients.setClientTax(tax);
        clients.clickSave();

        String actual = "";

        try {
            actual = driver.findElement(By.xpath(xpathActual)).getText();

        } catch (Exception e)
        {

        }

        System.out.println("actual="+actual);
        System.out.println("expected="+expected);
        Assert.assertEquals(actual,expected,"wrong message");



    }

    @DataProvider
    public Object[][] getData() throws IOException {
        return gettingData("Data/Invoiceplane.xlsx", "Sheet1");
    }
}