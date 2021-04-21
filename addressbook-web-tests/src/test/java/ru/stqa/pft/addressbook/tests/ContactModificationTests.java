package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;
import ru.stqa.pft.addressbook.models.GroupData;

public class ContactModificationTests extends TestBase {
  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().gotoContactCreationPage();
      app.getContactHelper().createContact(new ContactData("Name1",
              "MiddleName1","LastName1","Address1",
              "8999007766","test@test.ru"));
    }
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Name1 edited",
            "MiddleName1 edited","LastName1 edited",
            "Address1 edited","8999007777","test_edited@test.ru"));
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();

  }

}
