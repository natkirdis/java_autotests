package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhonesTests extends TestBase {
  @Test
  public void testContactPhones() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getHomePhone(),
            equalTo(cleaned(contactInfoFromEditForm.getHomePhone())));
    assertThat(contact.getWorkPhone(),
            equalTo(cleaned(contactInfoFromEditForm.getWorkPhone())));
    assertThat(contact.getMobilePhone(),
            equalTo(cleaned(contactInfoFromEditForm.getMobilePhone())));
  }

  public String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
