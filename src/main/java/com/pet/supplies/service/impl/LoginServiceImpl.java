package com.pet.supplies.service.impl;

import com.pet.supplies.domain.AuthenticateUser;
import com.pet.supplies.domain.User;
import com.pet.supplies.mapper.EntityToModelMapper;
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
         if (authUser != null && authUser.getUserId() != null)
         {
            authModel = EntityToModelMapper.mapAuthenticateUserEntityToAuthenticateUserModel(authUser);
            User user = getUser(authUser);
            if (user != null)
            {
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
   private User getUser(AuthenticateUser authUser)
   {
      return userRepository.findOne(authUser.getUserId());
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
}
