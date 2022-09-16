/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.ticket_reporting_app.domain;

import java.math.BigDecimal;


public class OrderTickets {
    private Ticket ticket;
    private BigDecimal itemPrice;
    private BigDecimal discount;
    private BigDecimal surcharge;
    private Order order;
    private int quantity;

    public OrderTickets(Ticket ticket, BigDecimal itemPrice, BigDecimal discount, BigDecimal surcharge, Order order,int quantity) {
        this.ticket = ticket;
        this.itemPrice = itemPrice;
        this.discount = discount;
        this.surcharge = surcharge;
        this.order = order;
        this.quantity = quantity;
    }

    public OrderTickets() {
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

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(BigDecimal surcharge) {
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
