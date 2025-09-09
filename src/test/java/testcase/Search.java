package testcase;
import browser.Launchquit;
import screenshot.Screenshots;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Search extends Launchquit {
	@Test(dependsOnMethods = {"testcase.Login.validLoginTest"})
    public void searchProductTest() {
        driver.findElement(By.name("q")).sendKeys("iPhone");
        Screenshots.captureScreenshot(driver, "searchkeyword");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Screenshots.captureScreenshot(driver, "searchresult");
        Assert.assertTrue(driver.getPageSource().contains("iPhone"), "Product search failed!");
    }

    @AfterMethod
    public void afterEachTest(ITestResult result) {
        captureOnFailure(result);
    }

}
