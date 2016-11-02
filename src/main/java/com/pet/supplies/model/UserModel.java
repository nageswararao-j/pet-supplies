package com.pet.supplies.model;

import com.pet.supplies.domain.Address;
import com.pet.supplies.domain.CartItem;
import com.pet.supplies.domain.Order;
import com.pet.supplies.domain.Wallet;
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
public class UserModel
{

   private Long userId;

   private String name;

   private String password;

   private Set<CartItem> cartItems;

   private String emailId;

   private String phone;

   private List<Address> addresses;

   private List<Order> orders;

   private Wallet wallet;

}