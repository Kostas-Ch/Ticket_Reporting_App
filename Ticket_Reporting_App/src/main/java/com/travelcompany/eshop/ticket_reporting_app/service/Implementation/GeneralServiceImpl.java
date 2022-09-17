/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.ticket_reporting_app.service.Implementation;

import com.travelcompany.eshop.ticket_reporting_app.domain.Category;
import com.travelcompany.eshop.ticket_reporting_app.domain.Customer;
import com.travelcompany.eshop.ticket_reporting_app.domain.Itinary;
import com.travelcompany.eshop.ticket_reporting_app.domain.Order;
import com.travelcompany.eshop.ticket_reporting_app.domain.OrderTickets;
import com.travelcompany.eshop.ticket_reporting_app.domain.Ticket;
import com.travelcompany.eshop.ticket_reporting_app.exception.CustomerException;
import com.travelcompany.eshop.ticket_reporting_app.exception.ItinaryException;
import com.travelcompany.eshop.ticket_reporting_app.exception.TicketException;
import com.travelcompany.eshop.ticket_reporting_app.repository.CustomerRepository;
import com.travelcompany.eshop.ticket_reporting_app.repository.Implementation.CustomerRepoImpl;
import com.travelcompany.eshop.ticket_reporting_app.repository.Implementation.ItinaryRepoImpl;
import com.travelcompany.eshop.ticket_reporting_app.repository.Implementation.OrderRepoImpl;
import com.travelcompany.eshop.ticket_reporting_app.repository.Implementation.TicketRepoImpl;
import com.travelcompany.eshop.ticket_reporting_app.repository.ItinaryRepository;
import com.travelcompany.eshop.ticket_reporting_app.repository.OrderRepository;
import com.travelcompany.eshop.ticket_reporting_app.repository.TicketRepository;
import com.travelcompany.eshop.ticket_reporting_app.service.GeneralService;
import com.travelcompany.eshop.ticket_reporting_app.utility.GeneralUtility;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kostas Chatzifotiadis
 */
public class GeneralServiceImpl implements GeneralService {
    
    private final CustomerRepository customerRepository;
    private final TicketRepository ticketRepository;
    private final OrderRepository orderRepository;
    private final ItinaryRepository itinaryRepository;
    
    public GeneralServiceImpl(){
        customerRepository = new CustomerRepoImpl();
        ticketRepository = new TicketRepoImpl();
        orderRepository = new OrderRepoImpl();
        itinaryRepository = new ItinaryRepoImpl();
    }
    
    @Override
    public void loadInitialCustomerData(){
        for(String currentCustomer : GeneralUtility.customers) {
            String[] name = currentCustomer.split(",") ;
            try{            
                Customer customer = new Customer(
                        Long.parseLong(name[0]), name[1],name[2], name[3], name[4],name[5]);
                if (GeneralUtility.isValidCustomer(customer))
                    customerRepository.addCustomer(customer);
               }
            catch (CustomerException customerException){
                    System.out.println("Error adding the customer");
            }
        }
    }
    
    @Override
    public void loadInitialTicketData(){
    for(String currentTicket : GeneralUtility.tickets) {
            String[] name1= currentTicket.split(",") ;
              try{          
                Ticket ticket = new Ticket(
                        Long.parseLong(name1[0]), Long.parseLong(name1[1]), Long.parseLong(name1[2]), name1[3], Long.parseLong(name1[4]));
                
                    ticketRepository.addTicket(ticket);
              }
              catch (TicketException ticketException){
                  System.out.println("Error adding the ticket");
              }
            }
              

        }
   @Override
    public void loadInitialItinaryData(){
    for(String currentItinary: GeneralUtility.itinaries) {
            String[] name= currentItinary.split(",") ;
           
            try{
            Itinary itinary = new Itinary(
                    Long.parseLong(name[0]), name[1], name[2],name[3],name[4],Long.parseLong(name[5]));
            if (GeneralUtility.isValidItinary(itinary))
                itinaryRepository.addItinary(itinary);
            }
            catch (ItinaryException itinaryException){
                    System.out.println("Error adding itinary");
                    }
    }
    
    
} 
    
    
   @Override
    public Order createOrder(long orderId, long customerId, long[] ticketIds) {
        Order order = new Order();
        order.setId(orderId);
        
        Customer customer = customerRepository.readCustomer(customerId);
        if (customer == null) return null;
        order.setCustomer(customer);
        order.setDate(LocalDateTime.now());
        
        for (long ticketId: ticketIds){
            OrderTickets orderTicket = new OrderTickets();
            orderTicket.setOrder(order);
            Ticket ticket = ticketRepository.readTicket(ticketId);
            
            orderTicket.setTicket(ticket);
            orderTicket.setItemPrice(ticket.getPrice());
            GeneralUtility.isBuisiness(orderTicket);
            GeneralUtility.isPayedByCreditCard(orderTicket);
            if(GeneralUtility.isBuisiness(orderTicket) && GeneralUtility.isPayedByCreditCard(orderTicket) == true )
                orderTicket.setDiscount(0.2);
            orderTicket.setQuantity(1);

            order.getOrderTickets().add(orderTicket);
        }
        orderRepository.addOrder(order);
        return order;
    
    }
     
      @Override
    public String displayOrder(long orderId) {
        Order order = orderRepository.readOrder(orderId);
        StringBuilder returnString = new StringBuilder();
        returnString.append("Order No. ").append(order.getId()).append("\n") 
            .append("Customer: ").append(order.getCustomer()).append("\n") 
            .append("Items in the order").append("\n");
        int index = 0;
        for (OrderTickets item: order.getOrderTickets()){
            returnString.append("")
                    .append(++index)
                    .append(". ")
                    .append(item)
                    .append("\n");
        }
        return returnString.toString();
   }
    
    
    
    @Override
    public String displayOrders(long customerId) {
        Customer customer = customerRepository.readCustomer(customerId);
        StringBuilder returnValue= new StringBuilder();
        returnValue.append(customer).append("\n");       
        for (Order order: orderRepository.readOrder()){
            if (order.getCustomer().getCustomerId() == customerId)
                    returnValue.append(order).append("\n");
        }
        return returnValue.toString();
   }

  
    
    
    @Override
    public String displayTickets() {
        StringBuilder returnValue= new StringBuilder();
        returnValue.append("Available tickets: ");
        for(Ticket ticket: ticketRepository.readTicket()){
            returnValue.append(ticket);
        }
        returnValue.append("-------------------------------------------\n");
        return returnValue.toString();
    }

    @Override
    public String displayCustomers() {
        StringBuilder returnValue= new StringBuilder();
        returnValue.append("Available customers: ");
        for(Customer customer: customerRepository.readCustomer()){
            returnValue.append(customer);
        }
        returnValue.append("-------------------------------------------\n");
        return returnValue.toString();
    }
    
    public String displayItinaries(){
        StringBuilder returnValue= new StringBuilder();
        returnValue.append("Available itinaries: ");
        for(Itinary itinary: itinaryRepository.readItinary()){
            returnValue.append(itinary);
        }
        returnValue.append("-------------------------------------------\n");
        
        
        
        return returnValue.toString();    }
   
    
    
    
}
    
    
    
    
    
    
    
    
    
    
    
    

