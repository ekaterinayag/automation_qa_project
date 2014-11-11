package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactRemovalTests extends TestBase {

@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i= 0; i < 5; i++) {
			ContactData contact = new ContactData()
			.withFirstName(generateRandomString())
			.withLastName(generateRandomString())
			.withAddress1(generateRandomString())
			.withHome(generateRandomString())
			.withMobile(generateRandomString())
			.withWork(generateRandomString())
			.withEmail1(generateRandomString())
			.withEmail2(generateRandomString())
			.withAddress2(generateRandomString())
			.withPhone2(generateRandomString());
			//contact.bday = "5";
			//contact.bmonth = "January";
			//contact.byear = "1989";
			//contact.group = "Freunde";
			list.add(new Object[]{contact});
		}
		return list.iterator();
	}	
	
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
