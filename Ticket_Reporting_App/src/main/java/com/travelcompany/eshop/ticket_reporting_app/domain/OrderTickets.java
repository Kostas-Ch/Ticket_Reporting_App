/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.ticket_reporting_app.domain;

import java.math.BigDecimal;


public class OrderTickets {
    private Ticket ticket;
    private long itemPrice;
    private double discount;
    private double surcharge;
    private Order order;
    private int quantity;
    private String paymentMethod;
    

    public OrderTickets(Ticket ticket, long itemPrice, double discount, double surcharge, Order order,int quantity, String paymentMethod) {
        this.ticket = ticket;
        this.itemPrice = itemPrice;
        this.discount = discount;
        this.surcharge = surcharge;
        this.order = order;
        this.quantity = quantity;
        this.paymentMethod = paymentMethod;
    }

    public OrderTickets() {
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public long getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(long itemPrice) {
        this.itemPrice = itemPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(double surcharge) {
        this.surcharge = surcharge;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderTickets{" + "ticket=" + ticket + ", itemPrice=" + itemPrice + ", discount=" + discount + ", surcharge=" + surcharge + ", order=" + order + '}';
    }
    
    
    
    
    
}
