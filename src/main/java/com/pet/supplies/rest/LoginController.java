package com.pet.supplies.rest;

/**
 * @version
 * @author njanjyal //I removed copyrights
 */
import org.apache.log4j.Logger;

import com.pet.supplies.common.model.AuthenticateUserModel;
import com.pet.supplies.service.LoginService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@EnableAutoConfiguration
@CrossOrigin(origins = "${app.allow.origin}")
@RequestMapping("/")
public class LoginController
{
   Logger logger = Logger.getLogger(LoginController.class);
   
   @Autowired
   @Setter
   private LoginService loginService;

   @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<AuthenticateUserModel> login(@RequestBody AuthenticateUserModel model)
   {
      logger.info("LoginController.login called");
      AuthenticateUserModel userModel = null;
      if (model == null)
      {
         return new ResponseEntity<AuthenticateUserModel>(model, HttpStatus.NOT_FOUND);
      }
      if (model.isRegister())
      {
         userModel = loginService.registerNewUser(model);
      }
      else
      {
         userModel = loginService.validateLogin(model);
      }
      if(userModel.isPresent()){
         return new ResponseEntity<AuthenticateUserModel>(userModel, HttpStatus.FOUND);
      }
      if (userModel != null && !userModel.isActive())
      {
         return new ResponseEntity<AuthenticateUserModel>(model, HttpStatus.UNAUTHORIZED);
      }
      return new ResponseEntity<AuthenticateUserModel>(userModel, HttpStatus.OK);

   }
}
