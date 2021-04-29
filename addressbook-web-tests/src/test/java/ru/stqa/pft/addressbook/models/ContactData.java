package ru.stqa.pft.addressbook.models;

import java.util.Objects;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String firstname;
  private String middleName;
  private String lastname;
  private String address;
  private String allPhones;
  private String workPhone;
  private String mobilePhone;
  private String homePhone;
  private String email;
  private String email2;
  private String email3;
  private String allEmails;

  public ContactData() {
  }

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

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public int getId() {
    return id;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public ContactData withWorkPhone(String workPhones) {
    this.workPhone = workPhones;
    return this;
  }

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
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

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
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