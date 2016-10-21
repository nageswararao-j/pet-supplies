package com.pet.supplies.model;

import java.io.Serializable;
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
public class ProductsModel implements Serializable
{
   public ProductsModel()
   {

   }

   @XmlElement
   private Long productId;

   @XmlElement
   private String productName;
}
