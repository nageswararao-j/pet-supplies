package com.pet.supplies.rest;

import com.pet.supplies.common.model.OrdersModel;
import com.pet.supplies.service.OrderService;
import java.util.List;
import java.util.Set;
import lombok.Setter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ????
 *
 * @version $Id:$
 * @author njanjyal //I removed copyrights
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/order")
@CrossOrigin(origins = "${app.allow.origin}")
public class OrderController
{
   Logger logger = Logger.getLogger(OrderController.class);

   @Setter
   @Autowired
   private OrderService orderService;

   @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Set<OrdersModel>> saveOrder(@RequestBody List<OrdersModel> models)
   {
      logger.info("CartController.loadCartItems called");
      if (CollectionUtils.isEmpty(models))
      {
         return new ResponseEntity<Set<OrdersModel>>(HttpStatus.NOT_FOUND);
      }
      Set<OrdersModel> orderItems = orderService.saveOrder(models);

      return new ResponseEntity<Set<OrdersModel>>(orderItems, HttpStatus.OK);
   }

   @RequestMapping(value = "/load/{userId}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<List<OrdersModel>> findOrdersByUser(@PathVariable Long userId)
   {
      logger.info("CartController.findOrdersByUser called");
      if (userId == null)
      {
         return new ResponseEntity<List<OrdersModel>>(HttpStatus.NOT_FOUND);
      }
      List<OrdersModel> orders = orderService.findOrdersByUser(userId);

      return new ResponseEntity<List<OrdersModel>>(orders, HttpStatus.OK);
   }

}
