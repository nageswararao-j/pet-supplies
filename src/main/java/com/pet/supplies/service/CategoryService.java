package com.pet.supplies.service;

import com.pet.supplies.common.model.CategoryModel;
import java.util.List;

/**
 * @version
 * @author njanjyal //I removed copyrights
 */
public interface CategoryService
{
   List<CategoryModel> findAll();

   List<CategoryModel> findByCategoryCode(String categoryCode);
}
