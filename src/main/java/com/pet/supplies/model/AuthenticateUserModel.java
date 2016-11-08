package com.pet.supplies.model;

import java.io.Serializable;
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
public class AuthenticateUserModel implements Serializable
{

   /**
    * <code>serialVersionUID</code> indicates/is used for.
    */
   private static final long serialVersionUID = 1L;

   private Long userId;

   private String emailId;

   private String phone;

   private String password;

   private boolean active;

   private String userName;

   private AddressModel address;

   private boolean register;

   private UserModel user;
   
   private String profile;

}
