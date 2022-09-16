/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.ticket_reporting_app.repository.Implementation;

import com.travelcompany.eshop.ticket_reporting_app.domain.Customer;
import com.travelcompany.eshop.ticket_reporting_app.domain.Itinary;
import com.travelcompany.eshop.ticket_reporting_app.repository.ItinaryRepository;
import com.travelcompany.eshop.ticket_reporting_app.utility.GeneralUtility;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kostas Chatzifotiadis
 */
public class ItinaryRepoImpl implements ItinaryRepository {
    private List<Itinary> itinaries;

    public ItinaryRepoImpl() {
        itinaries = new ArrayList<>();
    }
    
    
   @Override
    public boolean addItinary(Itinary itinary) {
        for(int i=0; i<itinaries.size(); i++){
            if(itinaries.get(i).getId() == itinary.getId() )
                return false;
        }
        if (! GeneralUtility.isValidItinary(itinary))
            return false;
        itinaries.add(itinary);
        return true;
        
    }

    @Override
    public List<Itinary> readItinary() {
       return itinaries;
    }

    @Override
    public Itinary readItinary(long itinaryId) {
        for (int index = 0; index < itinaries.size(); index ++){
            if (itinaries.get(index).getId() == itinaryId)
                return itinaries.get(index);
        }
        return null;
    }    
    @Override
    public boolean updateItinary(long itinaryId,String destinationAirportCode) {
        Itinary itinary = readItinary(itinaryId);
        if( itinary == null) return false;
        
        for (Itinary curItinary:itinaries){
            if (curItinary.getDestinationAirportCode()!=null && curItinary.getDestinationAirportCode().equals(destinationAirportCode)){
                   return false;
            }
        }
        
        itinary.setDestinationAirportCode(destinationAirportCode);
        return true;
    }
    @Override
    public boolean deleteItinary(long itinaryId) {
        Itinary itinary = readItinary(itinaryId);
        if( itinary == null) return false;
        itinaries.remove(itinary);
        return true;
    }
    
}
