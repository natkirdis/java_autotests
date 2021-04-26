package ru.stqa.pft.addressbook.models;

import java.util.Objects;

public class ContactData {
  private final String id;
  private final String name;
  private final String middlename;
  private final String lastname;
  private final String address;
  private final String phone;
  private final String email;

  public ContactData(String name, String middlename, String lastname, String address, String phone, String email) {
    this.id = null;
    this.name = name;
    this.middlename = middlename;
    this.lastname = lastname;
    this.address = address;
    this.phone = phone;
    this.email = email;
  }

  public ContactData(String id, String name, String middlename, String lastname, String address, String phone, String email) {
    this.id = id;
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

  public String getId() {
    return id;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ContactData)) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(getId(), that.getId()) &&
            Objects.equals(getName(), that.getName()) &&
            Objects.equals(getLastname(), that.getLastname());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName(), getLastname());
  }
}
