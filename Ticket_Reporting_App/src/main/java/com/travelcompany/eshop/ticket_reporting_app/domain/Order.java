/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.ticket_reporting_app.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kostas Chatzifotiadis
 */
public class Order {
    private long id;  
    private Customer customer;
    private LocalDateTime date;
    private List<OrderTickets> orderTickets= new ArrayList<>();

    public Order(long id, Customer customer, LocalDateTime date) {
        this.id = id;
        this.customer = customer;
        this.date = date;
    }

    public Order() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<OrderTickets> getOrderTickets() {
        return orderTickets;
    }

    public void setOrderTickets(List<OrderTickets> orderTickets) {
        this.orderTickets = orderTickets;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", customer=" + customer + ", date=" + date + ", orderTickets=" + orderTickets + '}';
    }
    
    
}
