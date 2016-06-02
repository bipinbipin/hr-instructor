//package com.astontech.hr.domain.authentication;
//
//import javax.persistence.*;
//
///**
// * Created by Bipin on 5/25/2016.
// */
//@Entity
//public class users {
//
//    @Id
//    //@GeneratedValue(strategy = GenerationType.AUTO)
//    //@Column(name = "usersId")
//    private String username;
//
//    @Version
//    private Integer version;
//
//    private String password;
//    private boolean enabled;
//
//    public users() {}
//    public users(String username, String password) {
//        this.username = username;
//        this.password = password;
//        this.enabled = true;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public Integer getVersion() {
//        return version;
//    }
//
//    public void setVersion(Integer version) {
//        this.version = version;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public boolean isEnabled() {
//        return enabled;
//    }
//
//    public void setEnabled(boolean enabled) {
//        this.enabled = enabled;
//    }
//}
