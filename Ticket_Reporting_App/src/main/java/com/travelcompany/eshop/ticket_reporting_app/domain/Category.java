
package com.travelcompany.eshop.ticket_reporting_app.domain;


public enum Category {
    
    INDIVIDUAL("individual customer"),
    BUSINESS("business customer");
    
    
    private String customerCategory;
    
    private Category(String name){
       customerCategory = name;
    }
    @Override
    public String toString(){
        return customerCategory;
    }
}
