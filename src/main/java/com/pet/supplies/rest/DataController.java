package com.pet.supplies.rest;

import com.pet.supplies.domain.Product;
import com.pet.supplies.model.ProductsModel;
import com.pet.supplies.service.ProductService;
import java.util.List;
import lombok.Setter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version
 * @author njanjyal //I removed copyrights
 */

@RestController
@EnableAutoConfiguration
@RequestMapping("/data/")
public class DataController
{

   Logger logger = Logger.getLogger(DataController.class);

   @Setter
   @Autowired
   private ProductService productService;

   @RequestMapping(value = "pets", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
   public ProductsModel loadAllPetDetails()
   {
      logger.info("DataController.loadAllPetDetails called");
      ProductsModel pm = new ProductsModel();
      pm.setProductId(new Long("100"));
      pm.setProductName("PNAME");
      List<Product> allProducts = productService.findAll();
      System.out.println(allProducts);
      return pm;
   }

}