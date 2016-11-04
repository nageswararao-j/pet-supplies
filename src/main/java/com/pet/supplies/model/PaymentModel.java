package com.pet.supplies.model;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 * ????
 *
 * @version $Id:$
 * @author njanjyal //I removed copyrights
 */
@Setter
@Getter
public class PaymentModel implements Serializable
{

   /**
    * <code>serialVersionUID</code> indicates/is used for.
    */
   private static final long serialVersionUID = 1L;

   private Long payId;
   private String cardType;
   private BigDecimal amount;
   private String currency;
   private String cardNumber;
   private int cvv;
   private Integer expiryMonth;
   private Integer expiryYear;
   private Long userId;
   private Long orderId;

}
