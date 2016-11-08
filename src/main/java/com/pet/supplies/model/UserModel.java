package com.pet.supplies.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
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
public class UserModel implements Serializable
{

   /**
    * <code>serialVersionUID</code> indicates/is used for.
    */
   private static final long serialVersionUID = 1L;

   private Long userId;

   private String name;

   private String password;

   private Set<CartItemModel> cartItems;

   private String emailId;

   private String phone;

   private AddressModel address;

   private List<OrdersModel> orders;

   private WalletModel wallet;

}
