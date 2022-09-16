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
    
}
