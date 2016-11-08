package com.pet.supplies.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * ????
 *
 * @version $Id:$
 * @author njanjyal //I removed copyrights
 */
@Setter
@Getter
public class OrdersModel implements Serializable
{
   /**
    * <code>serialVersionUID</code> indicates/is used for.
    */
   private static final long serialVersionUID = 1L;

   private Integer orderId;

   private Long productId;

   private Long userId;

   private String productName;

   private Float productPrice;

   private String currency;

   private Integer quantity;

   private String status;

   private String shippingAddress;

   private Date orderDate;

}
