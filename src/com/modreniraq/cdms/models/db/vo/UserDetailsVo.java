package com.modreniraq.cdms.models.db.vo;

import com.modreniraq.cdms.models.db.type.UsersType;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
//import javafx.beans.property.;

public class UserDetailsVo {

    private IntegerProperty id;
    private UsersVo usersVo;
    private StringProperty firstName;
    private StringProperty fatherName;
    private StringProperty mobile;
   // private byte[] image;
    private StringProperty specialization;

    public UserDetailsVo() {
        this.id=new SimpleIntegerProperty();
        this.firstName=new SimpleStringProperty();
        this.fatherName=new SimpleStringProperty();
        this.mobile=new SimpleStringProperty();
        this.specialization=new SimpleStringProperty();
    }
    public static UsersType getUsersTypeById(int id) {
        for (UsersType userstype : UsersType.values()) {
            if (userstype.getId() == id) {
                return userstype;
            }
        }
        return null;
    }
     public static UsersType getUserstypeByType(String type) {
        for (UsersType userstype : UsersType.values()) {
            if (userstype.getType() == type) {

                return userstype;
            }
        }
        return null;
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

    public UsersVo getUsersVo() {
        return usersVo;
    }

    public void setUsersVo(UsersVo usersVo) {
        this.usersVo = usersVo;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }
    public StringProperty FirstNameProperty() {
        return firstName;
    }

    public String getFatherName() {
        return fatherName.get();
    }

    public void setFatherName(String fatherName) {
        this.fatherName.set(fatherName);
    }
    public StringProperty FatherNameProperty() {
        return fatherName;
    }

    public String getMobile() {
        return mobile.get();
    }

    public void setMobile(String mobile) {
        this.mobile.set(mobile);
    }
    public StringProperty MobileProperty() {
        return mobile;
    }

//    public byte[] getImage() {
//        return image;
//    }
//
//    public void setImage(byte[] image) {
//        this.image = image;
//    }

    public String getSpecialization() {
        return specialization.get();
    }

    public void setSpecialization(String specialization) {
        this.specialization.set(specialization);
    }
    public StringProperty SpecializationProperty() {
        return specialization;
    }
   

}
