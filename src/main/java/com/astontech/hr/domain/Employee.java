package com.astontech.hr.domain;

import javax.persistence.*;

/**
 * Created by Bipin on 3/25/2016.
 */
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EmployeeId")
    private Integer id;

    @Version
    private Integer version;

    @OneToOne
    @JoinColumn(name = "PersonId")
    private Person person;


    private String background;



    public Employee() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
