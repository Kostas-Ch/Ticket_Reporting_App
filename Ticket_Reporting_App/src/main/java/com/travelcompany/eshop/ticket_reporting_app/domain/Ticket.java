
package com.travelcompany.eshop.ticket_reporting_app.domain;

import com.travelcompany.eshop.ticket_reporting_app.exception.TicketException;
import java.math.BigDecimal;
import java.time.LocalDateTime;


public class Ticket {
    private long id;
    private long price;
    private Category category;
    private long itinaryId;
    private long customerId;

    public Ticket(long id, long customerId,long itinaryId, long price,  Category category) throws TicketException {
        this.id = id;
        this.customerId = customerId;
        this.itinaryId = itinaryId;
        this.price = price;
        this.category = category;
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


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Ticket{" + "id=" + id + ", price=" + price + ", category=" + category + ", itinaryId=" + itinaryId + ", customerId=" + customerId + '}';
    }

    
    
    

    
    
    
    
    
    
}
