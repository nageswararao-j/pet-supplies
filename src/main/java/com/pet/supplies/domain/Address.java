package com.pet.supplies.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ????
 *
 * @version $Id:$
 * @author njanjyal //I removed copyrights
 */
@Entity
@Table(name = "ADDRESS")
public class Address
{

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "ADDRESS_ID")
   private Integer addressId;

   @Column(name = "BILLING_ADDRESS")
   private String billingAddress;

   @Column(name = "SHIPPING_ADDRESS")
   private String shippingAddress;

   @ManyToOne
   @JoinColumn(name = "USER_ID")
   private User user;

   public Address()
   {

   }
}
