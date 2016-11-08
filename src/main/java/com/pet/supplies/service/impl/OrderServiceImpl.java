package com.pet.supplies.service.impl;

import com.pet.supplies.domain.Orders;
import com.pet.supplies.domain.User;

import com.pet.supplies.constants.BusinessConstants;
import com.pet.supplies.mapper.EntityToModelMapper;
import com.pet.supplies.mapper.ModelToEntityMapper;
import com.pet.supplies.model.OrdersModel;
import com.pet.supplies.repository.OrderRepository;
import com.pet.supplies.repository.UserRepository;
import com.pet.supplies.service.OrderService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.transaction.Transactional;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * ????
 *
 * @version $Id:$
 * @author njanjyal //I removed copyrights
 */
@Transactional
@Service
public class OrderServiceImpl implements OrderService
{
   @Setter
   @Autowired
   private OrderRepository orderRepository;

   @Setter
   @Autowired
   private UserRepository userRepository;

   /*
    * (non-Javadoc)
    * @see com.pet.supplies.service.OrderService#saveOrder(java.util.List)
    */
   @Override
   public Set<OrdersModel> saveOrder(List<OrdersModel> models)
   {
      Set<OrdersModel> orderModels = new HashSet<OrdersModel>();
      Set<Orders> orders = ModelToEntityMapper.mapOrderModelsToOrderEntities(models);
      orders.forEach(order -> {
         User user = getUser(getUserId(models));
         order.setUser(user);
         Orders newOrder = orderRepository.save(order);
         OrdersModel newOrderModel = EntityToModelMapper.mapOrderEntityToOrderModel(newOrder);
         orderModels.add(newOrderModel);
      });
      return orderModels;
   }

   /**
    * TODO
    * 
    * @param models
    * @return
    */
   private Long getUserId(List<OrdersModel> models)
   {
      if (!CollectionUtils.isEmpty(models))
      {
         if (models.get(0) != null)
         {
            return models.get(0).getUserId();
         }
      }
      return BusinessConstants.ONE;
   }

   private User getUser(Long userId)
   {
      return userRepository.findOne(userId);
   }

   /*
    * (non-Javadoc)
    * @see com.pet.supplies.service.OrderService#findOrdersByUser(java.lang.Long)
    */
   @Override
   public List<OrdersModel> findOrdersByUser(Long userId)
   {
      List<Orders> orders = orderRepository.findOrdersByUser(userId);
      return EntityToModelMapper.mapOrderEntitiesToOrderModels(orders);
   }

}
