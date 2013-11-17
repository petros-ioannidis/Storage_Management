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
public class StorageUnit {
    
    private String name;
    private String description;
    private String location;
    private Boolean open;
   
   public StorageUnit(String Name, String Description, String Location, Boolean Open) {

        this.name = Name;
        this.description = Description;
        this.location = Location;
        this.open = Open;
    }
    
    /**
     * @return the name of the storage unit
     */
    public String getName() {
        return name;
    }

    /**
     * @param Name the name to set the unit
      */
    public void setName(String Name) {
        this.name = Name;
    }
    /**
     * @return the description of the storage unit
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param Description  to describe the unit
      */
    public void setDescription(String Description) {
        this.description = Description;
    }
    
    /**
     * @return the location of the storage unit
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param Location  to set the location of the unit
      */
    public void setLocation(String Location) {
        this.location = Location;
    }
    
    /**
     * @return true if the unit is Open
     */    
    public Boolean getOpen() {
        return open;
    }

    /**
     * @param open  to set the unit type
      */
    public void setOpen(Boolean Open) {
        this.open = Open;
    }
    
}
