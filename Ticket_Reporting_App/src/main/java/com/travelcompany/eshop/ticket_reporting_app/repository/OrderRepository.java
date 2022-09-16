
package com.travelcompany.eshop.ticket_reporting_app.repository;

import com.travelcompany.eshop.ticket_reporting_app.domain.Order;
import java.math.BigDecimal;
import java.util.List;


public interface OrderRepository {
    boolean addOrder(Order order);
    List<Order> readOrder();
    Order readOrder(long orderId);
    boolean updateOrder(long orderId, BigDecimal newPrice);
    boolean deleteOrder(long orderId);
}
