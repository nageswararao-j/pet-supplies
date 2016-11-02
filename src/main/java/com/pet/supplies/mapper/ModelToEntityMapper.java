package com.pet.supplies.mapper;

import com.pet.supplies.domain.CartItem;
import com.pet.supplies.model.CartItemModel;

/**
 * ????
 *
 * @version $Id:$
 * @author njanjyal //I removed copyrights
 */
public class ModelToEntityMapper
{
   /**
    * TODO
    * 
    * @param model
    * @return
    */
   public static CartItem mapCartItemModelToCartItemEntity(CartItemModel model)
   {
      CartItem cartItem = new CartItem();
      cartItem.setProductId(model.getProductId());
      cartItem.setQuantity(model.getQuantity());
      cartItem.setProductName(model.getProductName());
      return cartItem;
   }

}
