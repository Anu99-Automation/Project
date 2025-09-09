package browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import screenshot.Screenshots;
import org.testng.ITestResult;
import java.time.Duration;

public class Launchquit {
	 public static WebDriver driver;

	 @BeforeTest
	    public void setUp() {
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().window().maximize();
	        driver.get("https://www.flipkart.com");
	    }

	    @AfterTest
	    public void quit() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
   public void captureOnFailure(ITestResult result) {
	        if (ITestResult.FAILURE == result.getStatus()) {
	            Screenshots.captureScreenshot(driver, result.getName());
	        }
	    }

}
