package com.pet.supplies.service.impl;

import com.pet.supplies.domain.Address;
import com.pet.supplies.domain.User;

import com.pet.supplies.domain.AuthenticateUser;
import com.pet.supplies.mapper.EntityToModelMapper;
import com.pet.supplies.mapper.ModelToEntityMapper;
import com.pet.supplies.model.AddressModel;
import com.pet.supplies.model.AuthenticateUserModel;
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
      if (isModelValuesNotNull(model))
      {
         authUser = loginRepository.authenticateUser(model.getEmailId(), model.getPassword());
         if (authUser != null)
         {
            authModel = EntityToModelMapper.mapAuthenticateUserEntityToAuthenticateUserModel(authUser);
            User user = getUser(authUser.getUserId());
            if (user != null)
            {
               Address address = user.getAddress();
               AddressModel addressModel = EntityToModelMapper.mapAddressEntityToAddressModel(address);
               authModel.setAddress(addressModel);
               authModel.setUserName(user.getName());
            }
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

   /**
    * TODO
    * 
    * @param model
    * @return
    */
   private boolean isModelValuesNotNull(AuthenticateUserModel model)
   {
      return model != null && (model.getEmailId() != null || model.getPhone() != null) && model.getPassword() != null;
   }

   /*
    * (non-Javadoc)
    * @see com.pet.supplies.service.LoginService#registerNewUser(com.pet.supplies.model.AuthenticateUserModel)
    */
   @Override
   public AuthenticateUserModel registerNewUser(AuthenticateUserModel model)
   {
      AuthenticateUser authUser = null;
      User user = null;
      AuthenticateUserModel authModel = new AuthenticateUserModel();
      if (model != null)
      {
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
}
