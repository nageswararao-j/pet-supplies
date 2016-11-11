package com.pet.supplies.repository;

import com.pet.supplies.common.domain.Product;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @version
 * @author njanjyal //I removed copyrights
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long>
{
   List<Product> findAll();
}
