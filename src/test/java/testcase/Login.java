package testcase;
import browser.Launchquit;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screenshot.Screenshots;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Login extends Launchquit {

	    @Test
	    public void validLoginTest() throws InterruptedException {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

	        driver.findElement(By.xpath("//a[text()='Login']")).click();
	        Screenshots.captureScreenshot(driver, "ClickLogin");
            driver.findElement(By.xpath("//*[@class=\"r4vIwl BV+Dqf\"]")).sendKeys("9688631572");
            Screenshots.captureScreenshot(driver, "EnterMobile");
	        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[2]/div/form/div[3]/button")).click();
	        Screenshots.captureScreenshot(driver, "ClickGetOTP");
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/header/div[2]/div[2]/div/div/div/div/a")));
            Screenshots.captureScreenshot(driver, "AfterOTP");        
            boolean loginSuccess = driver.getPageSource().contains(" Account");
            Screenshots.captureScreenshot(driver, "Login");
            Assert.assertTrue(loginSuccess, "Logged in with valid credentials");
	    }

	    @AfterMethod
	    public void afterEachTest(ITestResult result) {
	        captureOnFailure(result);
	    }

	    
	}



