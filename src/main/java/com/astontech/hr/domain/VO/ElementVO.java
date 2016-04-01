package com.astontech.hr.domain.VO;

/**
 * Created by Bipin on 3/30/2016.
 */
public class ElementVO {

    private String newElementType;
    private String newElements;
    private String[] newElement;


    public ElementVO() {}


    public String getNewElementType() {
        return newElementType;
    }

    public void setNewElementType(String newElementType) {
        this.newElementType = newElementType;
    }

    public String getNewElements() {
        return newElements;
    }

    public void setNewElements(String newElements) {
        this.newElements = newElements;
    }

    public String[] getNewElement() {
        return newElement;
    }

    public void setNewElement(String[] newElement) {
        this.newElement = newElement;
    }


    public void splitNewElements() {
        setNewElement(this.newElements.split("\\r?\\n"));
    }


}
