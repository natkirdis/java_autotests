package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.gotoHomePage();
    app.selectContact();
    app.deleteSelectedContact();
    app.gotoHomePage();
  }

}




