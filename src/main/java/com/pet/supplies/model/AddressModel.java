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
public class AddressModel implements Serializable
{
   /**
    * <code>serialVersionUID</code> indicates/is used for.
    */
   private static final long serialVersionUID = 1L;

   private Integer addressId;

   private String address;

   private String city;

   private String state;

   private String zipCode;

   private String email;

   private String phone;

   private String country;

   private Date orderDate;

}
