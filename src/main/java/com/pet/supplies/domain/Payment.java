package com.pet.supplies.domain;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @version
 * @author njanjyal //I removed copyrights
 */
@Entity
@Setter
@Getter
@Table(name = "PAYMENT")
public class Payment
{
   public Payment()
   {

   }

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "PAY_ID")
   private Long payId;

   @Column(name = "CARD_TYPE")
   private String cardType;

   @Column(name = "AMOUNT")
   private BigDecimal amount;

   @Column(name = "CURRENCY")
   private String currency;

   @Column(name = "CARD_NUMBER")
   private String cardNumber;

   @Column(name = "CVV")
   private int cvv;

   @Column(name = "EXPIRY_MONTH")
   private Integer expiryMonth;

   @Column(name = "EXPIRY_YEAR")
   private Integer expiryYear;

   @Column(name = "USER_ID")
   private Long userId;

   @Column(name = "ORDER_ID")
   private Long orderId;

}
