package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import browser.Launchquit;
import screenshot.Screenshots;

import java.time.Duration;

public class Order extends Launchquit {

	@Test(dependsOnMethods = {"testcase.Login.validLoginTest"})
    public void placeOrderTest() throws InterruptedException {
    	Login login = new Login();
        login.driver = driver; 
        driver.get("https://www.flipkart.com/viewcart?exploreMode=true&preference=FLIPKART");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Screenshots.captureScreenshot(driver, "cartPage");
        WebElement placeOrderBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Place Order'] | //button[normalize-space()='Place Order']")));
        placeOrderBtn.click();
        Screenshots.captureScreenshot(driver, "PaymentPage");
        Assert.assertTrue(driver.getPageSource().contains("Payment"), "Payment page failed");
    }
}
