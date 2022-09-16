
package com.travelcompany.eshop.ticket_reporting_app.repository;

import com.travelcompany.eshop.ticket_reporting_app.domain.Customer;
import com.travelcompany.eshop.ticket_reporting_app.domain.Itinary;
import java.util.List;

/**
 *
 * @author Kostas Chatzifotiadis
 */
public interface ItinaryRepository {
    boolean addItinary(Itinary itinary);
    List<Itinary> readItinary();
    Itinary readItinary(long itinary);
    boolean updateItinary(long itinary,String destinationAirportCode);
    boolean deleteItinary(long itinary); 
}
