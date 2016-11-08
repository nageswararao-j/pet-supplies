package com.pet.supplies.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "AUTHENTICATE_USER")
public class AuthenticateUser
{

   @Id
   @Column(name = "ID")
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   @Column(name = "EMAIL_ID")
   private String emailId;

   @Column(name = "PHONE")
   private String phone;

   @Column(name = "PASSWORD")
   private String password;

   @Column(name = "ACTIVE")
   private boolean active;

   @Column(name = "USER_ID")
   private Long userId;
   
   @Column(name="PROFILE")
   private String profile;
}
