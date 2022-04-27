package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void openUp() {
        openBrowser(baseUrl);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

    @Test
    public void verifyThatSigningUpPageDisplay() {
        clickOnElement(By.linkText("Register"));

        String expectedText = "Signing up is easy!";

        String actualText = getTextFromElement(By.xpath("//h1[@class='title']"));

        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userSholdRegisterAccountSuccessfully() {
        clickOnElement(By.linkText("Register"));
        sendTextToElement(By.id("customer.firstName"),"Pavan");
        sendTextToElement(By.id("customer.lastName"),"Kumar");
        sendTextToElement(By.id("customer.address.street"),"28 ABC street");
        sendTextToElement(By.id("customer.address.city"),"London");
        sendTextToElement(By.id("customer.address.state"),"Gujarat");
        sendTextToElement(By.id("customer.address.zipCode"),"382345");
        sendTextToElement(By.id("customer.phoneNumber"),"123456789");
        sendTextToElement(By.id("customer.ssn"),"A2315DHV215");
        sendTextToElement(By.id("customer.username"),"Abc_1234567");
        sendTextToElement(By.id("customer.password"), "123456789");
        sendTextToElement(By.id("repeatedPassword"),"123456789");
        clickOnElement(By.xpath("//input[@value='Register']"));

        String expectedText = "Your account was created successfully. You are now logged in.";
        String actualText = getTextFromElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"));
        Assert.assertEquals(expectedText, actualText);
    }
}