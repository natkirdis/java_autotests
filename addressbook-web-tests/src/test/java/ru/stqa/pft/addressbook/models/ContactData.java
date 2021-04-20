package ru.stqa.pft.addressbook.models;

public class ContactData {
  private final String name;
  private final String middlename;
  private final String lastname;
  private final String address;
  private final String phone;
  private final String email;

  public ContactData(String name, String middlename, String lastname, String address, String phone, String email) {
    this.name = name;
    this.middlename = middlename;
    this.lastname = lastname;
    this.address = address;
    this.phone = phone;
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAddress() {
    return address;
  }

  public String getPhone() {
    return phone;
  }

  public String getEmail() {
    return email;
  }
}
