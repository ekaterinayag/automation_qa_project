package com.example.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContactCreation extends TestBase{
	
 @Test (dataProvider = "randomValidContactGenerator")
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
    app.getNavigationHelper().openMainPage();
        
    //save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
    
    //actions
    app.getContactHelper().openContactCreationPage();
    contact.bday = "15";
	contact.bmonth = "January";
	contact.byear = "1989";
	contact.group = "Bob1";
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  
  	//save new state
    List<ContactData> newList = app.getContactHelper().getContacts();
  
  	//compare states
   
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
	
	}
}



  
