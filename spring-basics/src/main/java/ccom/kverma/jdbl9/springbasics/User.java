package ccom.kverma.jdbl9.springbasics;

import java.util.Date;

public class User {
    private int id;
    private String name;
    private String email;
    private Date createDate;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createDate = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
