package com.pet.supplies.model;

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
public class CartItemModel
{
   private Long id;

   private Long productId;

   private Integer quantity;

   private Long userId;

   private String productName;
}
