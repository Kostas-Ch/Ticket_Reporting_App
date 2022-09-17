/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.ticket_reporting_app.domain;

import com.travelcompany.eshop.ticket_reporting_app.exception.ItinaryException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;


public class Itinary {
    private long id;
    private String departureAirportCode;
    private String destinationAirportCode;
    private String departureDate;
    private String airline;
    private long basicPrice;

    public Itinary(long id, String departureAirportCode, String destinationAirportCode, String departureDate, String airline, long basicPrice) throws ItinaryException {
        this.id = id;
        this.departureAirportCode = departureAirportCode;
        this.destinationAirportCode = destinationAirportCode;
        this.departureDate = departureDate;
        this.airline = airline;
        this.basicPrice = basicPrice;
    }

    public Itinary() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public void setDestinationAirportCode(String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public long getBasicPrice() {
        return basicPrice;
    }

    public void setBasicPrice(long basicPrice) {
        this.basicPrice = basicPrice;
    }

    @Override
    public String toString() {
        return "Itinary {" + "id = " + id + ", departureAirportCode = " + departureAirportCode + ", destinationAirportCode = " + destinationAirportCode + ", departureDate = " + departureDate + ", airline = " + airline + ", basicPrice = " + basicPrice + '}'+' ';
    }
    
    
    
    
    
    
}
