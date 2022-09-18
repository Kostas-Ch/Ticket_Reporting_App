
package com.travelcompany.eshop.ticket_reporting_app.service;

import com.travelcompany.eshop.ticket_reporting_app.domain.Order;


public interface GeneralService {
    void loadInitialCustomerData();
    void loadInitialItinaryData();
    void loadInitialTicketData();
    Order createOrder(long orderId,long customerId,long[] ticketIds);
    
    String displayOrders(long customerId);
    String displayOrder(long orderId);
    
    String displayTickets();
    String displayCustomers();
    String displayItinaries();
    String displayReport();   
    String displayReport1();
    String displayReport2();
    
}
