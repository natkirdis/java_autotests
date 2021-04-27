package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.models.ContactData;
import ru.stqa.pft.addressbook.models.Contacts;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  private void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("middlename"),contactData.getMiddleName());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("email"), contactData.getEmail());
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
    accept();
  }

  private void initContactModificationById(int id) {
    wd.findElement(By.xpath("//input[@id = '" + id + "']/ancestor::tr//img[@title='Edit']")).click();
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void create(ContactData contact) {
    fillContactForm(contact);
    submitContactCreation();
    contactCache = null;
    returnToHomePage();
  }

  public void modify(ContactData contact) {
    initContactModificationById(contact.getId());
    fillContactForm(contact);
    submitContactModification();
    contactCache = null;
    returnToHomePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    contactCache = null;
  }

  public List<ContactData> list() {
    List <ContactData> contacts = new ArrayList<>();
    List <WebElement> elements = wd.findElements(By.cssSelector("tr[name='entry']"));
    for (WebElement element: elements) {
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String firstname = element.findElement(By.xpath("td[3]")).getText();
      String lastname = element.findElement(By.xpath("td[2]")).getText();
      ContactData contact = new ContactData().withId(id).withFirstname(firstname).withLastname(lastname);
      contacts.add(contact);
    }
    return contacts;
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List <WebElement> rows = wd.findElements(By.cssSelector("tr[name='entry']"));
    for (WebElement row: rows) {
      int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
      String firstname = row.findElement(By.xpath("td[3]")).getText();
      String lastname = row.findElement(By.xpath("td[2]")).getText();
      String allPhones = row.findElement(By.xpath("td[6]")).getText();
      ContactData contact = new ContactData().withId(id).withFirstname(firstname)
              .withLastname(lastname).withAllPhones(allPhones);
      contactCache.add(contact);
    }
    return contactCache;
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public ContactData infoFromEditForm(ContactData contact) {
     initContactModificationById(contact.getId());
     String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
     String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
     String homePhone = wd.findElement(By.name("home")).getAttribute("value");
     String mobilePhone = wd.findElement(By.name("mobile")).getAttribute("value");
     String workPhone = wd.findElement(By.name("work")).getAttribute("value");
     wd.navigate().back();
     return new ContactData().withFirstname(firstname).withLastname(lastName)
             .withHomePhone(homePhone).withWorkPhone(workPhone).withMobilePhone(mobilePhone);
  }
}