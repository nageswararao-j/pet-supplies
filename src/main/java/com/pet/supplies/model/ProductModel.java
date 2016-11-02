package com.pet.supplies.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

/**
 * @version
 * @author njanjyal //I removed copyrights
 */
@XmlRootElement
@Getter
@Setter
public class ProductModel implements Serializable
{
   public ProductModel()
   {

   }

   @XmlElement
   private Long productId;

   @XmlElement
   private String productName;

   private BigDecimal price;

   private String currency;

   private boolean status;

   private int quantity;

   private String desc;

   private Set<ImageModel> imageUrls;

}
