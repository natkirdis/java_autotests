package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().list().size() == 0) {
      app.goTo().contactCreationPage();
      app.contact().create(new ContactData().withName("Name1")
              .withMiddlename("MiddleName1").withLastname("LastName1")
              .withAddress("Address1").withPhone("8999007766")
              .withEmail("test@test.ru"));
    }
  }

  @Test
  public void testContactModification() {
    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId())
            .withName("Name1 edited").withMiddlename("MiddleName1 edited")
            .withLastname("LastName1 edited").withAddress("Address1 edited")
            .withPhone("8999007777").withEmail("test_edited@test.ru");

    app.contact().modify(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(after, before);
  }
}