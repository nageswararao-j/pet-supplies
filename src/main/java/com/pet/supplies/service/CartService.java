package com.pet.supplies.service;

import com.pet.supplies.common.model.CartItemModel;
import java.util.List;

/**
 * ????
 *
 * @version $Id:$
 * @author njanjyal //I removed copyrights
 */
public interface CartService
{
   public List<CartItemModel> loadCartItems(Long userId);

   public CartItemModel saveCartItem(CartItemModel cartItem);

   public void deleteCartItem(CartItemModel model);

   public Integer updateCartItemQuantity(CartItemModel model);
}
