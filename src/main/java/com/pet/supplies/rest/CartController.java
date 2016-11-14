package com.pet.supplies.rest;

import com.pet.supplies.common.constants.BusinessConstants;
import com.pet.supplies.messages.MessageTemplate;
import com.pet.supplies.common.model.CartItemModel;
import com.pet.supplies.service.CartService;
import java.util.List;
import lombok.Setter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/cart")
@CrossOrigin(origins = "${app.allow.origin}")
public class CartController
{
   Logger logger = Logger.getLogger(CartController.class);

   @Setter
   @Autowired
   private CartService cartService;

   @RequestMapping(value = "/load/{userId}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<List<CartItemModel>> loadCartItems(@PathVariable Long userId)
   {
      logger.info("CartController.loadCartItems called");
      if (userId == null)
      {
         return new ResponseEntity<List<CartItemModel>>(HttpStatus.NOT_FOUND);
      }
      List<CartItemModel> cartItems = cartService.loadCartItems(userId);

      return new ResponseEntity<List<CartItemModel>>(cartItems, HttpStatus.OK);
   }

   @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<CartItemModel> saveCartItem(@RequestBody CartItemModel model)
   {
      logger.info("CartController.saveCartItem called");
      if (model == null)
      {
         return new ResponseEntity<CartItemModel>(HttpStatus.NOT_FOUND);
      }
      CartItemModel cartItem = cartService.saveCartItem(model);
      return new ResponseEntity<CartItemModel>(cartItem, HttpStatus.OK);
   }

   @RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<MessageTemplate> deleteCartItem(@RequestBody CartItemModel model)
   {
      logger.info("CartController.deleteCartItem called");
      if (model == null)
      {
         return new ResponseEntity<MessageTemplate>(HttpStatus.NOT_FOUND);
      }
      cartService.deleteCartItem(model);
      MessageTemplate msgTemplate = new MessageTemplate();
      msgTemplate.setStatus(BusinessConstants.DELETED);
      return new ResponseEntity<MessageTemplate>(msgTemplate, HttpStatus.OK);
   }

   @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<MessageTemplate> updateCartItemQuantity(@RequestBody CartItemModel model)
   {
      logger.info("CartController.updateCartItemQuantity called");
      if (model == null)
      {
         return new ResponseEntity<MessageTemplate>(HttpStatus.NOT_FOUND);
      }
      MessageTemplate msgTemplate = new MessageTemplate();
      if (cartService.updateCartItemQuantity(model) == 1)
      {
         msgTemplate.setStatus(BusinessConstants.UPDATED);
      }
      return new ResponseEntity<MessageTemplate>(msgTemplate, HttpStatus.OK);
   }
}
