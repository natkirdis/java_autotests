package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.models.ContactData;

public class ContactHelper extends HelperBase {
  private WebDriver wd;

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
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

  public void initContactModification() {
    click(By.xpath("//img[@title='Edit']"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }
}