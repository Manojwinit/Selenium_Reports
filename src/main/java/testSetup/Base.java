package testSetup;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import PageObjects.LoginPage;
import driverManagerFactory.DriverManager;
import driverManagerFactory.DriverManagerFactory;
import driverManagerFactory.DriverType;

public class Base {

    public static WebDriver driver;
    DriverManager driverManager;
    LoginPage loginPage;

    @BeforeClass
	public void setup() throws InterruptedException {
		System.out.println("Setting up the test environment...");
		driverManager = DriverManagerFactory.getDriveManager(DriverType.CHROME);
		driver = driverManager.getWebDriver();
		driver.get(DriverType.COMMON_URL);
		driver.manage().window().maximize();

		loginPage = new LoginPage();
		loginPage.Validlogin("ksaadmin", "1234");
	}

	public String getScreenShotPath(String testMethodName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// String destinationFile = System.getProperty("user.dir") + "\\reports\\"// +testMethodName + ".png";
		String destinationFile = 
		System.getProperty("C:\\Users\\winit\\git\\Selenium_Reports\\reports") + File.separator+ testMethodName + ".png";
		// = System.getProperty("user.dir") + File.separator + "reports" +
		// File.separator+ testMethodName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
