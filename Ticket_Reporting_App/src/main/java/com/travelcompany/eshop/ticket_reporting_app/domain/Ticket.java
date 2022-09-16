
package com.travelcompany.eshop.ticket_reporting_app.domain;

import com.travelcompany.eshop.ticket_reporting_app.exception.TicketException;
import java.math.BigDecimal;
import java.time.LocalDateTime;


public class Ticket {
    private long id;
    private BigDecimal price;
    private Category category;

    public Ticket(long id, BigDecimal price,  Category category) throws TicketException {
        this.id = id;
        this.price = price;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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
        return "Ticket{" + "id=" + id + ", price=" + price + ", customer=" + ", category=" + category + '}';
    }
    
    

    
    
    
    
    
    
}
