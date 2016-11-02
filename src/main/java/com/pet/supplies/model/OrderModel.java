package com.pet.supplies.model;

import com.pet.supplies.domain.User;
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
public class OrderModel
{
   private Long orderId;

   private User user;

}
