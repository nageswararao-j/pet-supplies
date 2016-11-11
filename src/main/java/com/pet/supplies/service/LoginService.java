package com.pet.supplies.service;

import com.pet.supplies.common.model.AuthenticateUserModel;

/**
 * ????
 *
 * @version $Id:$
 * @author njanjyal //I removed copyrights
 */
public interface LoginService
{

   /**
    * TODO
    * 
    * @return
    */
   AuthenticateUserModel validateLogin(AuthenticateUserModel model);

   /**
    * TODO
    * 
    * @param model
    * @return
    */
   AuthenticateUserModel registerNewUser(AuthenticateUserModel model);

}
