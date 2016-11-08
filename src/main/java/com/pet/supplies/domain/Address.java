package com.pet.supplies.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "ADDRESS")
public class Address
{

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "ADDRESS_ID")
   private Integer addressId;

   @Column(name = "ADDRESS")
   private String address;

   @Column(name = "CITY")
   private String city;

   @Column(name = "STATE")
   private String state;

   @Column(name = "ZIP_CODE")
   private String zipCode;

   @Column(name = "EMAIL")
   private String email;

   @Column(name = "PHONE")
   private String phone;

   @Column(name = "COUNTRY")
   private String country;

   @OneToOne
   @JoinColumn(name = "USER_ID")
   private User user;

   public Address()
   {

   }
}
