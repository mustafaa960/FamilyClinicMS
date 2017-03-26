package com.modreniraq.cdms.models.db.type;

public enum UsersType {
    ADMIN(1, "admin"), DOCTOR(2, "doctor"), NURSE(3, "nurse"),RECEPTION(4,"reception");

    private int id;
    private String type;

//    private UsersType() {
//        this.id=new SimpleIntegerProperty();
//        this.type=new SimpleStringProperty();
//    }
    

    private UsersType(int id, String type) {
        this.id=id;
        this.type=type;

    }

    public static UsersType getUsersTypeById(int id) {
        for (UsersType userstype : UsersType.values()) {
            if (userstype.getId()==id) {
                return userstype;
            }
        }
        return null;
    }

    public static UsersType getUserstypeByType(String type) {
        for (UsersType userstype : UsersType.values()) {
            if (userstype.getType().equals(type)) {

                return userstype;
            }
        }
        return null;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id=id;
    }
//     public IntegerProperty IdProperty() {
//        return this.id;
//    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type=type;
    }
//     public StringProperty TypeProperty() {
//        return this.type;
//    }
}
