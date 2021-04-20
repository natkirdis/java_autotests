package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    gotoContactCreationPage();
    fillContactForm(new ContactData("Name1", "MiddleName1", "LastName1", "Address1", "8999007766", "test@test.ru"));
    submitContactCreation();
    returnToHomePage();
    logout();
  }

}
