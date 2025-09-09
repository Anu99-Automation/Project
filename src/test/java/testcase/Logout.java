package testcase;
import browser.Launchquit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
public class Logout extends Launchquit {
	@Test(dependsOnMethods = {"testcase.Login.validLoginTest"})
	    public void logoutTest() {
	        driver.findElement(By.xpath("//a[text()='Logout']")).click();
            Assert.assertTrue(driver.getPageSource().contains("Login"), "Logout failed!");
	    }

	    @AfterMethod
	    public void afterEachTest(ITestResult result) {
	        captureOnFailure(result);
	    }

}
