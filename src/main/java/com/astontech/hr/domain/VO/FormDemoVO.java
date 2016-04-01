package com.astontech.hr.domain.VO;

import org.apache.log4j.Logger;

import javax.persistence.*;

/**
 * Created by Bipin on 3/29/2016.
 */
@Entity
public class FormDemoVO {

    @Transient
    Logger log = Logger.getLogger(FormDemoVO.class);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @Version
    private Integer version;

    private String email;
    private String password;

    @Transient
    private String[] checkboxes;

    private String checkboxVal;

    private String textarea;
    private String radios;

    private String selectSingle;
    private String selectMultiple;

    public FormDemoVO() {}


    public void convertCheckBoxArrayToValues() {
        try {
            checkboxVal = "";
            for (String str : getCheckboxes()) {
                checkboxVal = checkboxVal.concat(str);
                checkboxVal = checkboxVal.concat(",");
            }
            checkboxVal.substring(0, checkboxVal.length()-1);
        } catch (Exception ex) {
            log.info(ex);
        }
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getCheckboxes() {
        return checkboxes;
    }

    public void setCheckboxes(String[] checkboxes) {
        this.checkboxes = checkboxes;
    }

    public String getTextarea() {
        return textarea;
    }

    public void setTextarea(String textarea) {
        this.textarea = textarea;
    }

    public String getRadios() {
        return radios;
    }

    public void setRadios(String radios) {
        this.radios = radios;
    }

    public String getSelectSingle() {
        return selectSingle;
    }

    public void setSelectSingle(String selectSingle) {
        this.selectSingle = selectSingle;
    }

    public String getSelectMultiple() {
        return selectMultiple;
    }

    public void setSelectMultiple(String selectMultiple) {
        this.selectMultiple = selectMultiple;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCheckboxVal() {
        return checkboxVal;
    }

    public void setCheckboxVal(String checkboxVal) {
        this.checkboxVal = checkboxVal;
    }


}
