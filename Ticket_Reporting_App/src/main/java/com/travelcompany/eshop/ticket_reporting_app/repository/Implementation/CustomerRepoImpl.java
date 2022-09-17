/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.ticket_reporting_app.repository.Implementation;

import com.travelcompany.eshop.ticket_reporting_app.domain.Customer;
import com.travelcompany.eshop.ticket_reporting_app.repository.CustomerRepository;
import com.travelcompany.eshop.ticket_reporting_app.utility.GeneralUtility;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kostas Chatzifotiadis
 */
public class CustomerRepoImpl implements CustomerRepository{
    private final List<Customer> customers;

    public CustomerRepoImpl() {
         customers = new ArrayList<>();
    }

    @Override
    public boolean addCustomer(Customer customer) {
        for(int i=0; i<customers.size(); i++){
            if(customers.get(i).getCustomerId() == customer.getCustomerId() )
                return false;
        }
        if (! GeneralUtility.isValidCustomer(customer))
            return false;
        customers.add(customer);
        return true;
        
    }

    @Override
    public List<Customer> readCustomer() {
       return customers;
    }

    @Override
    public Customer readCustomer(long customerId) {
        for (int index = 0; index < customers.size(); index ++){
            if (customers.get(index).getCustomerId() == customerId)
                return customers.get(index);
        }
        return null;
    }    
    @Override
    public boolean updateCustomer(long customerId, String newEmail) {
        Customer customer = readCustomer(customerId);
        if( customer == null) return false;
        
        for (Customer curCustomer:customers){
            if (curCustomer.getEmail()!=null && curCustomer.getEmail().equals(newEmail)){
                   return false;
            }
        }
        
        customer.setEmail(newEmail);
        return true;
    }
    @Override
    public boolean deleteCustomer(long customerId) {
        Customer customer = readCustomer(customerId);
        if( customer == null) return false;
        customers.remove(customer);
        return true;
    }
    
}
    
    
    
    
    

