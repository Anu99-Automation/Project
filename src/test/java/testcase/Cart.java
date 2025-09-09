package testcase;

import browser.Launchquit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;
import screenshot.Screenshots;

public class Cart extends Launchquit {

	@Test(dependsOnMethods = {"testcase.Login.validLoginTest"})
    public void addToCartTest() throws IOException, InterruptedException {
            driver.get("https://www.flipkart.com/samsung-galaxy-f36-5g-violet-128-gb/p/itm85ca200fd55e9?pid=MOBHDFVTH22ZAZXZ&lid=LSTMOBHDFVTH22ZAZXZMFVJDX&marketplace=FLIPKART&store=tyy%2F4io&srno=b_1_1&otracker=nmenu_sub_Electronics_0_Vivo&fm=Search&iid=en_yUuSjkErlPj11Fuu8pOceHW4LJnW8hE_sww8tPZtOcPHif4GvpBBjVCJ0_Oj85K-1fH9XrjIY6ovQS1iYWmTS_UFjCTyOHoHZs-Z5_PS_w0%3D&ppt=browse&ppn=browse");
            Screenshots.captureScreenshot(driver, "OpenProductPage");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Add to cart')]")));
            Screenshots.captureScreenshot(driver, "AddToCartButtonVisible");
            addToCartBtn.click();
            Screenshots.captureScreenshot(driver, "ClickedAddToCart");
            WebElement cartUpdateMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Place Order')]")));
            Screenshots.captureScreenshot(driver, "CartUpdated");
   }

    @AfterMethod
    public void afterEachTest(ITestResult result) {
        captureOnFailure(result);
    }
}
