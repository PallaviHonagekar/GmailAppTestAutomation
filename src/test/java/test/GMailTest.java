package test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import basePackage.TestBase;
import constants.Constant;
import dataProvider.MailDataProvider;

@Listeners(listener.TestListener.class)
public class GMailTest extends TestBase{
	
	 @Test(dataProvider = Constant.MAIL_DATA_DATA_PROVIDER, dataProviderClass = MailDataProvider.class)
	 public void testStarredMail(String email, String password, String toAddress, String subject, String message, String searchText) {
		 loginPage.login(email, password);
		 String emailOfStarredMail = inboxPage.starAnEmail().toLowerCase();
		 System.out.println("*******************"+emailOfStarredMail);
		 Assert.assertTrue(starredMailPage.checkStarredMail(emailOfStarredMail),"Starred mail not found");
	 }
	
	 @Test(dataProvider = Constant.MAIL_DATA_DATA_PROVIDER, dataProviderClass = MailDataProvider.class)
	 public void testDraftMail(String email, String password, String toAddress, String subject, String message, String searchText) {
		 loginPage.login(email, password);
		 composeMailPage.composeAndCancelMail(toAddress, subject, message);
		 Assert.assertTrue(draftsMailPage.checkDrafts(subject), "No draft mail found with given mail suject");
	 }
	 
	 @Test(dataProvider = Constant.MAIL_DATA_DATA_PROVIDER, dataProviderClass = MailDataProvider.class)
	 public void testSearchMail(String email, String password, String toAddress, String subject, String message, String searchSubject) {
		 loginPage.login(email, password);
		 Assert.assertTrue(searchMail.searchAnyMailBySubject(searchSubject.toLowerCase()), "Search result not found");
	 }
}
