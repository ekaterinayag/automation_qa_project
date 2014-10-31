package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {

	@Test
		public void modifySomeContact() {
			app.getNavigationHelper().openMainPage();
			
			//save old state
		    List<ContactData> oldList = app.getContactHelper().getContacts();
		    
		  //at least one contact should exist!
		    Random rnd = new Random();
		    int index = rnd.nextInt(oldList.size()-1);
		    
		    //actions
		    app.getContactHelper().InitContactModification(index);
			app.getContactHelper().deleteContact();
			app.getContactHelper().returnToHomePage();
			
			//save new state
		    List<ContactData> newList = app.getContactHelper().getContacts();
		  
		  	//compare states
		   
		    oldList.remove(index);
		    Collections.sort(oldList);
		    assertEquals(newList, oldList);
			
		}
}
