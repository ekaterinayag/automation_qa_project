package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {

	@Test
		public void modifySomeContact() {
			app.getNavigationHelper().openMainPage();
		    app.getContactHelper().InitContactModification(2);
			app.getContactHelper().deleteContact();
			app.getContactHelper().returnToHomePage();
		}
}
