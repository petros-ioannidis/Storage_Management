/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.users;

/**
 *
 * @author zbs
 */
public class UserRole {

    private String name;
    private Boolean storage_read;
    private Boolean storage_write;
    private Boolean product_read;
    private Boolean product_write;
    private Boolean supplier_read;
    private Boolean supplier_write;

    public UserRole(String name, Boolean st_r, Boolean st_w, Boolean pr_r, Boolean pr_w, Boolean su_r, Boolean su_w) {
        
        this.name = name;
        this.storage_read = st_r;
        this.storage_write = st_w;
        this.product_read = pr_r;
        this.product_write = pr_w;
        this.supplier_read = su_r;
        this.supplier_write = su_w;
        
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
     * @return the storage_read
     */
    public Boolean getStorage_read() {
        return storage_read;
    }

    /**
     * @param storage_read the storage_read to set
     */
    public void setStorage_read(Boolean storage_read) {
        this.storage_read = storage_read;
    }

    /**
     * @return the storage_write
     */
    public Boolean getStorage_write() {
        return storage_write;
    }

    /**
     * @param storage_write the storage_write to set
     */
    public void setStorage_write(Boolean storage_write) {
        this.storage_write = storage_write;
    }

    /**
     * @return the product_read
     */
    public Boolean getProduct_read() {
        return product_read;
    }

    /**
     * @param product_read the product_read to set
     */
    public void setProduct_read(Boolean product_read) {
        this.product_read = product_read;
    }

    /**
     * @return the product_write
     */
    public Boolean getProduct_write() {
        return product_write;
    }

    /**
     * @param product_write the product_write to set
     */
    public void setProduct_write(Boolean product_write) {
        this.product_write = product_write;
    }

    /**
     * @return the supplier_read
     */
    public Boolean getSupplier_read() {
        return supplier_read;
    }

    /**
     * @param supplier_read the supplier_read to set
     */
    public void setSupplier_read(Boolean supplier_read) {
        this.supplier_read = supplier_read;
    }

    /**
     * @return the supplier_write
     */
    public Boolean getSupplier_write() {
        return supplier_write;
    }

    /**
     * @param supplier_write the supplier_write to set
     */
    public void setSupplier_write(Boolean supplier_write) {
        this.supplier_write = supplier_write;
    }


}
