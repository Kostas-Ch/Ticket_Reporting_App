
package com.travelcompany.eshop.ticket_reporting_app.domain;

import com.travelcompany.eshop.ticket_reporting_app.exception.TicketException;
import java.math.BigDecimal;
import java.time.LocalDateTime;


public class Ticket {
    private long id;
    private long price;
    private String paymentMethod;
    private long itinaryId;
    private long customerId;

    public Ticket(long id, long customerId,long itinaryId, String paymentMethod, long price  ) throws TicketException {
        this.id = id;
        this.customerId = customerId;
        this.itinaryId = itinaryId;
        this.paymentMethod = paymentMethod;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public long getItinaryId() {
        return itinaryId;
    }

    public void setItinaryId(long itinaryId) {
        this.itinaryId = itinaryId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }


    

    @Override
    public String toString() {
        return "Ticket {" + " id = " + id + ", price = " + price + ", paymentMethod = " + paymentMethod + ", itinaryId = " + itinaryId + ", customerId = " + customerId + '}'+' ';
    }

    
    
    

    
    
    
    
    
    
}
