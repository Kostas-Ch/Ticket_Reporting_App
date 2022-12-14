/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.ticket_reporting_app.utility;

import com.travelcompany.eshop.ticket_reporting_app.domain.Customer;
import com.travelcompany.eshop.ticket_reporting_app.domain.Itinary;
import com.travelcompany.eshop.ticket_reporting_app.domain.OrderTickets;
import com.travelcompany.eshop.ticket_reporting_app.domain.Ticket;
import com.travelcompany.eshop.ticket_reporting_app.repository.CustomerRepository;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Xatzifire
 */
public class GeneralUtility {
    
    //long id, String name, String email, String address, String nationality, String Category
    public static String[] customers = {
        "1,Maria Iordanou,miordanou@mail.com,Athens,Greek,Individual",
        "2,Dimitriou Dimitrios,ddimitriou@mail.com,Athens,Greek,Individual",
        "3,Ioannis Ioannou,iioannou@mail.com,Athens,Greek,Business",
        "4,Antonio Molinari,amolinari@mail.com,Milan,Italian,Individual",
        "5,Frederico Rossi,frossi@mail.com,Milan,Italian,Individual",
        "6,Mario Conti,mconti@mail.com,Rome,Italian,Business",
        "7,Nathan Martin,nmartin@mail.com,Athens,French,Business",
        "8,Enzo Collin,ecollin@mail.com,Athens,French,Individual",
        "9,Frederic Michel,fmichel@mail.com,Athens,French,Individual",
    };
    //long id, String departure airport code, String destination airport code, String departure date, String airline, long basic price
    public static String[] itinaries = {
        "1,ATH,PAR,22/02/2022 13:35,Skylines,300",
        "2,ATH,LON,22/02/2022 13:40,Skylines,420",
        "3,ATH,AMS,22/02/2022 13:45,Skylines,280",
        "4,ATH,PAR,22/02/2022 14:20,Skylines,310",
        "5,ATH,DUB,22/02/2022 14:35,Skylines,880",
        "6,ATH,FRA,22/02/2022 14:55,Skylines,380",
        "7,ATH,FRA,22/02/2022 15:35,Skylines,350",
        "8,ATH,MEX,22/02/2022 16:00,Skylines,1020",
        "9,ATH,DUB,22/02/2022 16:35,Skylines,770",
    };
    // long id, long customer id, long Id,String paymentMethod, double price
    public static String[] tickets = {
        "1,1,2,Cash,462",
        "2,2,3,Cash,308",   
        "3,3,3,Credit Card,224",
        "4,2,4,Credit Card,341",
        "5,3,4,Cash,248",
        "6,4,7,Credit Card,968",
        "7,5,7,Credit Card,968",
        "8,2,10,Cash,1122",
        "9,1,3,Cash,308",
    };
    
    public static boolean isValidEmail(String email){
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    public static boolean isValidCustomer(Customer customer){
        if (customer.getName()== null) return false;
        if (customer.getEmail().contains("@travelcompany.com")) return false;
        return true;
    }
    
    public static boolean isValidItinary(Itinary itinary){
        if (itinary.getDepartureAirportCode()== null) return false;
        if (itinary.getDestinationAirportCode()==null) return false;
        return true;
    }
    
 
    
    public static boolean isPayedByCreditCard(OrderTickets orderticket){
        
        if( orderticket.getPaymentMethod().toLowerCase() == "cash")
            return false;
            
        else
            
        
        return true;
    }
    
    public static boolean isBuisiness(String customerCategory){
        
 
       if( customerCategory.toLowerCase() == "business")
         return true;
       else 
        return false; 
        
        
    }
    
    
}