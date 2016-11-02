package com.pet.supplies.model;

import java.util.Set;
import lombok.Getter;
import lombok.Setter;

/**
 * @version
 * @author njanjyal //I removed copyrights
 */
@Setter
@Getter
public class CategoryModel
{
   private int id;
   private String name;
   private String code;

   private Set<ProductModel> products;

}
