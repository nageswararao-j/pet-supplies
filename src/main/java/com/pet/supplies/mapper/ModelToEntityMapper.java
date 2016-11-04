package com.pet.supplies.mapper;

import com.pet.supplies.domain.CartItem;
import com.pet.supplies.domain.Order;
import com.pet.supplies.model.CartItemModel;
import com.pet.supplies.model.OrderModel;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.util.CollectionUtils;

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
      if (model != null)
      {
         cartItem.setProductId(model.getProductId());
         cartItem.setQuantity(model.getQuantity());
         cartItem.setProductName(model.getProductName());
         cartItem.setPrice(model.getPrice());
         cartItem.setCurrency(model.getCurrency());
      }
      return cartItem;
   }

   /**
    * TODO
    * 
    * @param models
    * @return
    */
   public static Set<Order> mapOrderModelsToOrderEntities(List<OrderModel> models)
   {
      Set<Order> orders = new HashSet<Order>();

      if (CollectionUtils.isEmpty(models))
      {
         return orders;
      }
      models.forEach(model -> {
         orders.add(mapOrderModelToOrderEntitity(model));
      });
      return orders;
   }

   /**
    * TODO
    * 
    * @param orders
    * @param model
    */
   public static Order mapOrderModelToOrderEntitity(OrderModel model)
   {
      Order order = new Order();
      if (model == null)
      {
         return order;
      }
      order.setOrderId(null);
      order.setProductId(model.getProductId());
      order.setProductName(model.getProductName());
      order.setProductPrice(model.getProductPrice());
      order.setCurrency(model.getCurrency());
      order.setQuantity(model.getQuantity());
      order.setStatus(model.getStatus());
      order.setShippingAddress(model.getShippingAddress());
      //      order.setOrderDate(model.getOrderDate());
      return order;
   }
}
