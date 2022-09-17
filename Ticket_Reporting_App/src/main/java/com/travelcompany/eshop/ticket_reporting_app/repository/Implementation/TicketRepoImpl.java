/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.ticket_reporting_app.repository.Implementation;

import com.travelcompany.eshop.ticket_reporting_app.domain.Itinary;
import com.travelcompany.eshop.ticket_reporting_app.domain.Ticket;
import com.travelcompany.eshop.ticket_reporting_app.repository.TicketRepository;
import com.travelcompany.eshop.ticket_reporting_app.utility.GeneralUtility;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kostas Chatzifotiadis
 */
public class TicketRepoImpl implements TicketRepository {
   private final List<Ticket> tickets; 
   
   
   public TicketRepoImpl() {
    tickets=new ArrayList<>();
    }
   
@Override
    public boolean addTicket(Ticket ticket) {
        
        tickets.add(ticket);
        return true;
        
    }

    @Override
    public List<Ticket> readTicket() {
       return tickets;
    }

    @Override
    public Ticket readTicket(long ticketId) {
        for (int index = 0; index < tickets.size(); index ++){
            if (tickets.get(index).getId() == ticketId)
                return tickets.get(index);
        }
        return null;
    }    
    @Override
    public boolean updateTicket(long ticketId,long price) {
        Ticket ticket = readTicket(ticketId);
        if( ticket == null) return false;
        
       
        
        
        ticket.setPrice(price);
        return true;
    }
    @Override
    public boolean deleteTicket(long ticketId) {
        Ticket ticket = readTicket(ticketId);
        if( ticket == null) return false;
        tickets.remove(ticket);
        return true;
    }
    
}
