package com.pet.supplies.repository;

import com.pet.supplies.common.domain.CartItem;

import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
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
public interface CartRepository extends CrudRepository<CartItem, Long>
{

   /**
    * TODO
    * 
    * @param userId
    */
   @Query("select cart from CartItem cart inner join cart.user u where u.id=:userId")
   public List<CartItem> findCartItemsByUser(@Param("userId") Long userId);

   /**
    * TODO
    * 
    * @param cartItem
    * @return
    */
   @Modifying
   @Query("update CartItem cart set cart.quantity=:quantity where cart.user.id=:userId and cart.productId=:productId")
   public Integer updateQuantity(@Param("userId") Long userId, @Param("productId") Long productId, @Param("quantity") Integer quantity);

}
