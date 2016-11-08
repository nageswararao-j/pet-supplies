package com.pet.supplies.mapper;

import com.pet.supplies.domain.Address;
import com.pet.supplies.domain.CartItem;
import com.pet.supplies.domain.Orders;
import com.pet.supplies.domain.User;

import com.pet.supplies.domain.AuthenticateUser;
import com.pet.supplies.model.AddressModel;
import com.pet.supplies.model.AuthenticateUserModel;
import com.pet.supplies.model.CartItemModel;
import com.pet.supplies.model.OrdersModel;
import com.pet.supplies.model.UserModel;
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
   public static Set<Orders> mapOrderModelsToOrderEntities(List<OrdersModel> models)
   {
      Set<Orders> orders = new HashSet<Orders>();

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
   public static Orders mapOrderModelToOrderEntitity(OrdersModel model)
   {
      Orders order = new Orders();
      if (model == null)
      {
         return order;
      }
      order.setProductId(model.getProductId());
      order.setProductName(model.getProductName());
      order.setProductPrice(model.getProductPrice());
      order.setCurrency(model.getCurrency());
      order.setQuantity(model.getQuantity());
      order.setStatus(model.getStatus());
      order.setShippingAddress(model.getShippingAddress());
      order.setOrderDate(model.getOrderDate());
      return order;
   }

   /**
    * TODO
    * 
    * @param model
    * @return
    */
   public static AuthenticateUser mapAuthenticateUserModelToAuthenticateUserEntity(AuthenticateUserModel model)
   {
      AuthenticateUser authUser = new AuthenticateUser();
      if (model != null)
      {
         authUser.setActive(model.isActive());
         authUser.setEmailId(model.getEmailId());
         authUser.setPassword(model.getPassword());
         authUser.setPhone(model.getPhone());
         authUser.setProfile(model.getProfile());
      }
      return authUser;
   }

   /**
    * TODO
    * 
    * @param
    * @return
    */
   public static Address mapAddressModelToAddressEntity(AddressModel model)
   {
      Address entity = new Address();
      if (model != null)
      {
         entity.setAddress(model.getAddress());
         entity.setCity(model.getCity());
         entity.setState(model.getState());
         entity.setZipCode(model.getZipCode());
         entity.setEmail(model.getEmail());
         entity.setPhone(model.getPhone());
         entity.setCountry(model.getCountry());
      }
      return entity;
   }

   /**
    * TODO
    * 
    * @param user
    * @return
    */
   public static User mapUserModelToUserEntity(UserModel model)
   {
      User user = new User();
      if (model != null)
      {
         user.setAddress(mapAddressModelToAddressEntity(model.getAddress()));
         user.setName(model.getName());
      }
      return user;
   }

   /**
    * TODO
    * 
    * @param user
    * @return
    */
   public static User prepateUserEntity(AuthenticateUserModel model)
   {
      User user = new User();
      if (model != null)
      {
         user.setName(model.getUserName());
      }
      return user;
   }

}
