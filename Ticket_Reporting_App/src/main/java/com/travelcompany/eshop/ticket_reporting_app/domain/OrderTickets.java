/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.ticket_reporting_app.domain;

import java.math.BigDecimal;


public class OrderTickets {
    private Ticket ticket;
    private double itemPrice;
    private double discount;   
    private Order order;
    private int quantity;
    private String paymentMethod;
    

    public OrderTickets( Ticket ticket, double itemPrice, double discount, Order order, int quantity, String paymentMethod) {
        this.ticket = ticket;
        this.itemPrice = itemPrice;
        this.discount = discount;
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

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderTickets{" + "ticket=" + ticket + ", itemPrice=" + itemPrice + ", discount=" + discount + ", order=" + order + '}';
    }
    
    
    
    
    
}
