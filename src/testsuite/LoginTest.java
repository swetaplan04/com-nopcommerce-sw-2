package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String BaseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp()
    {
        openBrowser(BaseUrl);
    }

    @Test

    public void userShouldNavigateToLoginPageSuccessfully() {
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        String expectMessage = "Welcome, Please Sign In!";

        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        String actualMessage = actualMessageElement.getText();

        Assert.assertEquals("login page not matching", actualMessage, expectMessage);

    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        String expectedMessage = "Log out";
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        WebElement userName = driver.findElement(By.id("Email"));
        userName.sendKeys("ap112@yahoo.com");

        WebElement password = driver.findElement(By.name("Password"));
        password.sendKeys("Ambe@123");

        WebElement login = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        login.click();

        WebElement actualMessageelement = driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));
        String actualMessage = actualMessageelement.getText();

        Assert.assertEquals("Logout text is not matching", actualMessage, expectedMessage);
    }

    @Test
    public void verifyTheErrorMessage() {
        String expectedMessage = "Login was unsuccessful. please correct the error and try again.\n"
                + "No customer account found";
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();


        WebElement password = driver.findElement(By.name("Password"));
        password.sendKeys("Ambe@123");

        WebElement login = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        login.click();

        WebElement actualMessageElement = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button"));
        String actualMessage = actualMessageElement.getText();

        Assert.assertEquals("Error Message not displayed",actualMessage,expectedMessage);
    }
    @After
    public void tearDown()
    {
        closeBrowser();
    }
}