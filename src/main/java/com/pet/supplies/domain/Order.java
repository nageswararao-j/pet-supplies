package com.pet.supplies.domain;

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
@Table(name = "ORDER")
public class Order
{
   @Id
   @Column(name = "ORDER_ID")
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long orderId;

   @ManyToOne
   @JoinColumn(name = "USER_ID")
   private User user;

   //
   //   @Column(name = "USER_ID")
   //   private Long userId;

   //   @OneToMany(mappedBy = "orderedProduct", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   //   private List<OrderedProduct> orderedProducts;

   public Order()
   {

   }

}
