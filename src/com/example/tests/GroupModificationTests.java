package com.example.tests;

import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupModificationTests extends TestBase{

@DataProvider
	public Iterator<Object[]> groupsFromFile() throws IOException {
		return wrapGroupsForDataProvider(loadGroupsFromXmlFile(new File("groups.xml"))).iterator();
	}
	
	
	@Test(dataProvider = "groupsFromFile")
	public void modifySomeGroup(GroupData group) {
		app.navigateTo().mainPage();
	 	    
	  //save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getUiGroups();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    //actions
	    app.getGroupHelper().modifyGroup(index, group);
	    	    		
		//save new state
	    SortedListOf<GroupData> newList = app.getGroupHelper().getUiGroups();
	    
	    //compare states
	    assertThat(newList, equalTo(oldList.without(index).withAdded(group)));
	 }

}
