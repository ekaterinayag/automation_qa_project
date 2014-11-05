package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactRemovalTests extends TestBase {

	@Test (dataProvider = "randomValidContactGenerator")
		public void deleteSomeContact(ContactData contact) {
						
			//save old state
			SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
		    
		  //at least one contact should exist!
		    Random rnd = new Random();
		    int index = rnd.nextInt(oldList.size()-1);
		    
		    //actions
		    app.getContactHelper().deleteContact(index);
		    				
			//save new state
		    SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
		  
		  	//compare states
		    assertThat(newList, equalTo(oldList.without(index)));
			
		}
}
