package com.pet.supplies.model;

import java.io.Serializable;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

/**
 * @version
 * @author njanjyal //I removed copyrights
 */
@Setter
@Getter
public class CategoryModel implements Serializable
{
   /**
    * <code>serialVersionUID</code> indicates/is used for.
    */
   private static final long serialVersionUID = 1L;
   private int id;
   private String name;
   private String code;

   private Set<ProductModel> products;

}
