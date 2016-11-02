package com.pet.supplies.domain;

import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "USER")
public class User
{
   @Id
   @Column(name = "USER_ID")
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long userId;

   @Column(name = "NAME")
   private String name;

   private transient String emailId;

   private transient String phone;

   private transient String password;

   @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   private Set<CartItem> cartItems;

   @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   private List<Address> addresses;

   @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
   private List<Order> orders;

   @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   private Wallet wallet;

   public User()
   {

   }
}
