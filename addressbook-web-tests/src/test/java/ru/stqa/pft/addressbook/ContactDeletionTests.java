package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactCreation() {
    gotoHomePage();
    selectContact();
    deleteSelectedContact();
    gotoHomePage();
  }

}




