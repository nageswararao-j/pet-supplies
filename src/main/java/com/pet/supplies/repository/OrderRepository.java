package com.pet.supplies.repository;

import com.pet.supplies.common.domain.Orders;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * ????
 *
 * @version $Id:$
 * @author njanjyal //I removed copyrights
 */
@Repository
public interface OrderRepository extends CrudRepository<Orders, Long>
{

   @Query("select orders from Orders orders inner join orders.user u where u.id=:userId")
   public List<Orders> findOrdersByUser(@Param("userId") Long userId);

}
