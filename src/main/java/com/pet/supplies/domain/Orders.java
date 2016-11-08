package com.pet.supplies.domain;

import java.util.Date;
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
@Table(name = "ORDERS")
public class Orders
{

   @Id
   @Column(name = "ORDER_ID")
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer orderId;

   @Column(name = "PRODUCT_ID")
   private Long productId;

   @Column(name = "PRODUCT_NAME")
   private String productName;

   @Column(name = "PRODUCT_PRICE")
   private Float productPrice;

   @Column(name = "CURRENCY")
   private String currency;

   @Column(name = "QUANTITY")
   private Integer quantity;

   @Column(name = "STATUS")
   private String status;

   @Column(name = "SHIPPING_ADDRESS")
   private String shippingAddress;

   @Column(name = "ORDER_DATE")
   private Date orderDate;

   @ManyToOne
   @JoinColumn(name = "USER_ID")
   private User user;

   public Orders()
   {

   }
}
