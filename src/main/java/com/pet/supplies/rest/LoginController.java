package com.pet.supplies.rest;

/**
 * @version
 * @author njanjyal //I removed copyrights
 */
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
public class LoginController
{
   @RequestMapping("/pet-supplies")
   public String login()
   {
      return "/index.html";

   }
}
