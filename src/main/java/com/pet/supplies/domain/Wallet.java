package com.pet.supplies.domain;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * ????
 *
 * @version $Id:$
 * @author njanjyal //I removed copyrights
 */
@Entity
@Setter
@Getter
@Table(name = "WALLET")
public class Wallet
{

   @Id
   @Column(name = "WALLET_ID")
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long walletId;

   @Column(name = "AMOUNT")
   private BigDecimal amount;

   @Column(name = "CURRENCY")
   private String curency;

   @OneToOne
   @JoinColumn(name = "USER_ID")
   private User user;

}
