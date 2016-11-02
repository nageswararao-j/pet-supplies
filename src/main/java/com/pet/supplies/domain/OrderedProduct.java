package com.pet.supplies.domain;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * ????
 *
 * @version $Id:$
 * @author njanjyal //I removed copyrights
 */

@Entity
@Setter
@Getter
@Table(name = "ORDERED_PRODUCT")
public class OrderedProduct
{
   @Id
   @Column(name = "ORDERED_ID")
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long orderId;

   @Column(name = "PRODUCT_NAME")
   private String productName;

   @Column(name = "PRODUCT_PRICE")
   private BigDecimal productPrice;

   @Column(name = "CURRENCY")
   private String currency;

   @Column(name = "QUANTITY")
   private Integer quantity;

   //   @ManyToOne
   //   @JoinColumn(name = "ORDER_ID")
   //   private Order orderedProduct;

   public OrderedProduct()
   {

   }

}
