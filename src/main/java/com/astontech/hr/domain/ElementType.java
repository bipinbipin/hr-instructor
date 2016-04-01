package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Bipin on 3/25/2016.
 */
@Entity
public class ElementType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ElementTypeId")
    private Integer id;

    @Version
    private Integer version;

    private String elementType;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Element> elementList;

    public ElementType() {}

    public ElementType(String elementType) {
        this.setElementType(elementType);
    }

    public ElementType(String elementType, List<Element> elementList) {
        this.setElementType(elementType);
        this.setElementList(elementList);
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

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public List<Element> getElementList() {
        return elementList;
    }

    public void setElementList(List<Element> elementList) {
        this.elementList = elementList;
    }
}
