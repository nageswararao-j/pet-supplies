package com.pet.supplies.repository;

import com.pet.supplies.domain.Category;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @version
 * @author njanjyal //I removed copyrights
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer>
{
   List<Category> findAll();

   /**
    * TODO
    * 
    * @return
    */
   @Query("from Category c where c.code =:categoryCode")
   List<Category> findByCategoryCode(@Param("categoryCode") String categoryCode);
}
