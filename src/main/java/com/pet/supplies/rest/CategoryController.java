package com.pet.supplies.rest;

import com.pet.supplies.common.constants.BusinessConstants;
import com.pet.supplies.common.model.CategoryModel;
import com.pet.supplies.service.CategoryService;
import java.util.ArrayList;
import java.util.List;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version
 * @author njanjyal //I removed copyrights
 */

@RestController
@EnableAutoConfiguration
@CrossOrigin(origins = "${app.allow.origin}")
@RequestMapping("/category")
public class CategoryController
{

   Logger logger = Logger.getLogger(CategoryController.class);

   @Setter
   @Autowired
   private CategoryService categoryService;

   @RequestMapping(value = "/{code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<List<CategoryModel>> loadProductsByCategory(@PathVariable String code)
   {
      logger.info("CategoryController.loadPetsBySelectedCategory called");
      List<CategoryModel> products = new ArrayList<CategoryModel>();
      if (StringUtils.equals(code, BusinessConstants.CATEGORY_ALL))
      {
         products = categoryService.findAll();
      }
      else
      {
         products = categoryService.findByCategoryCode(code);
      }

      if (CollectionUtils.isEmpty(products))
      {
         new ResponseEntity<List<CategoryModel>>(HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<List<CategoryModel>>(products, HttpStatus.OK);
   }
}