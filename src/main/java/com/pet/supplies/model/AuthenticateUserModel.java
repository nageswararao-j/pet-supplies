package com.pet.supplies.model;

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
public class AuthenticateUserModel
{

   private Long userId;

   private String emailId;

   private String phone;

   private String password;

   private boolean active;

   private String userName;

}
