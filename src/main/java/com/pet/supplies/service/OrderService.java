package com.pet.supplies.service;

import com.pet.supplies.model.OrdersModel;
import java.util.List;
import java.util.Set;

/**
 * ????
 *
 * @version $Id:$
 * @author njanjyal //I removed copyrights
 */
public interface OrderService
{

   /**
    * TODO
    * 
    * @param models
    * @return
    */
   Set<OrdersModel> saveOrder(List<OrdersModel> models);

   List<OrdersModel> findOrdersByUser(Long userId);

}
