package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.fw.GroupHelper;
import com.example.utils.SortedListOf;

public class GroupCreation1 extends TestBase {
	
	@Test(dataProvider = "randomValidGroupGenerator")
  public void testGroupCreationWithValidData(GroupData group) throws Exception {
			    
	    //save old state
	   GroupHelper groupHelper = app.getGroupHelper();
	   SortedListOf<GroupData> oldList = groupHelper.getGroups();
	    
	    //actions
		app.getGroupHelper().createGroup(group);
			    
	    //save new state
		SortedListOf<GroupData> newList = groupHelper.getGroups();
	    
	    //compare states
	   assertThat(newList, equalTo(oldList.withAdded(group)));
	 }
 }
