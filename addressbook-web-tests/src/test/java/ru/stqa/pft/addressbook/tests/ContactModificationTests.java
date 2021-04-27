package ru.stqa.pft.addressbook.tests;

import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;
import ru.stqa.pft.addressbook.models.Contacts;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

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
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId())
            .withName("Name1 edited").withMiddlename("MiddleName1 edited")
            .withLastname("LastName1 edited").withAddress("Address1 edited")
            .withPhone("8999007777").withEmail("test_edited@test.ru");

    app.contact().modify(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size()));

    before.remove(modifiedContact);
    before.add(contact);
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }
}