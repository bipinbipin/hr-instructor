package com.astontech.hr.domain.VO;

import javax.persistence.*;

/**
 * Created by Bipin on 4/6/2016.
 */
@Entity
public class CheckBox {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CheckBoxId")
    private Integer id;

    @Version
    private Integer version;

    private String checkBox;

    public CheckBox() {}

    public CheckBox(String checkBox) {
        this.setCheckBox(checkBox);
    }


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

    public String getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(String checkBox) {
        this.checkBox = checkBox;
    }
}
