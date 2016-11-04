package com.pet.supplies.domain;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CART")
public class CartItem
{
   @Id
   @Column(name = "ID")
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   @Column(name = "PRODUCT_ID")
   private Long productId;

   @Column(name = "QUANTITY")
   private Integer quantity;

   @Column(name = "PRODUCT_NAME")
   private String productName;

   @Column(name = "PRICE")
   private BigDecimal price;

   @Column(name = "CURRENCY")
   private String currency;

   @ManyToOne
   @JoinColumn(name = "USER_ID")
   private User user;

   public CartItem()
   {

   }

}
