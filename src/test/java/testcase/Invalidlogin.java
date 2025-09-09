package testcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import browser.Launchquit;
import screenshot.Screenshots;

public class Invalidlogin extends Launchquit{
	@Test
    public void validLoginTest() throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.xpath("//a[text()='Login']")).click();
        Screenshots.captureScreenshot(driver, "ClickLogin");
        driver.findElement(By.xpath("//*[@class=\"r4vIwl BV+Dqf\"]")).sendKeys("9688631572");
        Screenshots.captureScreenshot(driver, "EnterMobile");
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[2]/div/form/div[3]/button")).click();
        Screenshots.captureScreenshot(driver, "ClickGetOTP");
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'OTP is incorrect')]")));
        Screenshots.captureScreenshot(driver, "IncorrectOTP");
        Assert.assertTrue(errorMsg.isDisplayed(), "Error message not displayed for invalid login");
}
	@AfterMethod
    public void afterEachTest(ITestResult result) {
        captureOnFailure(result);
    }
}
