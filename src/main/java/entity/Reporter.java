package entity;

import java.io.Serializable;

public class Reporter implements Serializable {

    private String id;

    private String name;

    private String userName;

    private String passWord;

    public Reporter() {
    }

    public Reporter(String name) {
        this.name = name;
    }

    public Reporter(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public Reporter(String name, String userName, String passWord) {
        this.name = name;
        this.userName = userName;
        this.passWord = passWord;
    }

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "Reporter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
