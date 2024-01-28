package Selenium.Java;

import org.testng.annotations.Test;

import PageObjects.UsersPage;
import testSetup.Base;

public class Test1 extends Base {

	@Test
	public void user() {

		UsersPage u = new UsersPage();
		u.NavigateToUsers();

	}

}
