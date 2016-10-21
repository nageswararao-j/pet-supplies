package com.pet.supplies.domain;

/**
 * @version
 * @author njanjyal //I removed copyrights
 */
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORY")
public class Category
{
   private int id;
   private String name;
   private String code;

   private Set<Product> products;

   /**
    * Get the id.
    * 
    * @return Returns the id as a int.
    */
   @Id
   @Column(name = "CAT_ID")
   @GeneratedValue
   public int getId()
   {
      return id;
   }

   /**
    * Set the id to the specified value.
    * 
    * @param id The id to set.
    */
   public void setId(int id)
   {
      this.id = id;
   }

   /**
    * Get the name.
    * 
    * @return Returns the name as a String.
    */
   public String getName()
   {
      return name;
   }

   /**
    * Set the name to the specified value.
    * 
    * @param name The name to set.
    */
   public void setName(String name)
   {
      this.name = name;
   }

   /**
    * Get the products.
    * 
    * @return Returns the products as a Set<Product>.
    */
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
   public Set<Product> getProducts()
   {
      return products;
   }

   /**
    * Set the products to the specified value.
    * 
    * @param products The products to set.
    */
   public void setProducts(Set<Product> products)
   {
      this.products = products;
   }

   /**
    * Get the code.
    * 
    * @return Returns the code as a String.
    */
   @Column(name = "CODE")
   public String getCode()
   {
      return code;
   }

   /**
    * Set the code to the specified value.
    * 
    * @param code The code to set.
    */
   public void setCode(String code)
   {
      this.code = code;
   }
}
