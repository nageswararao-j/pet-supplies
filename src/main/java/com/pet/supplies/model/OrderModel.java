package com.pet.supplies.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
public class OrderModel implements Serializable
{
   /**
    * <code>serialVersionUID</code> indicates/is used for.
    */
   private static final long serialVersionUID = 1L;

   private Long orderId;

   private Long productId;

   private Long userId;

   private String productName;

   private BigDecimal productPrice;

   private String currency;

   private Integer quantity;

   private String status;

   private String shippingAddress;

   private Date orderDate;

}
