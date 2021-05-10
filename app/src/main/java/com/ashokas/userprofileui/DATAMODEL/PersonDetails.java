package com.ashokas.userprofileui.DATAMODEL;

public class PersonDetails {
    String id,name,email,college;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public PersonDetails(String id, String name, String email, String college) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.college = college;
    }
}
