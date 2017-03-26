package com.modreniraq.cdms.models.db.vo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PatientVo {

    private IntegerProperty id;
    private StringProperty name;
    private StringProperty age;
    private StringProperty age_type;
    private StringProperty address;
    private StringProperty blood_group;
    private StringProperty city;
    private StringProperty gender;
    private StringProperty reg_date;
    private StringProperty phone;
    private StringProperty jop;
    private StringProperty email;
    private StringProperty Reference;

    public PatientVo() {
        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.age = new SimpleStringProperty();
        this.age_type = new SimpleStringProperty();
        this.city = new SimpleStringProperty();
        this.gender = new SimpleStringProperty();
        this.phone = new SimpleStringProperty();
        this.Reference = new SimpleStringProperty();
        this.address = new SimpleStringProperty();
        this.blood_group=new SimpleStringProperty();
        this.reg_date=new SimpleStringProperty();
        this.jop=new SimpleStringProperty();
        this.email=new SimpleStringProperty();
    }

    
     
    
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty IdProperty() {
        return id;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty NameProperty() {
        return name;
    }

    public String getAge() {
        return age.get();
    }

    public void setAge(String age) {
        this.age.set(age);
    }

   public StringProperty AgeProperty() {
        return age;
    }

    public String getAgeType() {
        return age_type.get();
    }

    public void setAgeType(String age_type) {
        this.age_type.set(age_type);
    }
    public StringProperty AgeTypeProperty() {
        return age_type;
    }
     public String getCity() {
        return city.get();
    }

    public void setCity(String city) {
        this.city.set(city);
    } 
    public StringProperty CityProperty() {
        return city;
    }

    public String getGender() {
        return gender.get();
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }
    public StringProperty GenderProperty() {
        return gender;
    }
    public String getPhone() {
        return phone.get();
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }
    public StringProperty PhoneProperty() {
        return phone;
    }

    public String getReference() {
        return Reference.get();
    }

    public void setReference(String Reference) {
        this.Reference.set(Reference);
    }
    public StringProperty ReferenceProperty() {
        return Reference;
    }
    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }
    public StringProperty AddressProperty() {
        return address;
    }

    public String getBloodGroup() {
        return blood_group.get();
    }

    public void setBloodGroup(String blood_group) {
        this.blood_group.set(blood_group);
    }
    public StringProperty BloodGroupProperty() {
        return blood_group;
    }

    public String getRegDate() {
        return reg_date.get();
    }

    public void setRegDate(String reg_date) {
        this.reg_date.set(reg_date);
    }
    public StringProperty RegDateProperty() {
        return reg_date;
    }
    public String getJop() {
        return jop.get();
    }

    public void setJop(String jop) {
        this.jop.set(jop);
    }
    public StringProperty JopProperty() {
        return jop;
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }
    public StringProperty EmailProperty() {
        return email;
    }
    
}
