package com.pet.supplies.service.impl;

import com.pet.supplies.domain.CartItem;
import com.pet.supplies.domain.User;

import com.pet.supplies.mapper.EntityToModelMapper;
import com.pet.supplies.mapper.ModelToEntityMapper;
import com.pet.supplies.model.CartItemModel;
import com.pet.supplies.repository.CartRepository;
import com.pet.supplies.repository.UserRepository;
import com.pet.supplies.service.CartService;
import java.util.List;
import javax.transaction.Transactional;
import lombok.Setter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ????
 *
 * @version $Id:$
 * @author njanjyal //I removed copyrights
 */
@Transactional
@Service
public class CartServiceImpl implements CartService
{
   Logger logger = Logger.getLogger(CartServiceImpl.class);

   @Setter
   @Autowired
   private CartRepository cartRepository;

   @Setter
   @Autowired
   private UserRepository userRepository;

   /*
    * (non-Javadoc)
    * @see com.pet.supplies.service.CartService#loadCartItems(java.lang.Long)
    */
   @Override
   public List<CartItemModel> loadCartItems(Long userId)
   {
      List<CartItem> cartItems = cartRepository.findCartItemsByUser(userId);
      return EntityToModelMapper.mapCartItemEntitiesToCartItemModels(cartItems);
   }

   /*
    * (non-Javadoc)
    * @see com.pet.supplies.service.CartService#saveCartItem(com.pet.supplies.domain.CartItem)
    */
   @Override
   public CartItemModel saveCartItem(CartItemModel model)
   {
      logger.info("CartServiceImpl.saveCartItem called");
      CartItem cartItem = ModelToEntityMapper.mapCartItemModelToCartItemEntity(model);
      cartItem.setUser(getUser(model));
      cartItem = cartRepository.save(cartItem);
      return EntityToModelMapper.mapCartItemEntityToCartItemModel(cartItem);
   }

   /*
    * (non-Javadoc)
    * @see com.pet.supplies.service.CartService#deleteCartItem(com.pet.supplies.model.CartItemModel)
    */
   @Override
   public void deleteCartItem(CartItemModel model)
   {
      logger.info("CartServiceImpl.deleteCartItem called");
      CartItem cartItem = ModelToEntityMapper.mapCartItemModelToCartItemEntity(model);
      cartItem.setId(model.getId());
      cartItem.setUser(getUser(model));
      cartRepository.delete(cartItem);
   }

   /*
    * (non-Javadoc)
    * @see com.pet.supplies.service.CartService#updateCartItemQuantity(com.pet.supplies.model.CartItemModel)
    */
   @Override
   public Integer updateCartItemQuantity(CartItemModel model)
   {
      logger.info("CartServiceImpl.updateCartItem called");
      return cartRepository.updateQuantity(model.getUserId(), model.getProductId(), model.getQuantity());
   }

   /**
    * TODO
    * 
    * @param model
    * @return
    */
   private User getUser(CartItemModel model)
   {
      return model != null ? userRepository.findOne(model.getUserId()) : null;
   }

}
