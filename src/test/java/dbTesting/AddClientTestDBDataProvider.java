package dbTesting;

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
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;

import static utility.ConfigReader.*;
import static utility.Conversions.*;
import static utility.GetMyData.gettingData;


public class AddClientTestDBDataProvider {

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
                              String web ,String vat ,String tax) throws IOException, ClassNotFoundException, SQLException, ParseException {

        ArrayList<String> expected = new ArrayList<>();
        expected.add(name);
        expected.add(surname);
        expected.add(language.toLowerCase());
        expected.add(address1);
        expected.add(address2);
        expected.add(city);
        expected.add(state);
        expected.add(zip);
        expected.add(country);
        expected.add(gender);
        expected.add(birthdate);
        expected.add(phone);
        expected.add(fax);
        expected.add(mobile);
        expected.add(email);
        expected.add(web);
        expected.add(vat);
        expected.add(tax);

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

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(getDbUrl(),getDbUser(),getDbPassword()) ;

        Statement st = con.createStatement();

        String sql = "select * from ip_clients where client_name='"+name+"'";

        ResultSet rs = st.executeQuery(sql);

        ArrayList<String> actual = new ArrayList<>();

        while (rs.next())
        {
            actual.add(rs.getString("client_name"));
            actual.add(rs.getString("client_surname"));
            actual.add(rs.getString("client_language"));
            actual.add(rs.getString("client_address_1"));
            actual.add(rs.getString("client_address_2"));
            actual.add(rs.getString("client_city"));
            actual.add(rs.getString("client_state"));
            actual.add(rs.getString("client_zip"));

            String shortCountry = rs.getString("client_country"); // IN
            String fullCountry = convertCountry(shortCountry); // India

            actual.add(fullCountry);


            actual.add(getGenderFullForm(rs.getString("client_gender")));


            actual.add(convertDate(rs.getString("client_birthdate")));


            actual.add(rs.getString("client_phone"));
            actual.add(rs.getString("client_fax"));
            actual.add(rs.getString("client_mobile"));
            actual.add(rs.getString("client_email"));
            actual.add(rs.getString("client_web"));
            actual.add(rs.getString("client_vat_id"));
            actual.add(rs.getString("client_tax_code"));
        }

        System.out.println("actual="+actual);
        System.out.println("expected="+expected);
        Assert.assertEquals(actual,expected,"result does not match");
    }




      /*  System.out.println("actual="+actual);
        System.out.println("expected="+expected);
        Assert.assertEquals(actual,expected,"wrong message");
*/




    @DataProvider
    public Object[][] getData() throws IOException {
        return gettingData("Data/Invoiceplane.xlsx", "Db Testing");
    }
}