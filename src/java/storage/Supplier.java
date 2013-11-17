/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import storage.products.*;
import java.util.*;

/**
 *
 * @author zbs
 */
public class Supplier {

   
    private String name;
    private String surname;
    private String address;
    private String SSN;

    public Supplier(String Name, String Surname, String Address, String SSN) {

        this.name = Name;
        this.surname = Surname;
        this.address = Address;
        this.SSN = SSN;

    }


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

        /**
     * @return the name
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param name the name to set
     */
    public void setSurname(String Surname) {
        this.surname = Surname;
    }

    /**
     * @return supplier's Address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address of the supplier to set
     */
    public void setAddress(String Address) {
        this.address = Address;
    }

    /**
     * @return the Social Security Number
     */
    public String getSSN() {
        return SSN;
    }

    /**
     * @param SSN the social security Number to set
     */
    public void setPrice(String SSN) {
        this.SSN = SSN;
    }
}
