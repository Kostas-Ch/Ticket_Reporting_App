/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.ticket_reporting_app.repository;

import com.travelcompany.eshop.ticket_reporting_app.domain.Customer;
import java.util.List;

/**
 *
 * @author Kostas Chatzifotiadis
 */
public interface CustomerRepository {
    boolean addCustomer(Customer customer);
    List<Customer> readCustomer();
    Customer readCustomer(long cutomerId);
    boolean updateCustomer(long customerId, String newEmail);
    boolean deleteCustomer(long customerId); 
}
