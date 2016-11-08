package com.pet.supplies.service.impl;

import com.pet.supplies.domain.Product;

import com.pet.supplies.repository.ProductRepository;
import com.pet.supplies.service.ProductService;
import java.util.List;
import javax.transaction.Transactional;
import lombok.Setter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version
 * @author njanjyal //I removed copyrights
 */
@Transactional
@Service
public class ProductServiceImpl implements ProductService
{

   Logger logger = Logger.getLogger(ProductServiceImpl.class);

   @Setter
   @Autowired
   ProductRepository productRepository;

   @Override
   public List<Product> findAll()
   {
      logger.info("ProductServiceImpl.findAll called");
      return productRepository.findAll();
   }
}
