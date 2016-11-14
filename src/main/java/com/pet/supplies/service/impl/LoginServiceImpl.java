package com.pet.supplies.service.impl;

import com.pet.supplies.common.helper.LoginHelper;
import com.pet.supplies.common.mapper.ModelToEntityMapper;
import com.pet.supplies.common.mapper.EntityToModelMapper;
import com.pet.supplies.common.domain.Address;
import com.pet.supplies.common.domain.User;
import com.pet.supplies.common.domain.AuthenticateUser;
import com.pet.supplies.common.model.AuthenticateUserModel;
import com.pet.supplies.repository.LoginRepository;
import com.pet.supplies.repository.UserRepository;
import com.pet.supplies.service.LoginService;
import javax.transaction.Transactional;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ????
 *
 * @version $Id:$
 * @author njanjyal //I removed copyrights
 */
@Service
@Transactional
public class LoginServiceImpl implements LoginService
{
   @Autowired
   @Setter
   private LoginRepository loginRepository;

   @Autowired
   @Setter
   private UserRepository userRepository;

   /*
    * (non-Javadoc)
    * @see com.pet.supplies.service.LoginService#validateLogin()
    */
   @Override
   public AuthenticateUserModel validateLogin(AuthenticateUserModel model)
   {
      AuthenticateUser authUser = null;
      AuthenticateUserModel authModel = new AuthenticateUserModel();
      if (LoginHelper.isModelValuesNotNull(model))
      {
         authUser = loginRepository.authenticateUser(model.getEmailId(), model.getPassword());
         if (authUser != null)
         {
            authModel = EntityToModelMapper.mapAuthenticateUserEntityToAuthenticateUserModel(authUser);
            User user = getUser(authUser.getUserId());
            LoginHelper.setUserToAuthModelAfterLogin(authModel, user);
         }
      }
      return authModel;
   }

   /**
    * TODO
    * 
    * @param authUser
    * @return
    */
   private User getUser(Long userId)
   {
      return userRepository.findOne(userId);
   }

   /*
    * (non-Javadoc)
    * @see com.pet.supplies.service.LoginService#registerNewUser(com.pet.supplies.common.model.AuthenticateUserModel)
    */
   @Override
   public AuthenticateUserModel registerNewUser(AuthenticateUserModel model)
   {
      AuthenticateUser authUser = null;
      User user = null;
      AuthenticateUserModel authModel = new AuthenticateUserModel();
      if (model != null)
      {
         if(isEmailExists(model)){
            authModel.setPresent(true);
            return authModel;
         }
         authUser = ModelToEntityMapper.mapAuthenticateUserModelToAuthenticateUserEntity(model);
         user = ModelToEntityMapper.prepateUserEntity(model);
         User newUser = userRepository.save(user);
         Address address = ModelToEntityMapper.mapAddressModelToAddressEntity(model.getAddress());
         address.setUser(newUser);
         newUser.setAddress(address);
         authUser.setUserId(newUser.getId());
         authUser.setActive(true);
         authUser = loginRepository.save(authUser);
         authModel = EntityToModelMapper.mapAuthenticateUserEntityToAuthenticateUserModel(authUser);
         authModel.setAddress(EntityToModelMapper.mapAddressEntityToAddressModel(newUser.getAddress()));
         authModel.setUserName(user.getName());
      }
      return authModel;
   }

   /**
    * TODO
    * @param model
    * @return
    */
   private boolean isEmailExists(AuthenticateUserModel model)
   {
      return loginRepository.isEmailRegistered(model.getEmailId()) != null ? true:false;
   }
}
