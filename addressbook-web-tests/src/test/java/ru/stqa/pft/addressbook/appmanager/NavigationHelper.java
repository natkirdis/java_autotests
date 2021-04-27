package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {
  private WebDriver wd;

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void groupPage() {
    if (isElementPresent(By.tagName("h1"))
            && getElementText(By.tagName("h1")).equals("Groups")
            && isElementPresent(By.name("new"))) {
      return;
    }
    click(By.linkText("groups"));
  }

  public void homePage() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }

  public void contactCreationPage() {
    if (isElementPresent(By.tagName("h1"))
            && getElementText(By.tagName("h1")).equals("Edit / add address book entry")
            && isElementPresent(By.xpath("//input[@value='Enter']"))) {
      return;
    }
    click(By.linkText("add new"));
  }
}