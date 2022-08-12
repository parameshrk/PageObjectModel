package UITesting;

import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.Login;
import utility.OpenUrl;

public class LoginTest extends OpenUrl {

    Login login;

    @BeforeClass
    public void initLogin() {
        login = new Login(driver);
    }

    @Test
    public void txtUsernameVisibility() {
        boolean expected = true;
        boolean actual = false;
        try {
            actual = login.txtUser.isDisplayed();
        } catch (Exception e) {
            //   actual = false;
        }

        System.out.println("expected=" + expected);
        System.out.println("actual=" + actual);

        Assert.assertEquals(actual, expected, "element not present");
    }

    @Test
    public void txtPasswordEnability() {
        boolean expected = true;
        boolean actual = false;
        try {
            actual = login.txtPassword.isEnabled();
        } catch (Exception e) {
        }

        System.out.println("expected=" + expected);
        System.out.println("actual=" + actual);

        Assert.assertEquals(actual, expected, "element not enabled");
    }

    @Test
    public void lblEmailSpellCheck() {
        String expected = "Email";
        String actual = "";
        try {
            actual = login.lblEmail.getText();
        } catch (Exception e) {

        }
        System.out.println("expected=" + expected);
        System.out.println("actual=" + actual);

        Assert.assertEquals(actual, expected, "incorrect spelling");

    }

    @Test
    public void txtPasswordWatermark() {
        String expected = "Password";

        String actual = "";
        try {
            actual = login.txtPassword.getAttribute("placeholder");
        } catch (Exception e) {

        }

        System.out.println("expected=" + expected);
        System.out.println("actual=" + actual);

        Assert.assertEquals(actual, expected, "incorrect watermark");

    }

    @Test
    public void lblEmailFontSize() {
        String expected = "14px";

        String actual = "";
        try {
            actual = login.lblEmail.getCssValue("font-size");
        } catch (Exception e) {

        }

        System.out.println("expected=" + expected);
        System.out.println("actual=" + actual);

        Assert.assertEquals(actual, expected, "incorrect font size");

    }


    @Test
    public void lblEmailFontFamilyCheck() {
        String expected = "-apple-system, system-ui, BlinkMacSystemFont, \"Segoe UI\", Roboto, \"Helvetica Neue\", Arial, sans-serif";

        String actual = "";
        try {
            actual = login.lblEmail.getCssValue("font-family");
        } catch (Exception e) {

        }

        System.out.println("expected=" + expected);
        System.out.println("actual=" + actual);

        Assert.assertEquals(actual, expected, "incorrect font family");
    }


    @Test
    public void btnLoginColorCheck() {
        String expected = "#2C8EDD";

        String actual = "";
        try {
            String rgbColor = login.btnLogin.getCssValue("background-color");

            actual = Color.fromString(rgbColor).asHex().toUpperCase();

        } catch (Exception e) {

        }

        System.out.println("expected=" + expected);
        System.out.println("actual=" + actual);

        Assert.assertEquals(actual, expected, "incorrect color");
    }
}