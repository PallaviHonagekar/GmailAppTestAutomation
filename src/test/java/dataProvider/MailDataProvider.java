package dataProvider;

import org.testng.annotations.DataProvider;
import constants.Constant;

public class MailDataProvider {
	@DataProvider(name = Constant.MAIL_DATA_DATA_PROVIDER)
	public static Object[][] mailData() {
		 return new Object[][] { {"pallavihonagekar@gmail.com", "bappa1993", "pallavihonagekar@gmail.com",
			 "Test Mail", "Hello PAllavi", "Test mail"} };
	}
}
