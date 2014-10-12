package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreation1 extends TestBase {
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	  openMainPage();
	    gotoGroupsPage();
	    initGroupCreation();
	    GroupData group = new GroupData();
	    group.name="Final goup";
	    group.header="header 1";
	    group.footer="footer 1";
		fillGroupForm(group);
	    submitGroupCreation();
	    returnToGroupsPage();
  }
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
	  openMainPage();
	    gotoGroupsPage();
	    initGroupCreation();
	    fillGroupForm(new GroupData("", "", ""));
	    submitGroupCreation();
	    returnToGroupsPage();
  }
}
