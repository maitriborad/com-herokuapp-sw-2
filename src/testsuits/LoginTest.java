package testsuits;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseURL = "http://the-internet.herokuapp.com/login";
    @Before
    public void setUp() {
        openBrowser(baseURL);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Enter “tomsmith” username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        //Enter “SuperSecretPassword!” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();
        //Verify the text “Secure Area”
        String actualText=driver.findElement(By.xpath("//h2[text()=' Secure Area']")).getText();
        String expectedText="Secure Area";
        Assert.assertEquals("Message not displayed successfully",expectedText,actualText);
    }
    @Test
    public void verifyTheUsernameErrorMessage(){
        //Enter “tomsmith1” username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith1");
        //Enter “SuperSecretPassword!” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();
        //Verify the error message “Your username is invalid!”
        String actualMessage=driver.findElement(By.xpath("//div[@id='flash']")).getText();
        String expectedMessage="Your username is invalid!\n" +
                "×";
        Assert.assertEquals("Message is not displayed correctly",expectedMessage,actualMessage);
    }
    @Test
    public void verifyThePasswordErrorMessage(){
        //Enter “tomsmith” username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        //Enter “SuperSecretPassword” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();
        //Verify the error message “Your password is invalid!”
        String actualMessage=driver.findElement(By.xpath("//div[@id='flash']")).getText();
        String expectedMessage="Your password is invalid!\n" +
                "×";
        Assert.assertEquals("Message is not displayed correctly",expectedMessage,actualMessage);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
