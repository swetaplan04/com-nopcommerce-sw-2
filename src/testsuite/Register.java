package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Register extends BaseTest {
    String BaseUrl = "https://demo.nopcommerce.com/";

    @Before

    public void setup()
    {
        openBrowser(BaseUrl);
    }
    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        String expectedMessage = "Register";
        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Register']"));
        String actualMessage = actualMessageElement.getText();
        Assert.assertEquals("Register tab not matching", expectedMessage, actualMessage);
    }
    @Test
    public void userSholdRegisterAccountSuccessfully()
    {
       String expectedMessage = "Your registration completed";
       WebElement registerLink = driver.findElement(By.linkText("Register"));
       registerLink.click();
       WebElement radiobutton = driver.findElement(By.id("gender-male"));
       radiobutton.click();
       WebElement firstName = driver.findElement(By.name("FirstName"));
       firstName.sendKeys("test123");
        WebElement lastName = driver.findElement(By.name("LastName"));
        firstName.sendKeys("test456");
        WebElement dayOfBirthday = driver.findElement(By.name("DateOfBirthday"));
        dayOfBirthday.sendKeys("15");
        WebElement dateOfBirthMonth = driver.findElement(By.name("DateOfBirthMonth"));
        dateOfBirthMonth.sendKeys("October");
        WebElement dateOfBirthYear = driver.findElement(By.name("DateOfBirthYear"));
        dateOfBirthYear.sendKeys("1994");
        WebElement emailID = driver.findElement(By.id("Email"));
        emailID.sendKeys("xyz12345678@gmail.com");
        WebElement password = driver.findElement(By.id("Password"));
        password .sendKeys("Temp123");
        WebElement confirmPassword = driver.findElement(By.id("ConfirmPassword"));
        confirmPassword.sendKeys("Temp123");
        WebElement registerButton = driver.findElement(By.id("register-button"));
        registerButton.click();

        WebElement actualMessageElement = driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        String actualMessage = actualMessageElement.getText();
        Assert.assertEquals("Registration not completed",expectedMessage,actualMessage);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}




