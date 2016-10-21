package com.pet.supplies.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @version
 * @author njanjyal //I removed copyrights
 */
@Entity
@Table(name = "IMAGE")
public class Image
{
   @Id
   @GeneratedValue
   @Column(name = "IMG_ID")
   private int img_id;

   @Column(name = "NAME")
   private String name;

   @Column(name = "URL")
   private String url;

   //   private Product product;

   /**
    * Get the img_id.
    * 
    * @return Returns the img_id as a int.
    */
   public int getImg_id()
   {
      return img_id;
   }

   /**
    * Set the img_id to the specified value.
    * 
    * @param img_id The img_id to set.
    */
   public void setImg_id(int img_id)
   {
      this.img_id = img_id;
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
    * Get the url.
    * 
    * @return Returns the url as a String.
    */
   public String getUrl()
   {
      return url;
   }

   /**
    * Set the url to the specified value.
    * 
    * @param url The url to set.
    */
   public void setUrl(String url)
   {
      this.url = url;
   }

   /**
    * Get the product.
    * 
    * @return Returns the product as a Product.
    */
   //   @ManyToOne
   //   @JoinColumn(name = "PRODUCT_ID")
   //   public Product getProduct()
   //   {
   //      return product;
   //   }
   //
   //   /**
   //    * Set the product to the specified value.
   //    * 
   //    * @param product The product to set.
   //    */
   //   public void setProduct(Product product)
   //   {
   //      this.product = product;
   //   }
}
