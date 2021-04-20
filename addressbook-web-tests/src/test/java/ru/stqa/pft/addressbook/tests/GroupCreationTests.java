package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.models.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("test1", "test1 header", "test1 footer"));
    app.submitGroupCreation();
    app.returnToGroupPage();
  }

}