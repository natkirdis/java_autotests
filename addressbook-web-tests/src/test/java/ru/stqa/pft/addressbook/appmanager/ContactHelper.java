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

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  private void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getName());
    type(By.name("middlename"),contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getPhone());
    type(By.name("email"), contactData.getEmail());
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
    accept();
  }

  public void initContactModification(int index) {
    wd.findElements(By.xpath("//img[@title='Edit']")).get(index).click();
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
    List <ContactData> contacts = new ArrayList<ContactData>();
    List <WebElement> elements = wd.findElements(By.cssSelector("tr[name='entry']"));
    for (WebElement element: elements) {
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String firstname = element.findElement(By.xpath("td[3]")).getText();;
      String lastname = element.findElement(By.xpath("td[2]")).getText();;
      ContactData contact = new ContactData().withId(id).withName(firstname).withLastname(lastname);
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
    List <WebElement> elements = wd.findElements(By.cssSelector("tr[name='entry']"));
    for (WebElement element: elements) {
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String firstname = element.findElement(By.xpath("td[3]")).getText();;
      String lastname = element.findElement(By.xpath("td[2]")).getText();;
      ContactData contact = new ContactData().withId(id).withName(firstname).withLastname(lastname);
      contactCache.add(contact);
    }
    return contactCache;
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }
}