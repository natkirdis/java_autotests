package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;
import ru.stqa.pft.addressbook.models.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    app.goTo().contactCreationPage();
    ContactData contact = new ContactData().withFirstname("Name1")
            .withMiddlename("MiddleName1").withLastname("LastName1")
            .withAddress("Address1").withHomePhone("8999007766")
            .withMobilePhone("434343434").withWorkPhone("909090222222")
            .withEmail("test@test.ru");
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after,
            equalTo(before.withAdded(contact.withId(after.stream().mapToInt(ContactData::getId).max().getAsInt()))));
  }
}