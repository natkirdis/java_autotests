package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;

public class ContactModificationTests extends TestBase {
  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Name1 edited",
            "MiddleName1 edited",
            null,
            null,
            null,
            null));
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();

  }

}
