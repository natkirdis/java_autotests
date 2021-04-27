package ru.stqa.pft.addressbook.models;

import java.util.Objects;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String firstname;
  private String middleName;
  private String lastname;
  private String address;
  private String homePhone;
  private String mobilePhone;
  private String workPhone;
  private String email;

  public String getFirstname() {
    return firstname;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAddress() {
    return address;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getEmail() {
    return email;
  }

  public int getId() {
    return id;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstname(String name) {
    this.firstname = name;
    return this;
  }

  public ContactData withMiddlename(String middlename) {
    this.middleName = middlename;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withHomePhone(String phone) {
    this.homePhone = phone;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", name='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ContactData)) return false;
    ContactData that = (ContactData) o;
    return getId() == that.getId() &&
            Objects.equals(getFirstname(), that.getFirstname()) &&
            Objects.equals(getLastname(), that.getLastname());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getFirstname(), getLastname());
  }
}