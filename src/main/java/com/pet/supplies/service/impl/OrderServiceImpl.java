/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: njanjyal
 ** Copyright: (c) Nov 4, 2016 Sogeti Nederland B.V. All Rights Reserved.
 **------------------------------------------------------------------------------
 ** Sogeti Nederland B.V.            |  No part of this file may be reproduced  
 ** Distributed Software Engineering |  or transmitted in any form or by any        
 ** Lange Dreef 17                   |  means, electronic or mechanical, for the      
 ** 4131 NJ Vianen                   |  purpose, without the express written    
 ** The Netherlands                  |  permission of the copyright holder.
 *------------------------------------------------------------------------------
 */
package com.pet.supplies.service.impl;

import com.pet.supplies.constants.BusinessConstants;
import com.pet.supplies.domain.Order;
import com.pet.supplies.domain.User;
import com.pet.supplies.mapper.EntityToModelMapper;
import com.pet.supplies.mapper.ModelToEntityMapper;
import com.pet.supplies.model.OrderModel;
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
 * @author njanjyal (c) Nov 4, 2016, Sogeti B.V.
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
   public Set<OrderModel> saveOrder(List<OrderModel> models)
   {
      Set<OrderModel> orderModels = new HashSet<OrderModel>();
      //      Order orderNew = new Order();
      Set<Order> orders = ModelToEntityMapper.mapOrderModelsToOrderEntities(models);
      orders.forEach(order -> {
         User user = getUser(getUserId(models));
         order.setUser(user);
         Order newOrder = orderRepository.save(order);
         OrderModel newOrderModel = EntityToModelMapper.mapOrderEntityToOrderModel(newOrder);
         orderModels.add(newOrderModel);
      });
      //      User user = getUser(new Long(1000));
      //      orderNew.setOrderId(null);
      //      orderNew.setCurrency("EUR");
      //      orderNew.setProductId(new Long(2000));
      //      orderNew.setProductName("DUMMY");
      //      orderNew.setProductPrice(new BigDecimal("200"));
      //      orderNew.setQuantity(11);
      //      orderNew.setShippingAddress("ASDFASDFASD");
      //      orderNew.setStatus("LPAGE");
      //      orderNew.setUser(user);
      //      Order newOrder = orderRepository.save(orderNew);
      //      OrderModel newOrderModel = EntityToModelMapper.mapOrderEntityToOrderModel(orderNew);
      return orderModels;
   }

   /**
    * TODO
    * 
    * @param models
    * @return
    */
   private Long getUserId(List<OrderModel> models)
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

}
