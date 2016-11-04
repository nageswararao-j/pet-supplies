package com.pet.supplies.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
public class CartItemModel implements Serializable
{
   /**
    * <code>serialVersionUID</code> indicates/is used for.
    */
   private static final long serialVersionUID = 1L;

   private Long id;

   private Long productId;

   private Integer quantity;

   private Long userId;

   private String productName;

   private BigDecimal price;

   private String currency;
}
