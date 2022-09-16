/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.travelcompany.eshop.ticket_reporting_app;

import com.travelcompany.eshop.ticket_reporting_app.service.GeneralService;
import com.travelcompany.eshop.ticket_reporting_app.service.Implementation.GeneralServiceImpl;

/**
 *
 * @author Kostas Chatzifotiadis
 */
public class Ticket_Reporting_App {

    public static void main(String[] args) {
        GeneralService service = new GeneralServiceImpl();
        service.loadInitialCustomerData();
       // service.loadInitialItinaryData();
        service.loadInitialTicketData();
        
        System.out.println(service.displayCustomers());
        //System.out.println(service.displayItinaries());
        System.out.println(service.displayTickets());
    }
}
