package com.pet.supplies.service.impl;

import com.pet.supplies.domain.Category;

import com.pet.supplies.mapper.EntityToModelMapper;
import com.pet.supplies.model.CategoryModel;
import com.pet.supplies.repository.CategoryRepository;
import com.pet.supplies.service.CategoryService;
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
public class CategoryServiceImpl implements CategoryService
{

   Logger logger = Logger.getLogger(CategoryServiceImpl.class);

   @Setter
   @Autowired
   private CategoryRepository categoryRepository;

   @Override
   public List<CategoryModel> findAll()
   {
      logger.info("CategoryServiceImpl.findAll called");
      List<Category> categories = categoryRepository.findAll();
      return EntityToModelMapper.mapCategoryEntityToCategoryModel(categories);
   }

   /*
    * (non-Javadoc)
    * @see com.pet.supplies.service.CategoryService#findByCategoryCode(java.lang.String)
    */
   @Override
   public List<CategoryModel> findByCategoryCode(String categoryCode)
   {
      logger.info("CategoryServiceImpl.findByCategoryCode called");
      List<Category> categories = categoryRepository.findByCategoryCode(categoryCode);
      return EntityToModelMapper.mapCategoryEntityToCategoryModel(categories);
   }
}
