
package com.travelcompany.eshop.ticket_reporting_app.domain;

import com.travelcompany.eshop.ticket_reporting_app.exception.CustomerException;
import com.travelcompany.eshop.ticket_reporting_app.utility.GeneralUtility;
import java.math.BigDecimal;


public class Customer {
    private long id;
    private String Name;
    private String nationality;
    private String email;
    private String address;
    private String category;
    

    public Customer(long id, String Name, String email, String address, String nationality, String category) throws CustomerException {
        
        this.id = id;
        this.Name = Name;
        this.nationality = nationality;
        this.email = email;
        this.address = address;
        this.category = category;
        
    }
    
    public Customer() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }


    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", Name=" + Name + ", email=" + email + ", address=" + address + ", nationality=" + nationality + ", category=" + category + '}';
    }
    
    
}
