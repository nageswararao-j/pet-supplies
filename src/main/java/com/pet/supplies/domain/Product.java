package com.pet.supplies.domain;

import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @version
 * @author njanjyal //I removed copyrights
 */
@Entity
@Table(name = "PRODUCT")
public class Product
{
   public Product()
   {

   }

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "PRODUCT_ID")
   private Long id;

   @Column(name = "NAME")
   private String name;

   @Column(name = "PRICE")
   private BigDecimal price;

   @Column(name = "CURRENCY")
   private String currency;

   @Column(name = "STATUS")
   private boolean status;

   @Column(name = "QUANTITY")
   private int quantity;

   @Column(name = "DESCRIPTION")
   private String desc;

   @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
   private Set<Image> imageUrls;

   @ManyToOne
   @JoinColumn(name = "CAT_ID")
   private Category category;

   /**
    * Get the id.
    * 
    * @return Returns the id as a Long.
    */
   public Long getId()
   {
      return id;
   }

   /**
    * Set the id to the specified value.
    * 
    * @param id The id to set.
    */
   public void setId(Long id)
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
    * Get the category.
    * 
    * @return Returns the category as a Category.
    */
   public Category getCategory()
   {
      return category;
   }

   /**
    * Set the category to the specified value.
    * 
    * @param category The category to set.
    */
   public void setCategory(Category category)
   {
      this.category = category;
   }

   /**
    * Get the price.
    * 
    * @return Returns the price as a BigDecimal.
    */
   public BigDecimal getPrice()
   {
      return price;
   }

   /**
    * Set the price to the specified value.
    * 
    * @param price The price to set.
    */
   public void setPrice(BigDecimal price)
   {
      this.price = price;
   }

   /**
    * Get the currency.
    * 
    * @return Returns the currency as a String.
    */
   public String getCurrency()
   {
      return currency;
   }

   /**
    * Set the currency to the specified value.
    * 
    * @param currency The currency to set.
    */
   public void setCurrency(String currency)
   {
      this.currency = currency;
   }

   /**
    * Get the status.
    * 
    * @return Returns the status as a boolean.
    */
   public boolean isStatus()
   {
      return status;
   }

   /**
    * Set the status to the specified value.
    * 
    * @param status The status to set.
    */
   public void setStatus(boolean status)
   {
      this.status = status;
   }

   /**
    * Get the quantity.
    * 
    * @return Returns the quantity as a int.
    */
   public int getQuantity()
   {
      return quantity;
   }

   /**
    * Set the quantity to the specified value.
    * 
    * @param quantity The quantity to set.
    */
   public void setQuantity(int quantity)
   {
      this.quantity = quantity;
   }

   /**
    * Get the desc.
    * 
    * @return Returns the desc as a String.
    */
   public String getDesc()
   {
      return desc;
   }

   /**
    * Set the desc to the specified value.
    * 
    * @param desc The desc to set.
    */
   public void setDesc(String desc)
   {
      this.desc = desc;
   }

   /**
    * Get the imageUrls.
    * 
    * @return Returns the imageUrls as a Set<Images>.
    */
   public Set<Image> getImageUrls()
   {
      return imageUrls;
   }

   /**
    * Set the imageUrls to the specified value.
    * 
    * @param imageUrls The imageUrls to set.
    */
   public void setImageUrls(Set<Image> imageUrls)
   {
      this.imageUrls = imageUrls;
   }
}
