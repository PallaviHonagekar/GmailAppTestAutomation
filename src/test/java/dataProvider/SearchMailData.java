package dataProvider;

import org.testng.annotations.DataProvider;

import constants.Constant;

public class SearchMailData {
	@DataProvider(name = Constant.MAIL_DATA_DATA_PROVIDER)
	public static Object[][] loginCredentials() {
		 return new Object[][] { {"Test mail"} };
	}
}
