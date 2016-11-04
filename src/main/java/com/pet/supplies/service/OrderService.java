/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: njanjyal
 ** Copyright: (c) Nov 4, 2016 Sogeti Nederland B.V. All Rights Reserved.
 **------------------------------------------------------------------------------
 ** Sogeti Nederland B.V.            |  No part of this file may be reproduced  
 ** Distributed Software Engineering |  or transmitted in any form or by any        
 ** Lange Dreef 17                   |  means, electronic or mechanical, for the      
 ** 4131 NJ Vianen                   |  purpose, without the express written    
 ** The Netherlands                  |  permission of the copyright holder.
 *------------------------------------------------------------------------------
 */
package com.pet.supplies.service;

import com.pet.supplies.model.OrderModel;
import java.util.List;
import java.util.Set;

/**
 * ????
 *
 * @version $Id:$
 * @author njanjyal (c) Nov 4, 2016, Sogeti B.V.
 */
public interface OrderService
{

   /**
    * TODO
    * 
    * @param models
    * @return
    */
   Set<OrderModel> saveOrder(List<OrderModel> models);

}
