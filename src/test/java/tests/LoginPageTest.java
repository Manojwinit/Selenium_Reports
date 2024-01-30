package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import TestData.info;
import testSetup.Base;

public class LoginPageTest extends Base {
	LoginPage loginPage;
	HomePage homePage;

	@Test
	public void validLoginTest() throws InterruptedException {
//		System.out.println("Logged in successfully");
		// Make sure the driver is initialized in your Base class or setup method
		homePage = new HomePage();
		homePage.logout();
		homePage.clickHereToLoginAgain();

		loginPage = new LoginPage();
		loginPage.Validlogin(info.USERNAME.getcredentials(), info.PSWD.getcredentials());
	}

	@Test (dependsOnMethods = "validLoginTest")
	public void invalidLoginTest() throws InterruptedException {
		// Make sure the driver is initialized in your Base class or setup method
		homePage = new HomePage();
		homePage.logout();
		homePage.clickHereToLoginAgain();

		loginPage = new LoginPage();
		loginPage.Invalidlogin(info.USERNAME.getcredentials(), "12345");
	}

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
