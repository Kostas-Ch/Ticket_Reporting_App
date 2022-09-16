/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.ticket_reporting_app.repository;

import com.travelcompany.eshop.ticket_reporting_app.domain.Customer;
import com.travelcompany.eshop.ticket_reporting_app.domain.Ticket;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Kostas Chatzifotiadis
 */
public interface TicketRepository {
    boolean addTicket(Ticket ticket);
    List<Ticket> readTicket();
    Ticket readTicket(long ticketId);
    boolean updateTicket(long ticketId,BigDecimal price);
    boolean deleteTicket(long ticketId);
}
