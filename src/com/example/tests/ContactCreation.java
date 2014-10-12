package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreation extends TestBase{
  
  @Test
  public void testContactCreation() throws Exception {
    openMainPage();
    openContactCreationPage();
    ContactData contact = new ContactData();
    contact.firstname = "frau";
	contact.lastname = "fraulein";
	contact.address1 = "vesnast";
	contact.home = "99999999999999999999";
	contact.mobile = "888888888888888888888";
	contact.work = "7777777777777777777777";
	contact.email1 = "jkgh@sdf.com";
	contact.email2 = "sdjkfh@sdlfk.com";
	contact.bday = "1";
	contact.bmonth = "January";
	contact.byear = "1989";
	contact.group = "Freunde";
	contact.address2 = "naukipr";
	contact.phone2 = "6666666666666666666666";
	fillContactForm(contact);
    submitContactCreation();
    returnToHomePage();}
}


  
