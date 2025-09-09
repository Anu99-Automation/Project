package screenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class Screenshots {
    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            TakesScreenshot shot = (TakesScreenshot) driver;
            File source = shot.getScreenshotAs(OutputType.FILE);
            File folder = new File("C:\\Users\\Anu\\Pictures\\Screenshots");
            File destination = new File(folder, screenshotName + ".png");
            FileUtils.copyFile(source, destination);

            System.out.println("Screenshot saved at: " + destination.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}
