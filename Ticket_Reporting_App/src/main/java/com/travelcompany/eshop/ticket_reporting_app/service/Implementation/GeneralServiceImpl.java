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
import java.util.Collections;
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
            orderTicket.setPaymentMethod(ticket.getPaymentMethod());
            orderTicket.setTicket(ticket);
            //orderTicket.setItemPrice(ticket.getPrice());
           if ( GeneralUtility.isBuisiness(customer.getCategory()) == true){
               orderTicket.setDiscount(0.1);
               orderTicket.setItemPrice(ticket.getPrice() - ((orderTicket.getDiscount()) * (ticket.getPrice()))  );
           }
           else {
               orderTicket.setDiscount(0.2);
               double newItemPrice = ticket.getPrice() + ((orderTicket.getDiscount()) * (ticket.getPrice()));
               orderTicket.setItemPrice(newItemPrice);
           }
           
            
            if(GeneralUtility.isBuisiness(customer.getCategory()) && GeneralUtility.isPayedByCreditCard(orderTicket) == true ){
                orderTicket.setDiscount(0.2);
                orderTicket.setItemPrice(ticket.getPrice() + ((orderTicket.getDiscount()) * (ticket.getPrice())));
            }
            else if(GeneralUtility.isBuisiness(customer.getCategory()) == false && GeneralUtility.isPayedByCreditCard(orderTicket) == true ){
                orderTicket.setDiscount(0.1);
                orderTicket.setItemPrice(ticket.getPrice() - ((orderTicket.getDiscount()) * (ticket.getPrice()))  );
            }
            
            else 
            {orderTicket.setItemPrice(orderTicket.getItemPrice());
                
            }
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
        for (OrderTickets orderTicket: order.getOrderTickets()){
            returnString.append("")
                    .append(++index)
                    .append(". ")
                    .append(orderTicket)
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
        
        return returnValue.toString();
    }

    @Override
    public String displayCustomers() {
        StringBuilder returnValue= new StringBuilder();
        returnValue.append("Available customers: ");
        for(Customer customer: customerRepository.readCustomer()){
            returnValue.append(customer);
        }
        
        return returnValue.toString();
    }
    
    public String displayItinaries(){
        StringBuilder returnValue= new StringBuilder();
        returnValue.append("Available itinaries: ");
        for(Itinary itinary: itinaryRepository.readItinary()){
            returnValue.append(itinary);
        }              
               
        return returnValue.toString();   
    }
    
    public String displayReport(){
        // List of the total number and list of the cost of tickets for all customers
            String oo= " ";
            int counter=0;
            long costOfTicket=0;
            long sumOfTickets=0;
        for(Ticket ticket: ticketRepository.readTicket()){
             costOfTicket = ticket.getPrice();  
             sumOfTickets = costOfTicket + sumOfTickets;
             counter++;           
        }
        
        return ("Number of Tickets: "+ counter + " Total cost of tickets: " + sumOfTickets).toString();
        }
    public String displayReport1(){
        //List of the total offered itineraries per destination and offered itineraries per departure
            List destinations = new ArrayList();    
            List departures = new ArrayList();
            int i =0;
            int j = 0;
            int par=0;
            int lon=0;
            int ams=0;
            int dub=0;
            int fra=0;
            int mex=0;
            int ath=0;
            for(Itinary itinary: itinaryRepository.readItinary()){              
                destinations.add(itinary.getDestinationAirportCode());
                departures.add(itinary.getDepartureAirportCode());             
            }
            par = Collections.frequency(destinations, "PAR");
            lon = Collections.frequency(destinations, "LON");
            ams = Collections.frequency(destinations, "AMS");
            dub = Collections.frequency(destinations, "DUB");
            fra = Collections.frequency(destinations, "FRA");
            mex = Collections.frequency(destinations, "MEX");
            ath = Collections.frequency(departures, "ATH");
            
            return ("Total itineraries per destination: "+" ATH:"+ ath +" || "+ "Total itineraries per departure: "+ " PAR :"+ par+ " LON :"+ lon+ " AMS :"+ ams+ " DUB :"+ dub + " FRA :"+ fra+ " MEX :"+ mex ).toString();
        }
    
       public String displayReport2(){
           //List of the customers with the most tickets and with the largest cost of purchases
           List passengerId = new ArrayList();    
           List paymentAmount = new ArrayList();
           List mostTickets = new ArrayList();
           List customers = new ArrayList();
           long payment=0;
           long totalPayment=0;
           for(Ticket ticket: ticketRepository.readTicket()){              
                passengerId.add(Long.toString(ticket.getCustomerId()));
                paymentAmount.add(Long.toString(ticket.getPrice()));     
                if(ticket.getCustomerId()== 2){
                    payment =+ ticket.getPrice();
                    totalPayment = payment + totalPayment;
                }
            }
           for (int i=1 ; i <= passengerId.size(); i++){
           mostTickets.add(Collections.frequency(passengerId, Integer.toString(i)));
           }
           for(Customer customer: customerRepository.readCustomer()){
               customers.add(customer.getName());
           }
           
           
           System.out.println("Total number of Purchases per Customer: ");
           
           return customers.get(0).toString() + ": "+ mostTickets.get(0)+ " "+customers.get(1).toString() + ": "+ mostTickets.get(1)+ " "+customers.get(2).toString() + ": "+ mostTickets.get(2)
                  + " " + customers.get(3).toString() + ": "+ mostTickets.get(3)+ " "+customers.get(4).toString() +": "+ mostTickets.get(4)
                  + " " +customers.get(5).toString() + ": "+ mostTickets.get(5)+ " "+customers.get(6).toString() + ": "+ mostTickets.get(6)
                  + " " +customers.get(7).toString() + ": "+ mostTickets.get(7)+" "+customers.get(8).toString() + ": "+ mostTickets.get(8)
                  +"\n" +"The largest cost of purchases are: "+ customers.get(1).toString()+" "+ totalPayment;
       }
       
       
    }
    
    
    
    
    
    
   

  
    

    
    
    
    
    
    
    
    
    
    
    
    

