//package com.astontech.hr.domain.authentication;
//
//import javax.persistence.*;
//import java.util.List;
//
///**
// * Created by Bipin on 5/25/2016.
// */
//@Entity
//public class authorities {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "authoritiesId")
//    private Integer id;
//
//    @Version
//    private Integer version;
//
//    @ManyToOne
//    @JoinColumn(name = "username")
//    private users user;
//
//    private String authority;
//
//    public authorities() {}
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
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
//    public users getUser() {
//        return user;
//    }
//
//    public void setUser(users user) {
//        this.user = user;
//    }
//
//    public String getAuthority() {
//        return authority;
//    }
//
//    public void setAuthority(String authority) {
//        this.authority = authority;
//    }
//}
