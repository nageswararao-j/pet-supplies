package com.pet.supplies.repository;

import com.pet.supplies.domain.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * ????
 *
 * @version $Id:$
 * @author njanjyal //I removed copyrights
 */
@Repository
public interface OrderRepository extends CrudRepository<Order, Long>
{

   /**
    * TODO
    * 
    * @param order
    */
   @Override
   @SuppressWarnings("unchecked")
   public Order save(Order order);

}
