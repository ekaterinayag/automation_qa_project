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

public class GroupRemovalTests extends TestBase {

@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i= 0; i < 3; i++) {
			GroupData group = new GroupData()
				.withName(generateRandomString())
				.withHeader(generateRandomString())
				.withFooter(generateRandomString());
			list.add(new Object[]{group});
		}
		return list.iterator();
	}
	
	@Test (dataProvider = "randomValidGroupGenerator")
	public void deleteSomeGroup(GroupData group) {
			    
	  //save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
	    
	    //at least one group should exist!
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    
	    //actions
		app.getGroupHelper().deleteGroup(index);
			
		//save new state
		SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
	    
	    //compare states
		assertThat(newList, equalTo(oldList.without(index)));
	}
}

