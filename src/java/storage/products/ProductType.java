/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.products;

import storage.*;
import java.util.*;
import storage.users.UserRole;
/**
 *
 * @author zbs
 */
public class ProductType {
    
    private String name;
    private String description;
    private String SerialNum;
    private String producttype;
    private float weight;
    private String size;
    private int quantity;
    private float price;
    private Boolean availability;
    private String nameOfUnit;
    private String supplierName;
    private String supplierSurname;
    //private List<StorageUnit> storageList;
    //private List<Supplier> suppliers;

        public ProductType(String Name, String description, String SerialNum, String Producttype, String Size, int Quantity, float Price, float Weight, Boolean Availability,String NameOfUnit,String SupplierName,String SupplierSurname) {

        this.name = Name;
        this.description = description;
        this.SerialNum = SerialNum;
        this.producttype = Producttype;
        this.size = Size;
        this.quantity = Quantity;
        this.price = Price;
        this.weight = Weight;
        this.availability = Availability;
        this.nameOfUnit= NameOfUnit;
        this.supplierName = SupplierName;
        this.supplierSurname = SupplierSurname;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the id to set
     */
    public void setName(String name) {
        this.name = name;
    }

        /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param name the id to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

        /**
     * @return the serial_number
     */
    public String getSerialNum() {
        return SerialNum;
    }

    /**
     * @param serial_number the id to set
     */
    public void setSerialNum(String SerialNum) {
        this.SerialNum = SerialNum;
    }

        /**
     * @return the type of the product
     */
    public String getProductType() 
    {
        return producttype;
    }

    /**
     * @param product_type the id to set
     */
    public void setProductType(String producttype) {
        this.producttype = producttype;
    }

    /**
     * @return the weight
     */
    public float getWeight() {
        return weight;
    }

    /**
     * @param weight the quantity to set
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    /**
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size to set
     */
    public void setSize(String size) {
        this.size = size;
    }    
    
    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the availability
     */
    public Boolean getAvailability() {
        return availability;
    }

    /**
     * @param availability the availability to set
     */
    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }
    
        
    /**
     * @return the nameOfUnit
     */
    public String getNameOfUnit() {
        return nameOfUnit;
    }

    /**
     * @param NameOfUnit that contains Product
     */
    public void setNameOfUnit(String NameOfUnit) {
        this.nameOfUnit = NameOfUnit;
    }
    
    /**
     * @return the name of the supplier of the product
     */
    public String getSupplierName() 
    {
        return supplierName;
    }

    /**
     * @param name of supplier to set
     */
    public void setSupplierName(String SupplierName) {
        this.supplierName = SupplierName;
    }

    
    /**
     * @return the surname of the supplier of the product
     */
    public String getSupplierSurname() 
    {
        return supplierSurname;
    }

    /**
     * @param the suppliers surname to set
     */
    public void setSupplierSurname(String SupplierSurname) {
        this.supplierSurname = SupplierSurname;
    }
    /**
     * @return the storageList
     */
    
    //public List<StorageUnit> getStorageList() {
      //  return storageList;
    //}

    /**
     * @param storageList the storageList to set
     */
    //public void setStorageList(List<StorageUnit> storageList) {
      //  this.storageList = storageList;
    //}

    /**
     * @return the suppliers
     */
    //public List<Supplier> getSuppliers() {
     //   return suppliers;
   // }

    /**
     * @param suppliers the suppliers to set
     */
    //public void setSuppliers(List<Supplier> suppliers) {
      //  this.suppliers = suppliers;
    //}
}