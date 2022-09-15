/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.ticket_reporting_app.domain;

import java.math.BigDecimal;

/**
 *
 * @author Kostas Chatzifotiadis
 */
public class Ticket {
    private BigDecimal ticketprice;
    private BigDecimal discount;
    private Customer passengerId;
    private int id;
    private String paymentMethod;
    private BigDecimal paymentAmount;
}
