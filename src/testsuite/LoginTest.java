package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Create the package ‘testsuite’ and create the
 * following class inside the ‘testsuite’ package.
 * 1. LoginTest
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userSholdLoginSuccessfullyWithValid Credentials
 * Enter “standard_user” username
 * Enter “secret_sauce” password
 * Click on ‘LOGIN’ button
 * Verify the text “PRODUCTS”
 * 2. verifyThatSixProductsAreDisplayedOnPage
 * Enter “standard_user” username
 * Enter “secret_sauce” password
 * Click on ‘LOGIN’ button
 * Verify that six products are displayed on
 * page
 */
public class LoginTest extends BaseTest {
    String BaseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser();
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException {
        //Enter “standard_user” username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(2000);
        // Enter “secret_sauce” password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        // Click on ‘LOGIN’ button
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);
        // Verify the text “PRODUCTS”
       // String expectedResult = "PRODUCTS";
        String expectedResult = "Products";
        String actualResult = driver.findElement(By.xpath("//span[text() = 'Products']")).getText();
        Assert.assertEquals("Incorrect Text message", expectedResult, actualResult);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() throws InterruptedException {
        //Enter “standard_user” username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(2000);
        // Enter “secret_sauce” password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        // Click on ‘LOGIN’ button
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);
        // Verify that six products are displayed on
        //find the web elements list
        List<WebElement> products = driver.findElements(By.className("inventory_item"));
        System.out.println("Total products are: " + products.size());
        Thread.sleep(2000);
        //for each loop
        for (WebElement productsList : products) {
            System.out.println(productsList.getSize());
            System.out.println(productsList.getAttribute("div"));
        }
        Thread.sleep(2000);
        Assert.assertEquals(products.size(), 6);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
