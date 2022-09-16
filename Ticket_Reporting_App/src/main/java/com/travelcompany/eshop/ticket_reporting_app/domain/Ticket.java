/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.ticket_reporting_app.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author Kostas Chatzifotiadis
 */
public class Ticket {
    private long id;
    private BigDecimal price;
    private Customer customer;
    private Category category;

    public Ticket(long id, BigDecimal price, Customer customer, Category category) {
        this.id = id;
        this.price = price;
        this.customer = customer;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Ticket{" + "id=" + id + ", price=" + price + ", customer=" + customer + ", category=" + category + '}';
    }
    
    

    
    
    
    
    
    
}
