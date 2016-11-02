/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: njanjyal
 ** Copyright: (c) Nov 2, 2016 Sogeti Nederland B.V. All Rights Reserved.
 **------------------------------------------------------------------------------
 ** Sogeti Nederland B.V.            |  No part of this file may be reproduced  
 ** Distributed Software Engineering |  or transmitted in any form or by any        
 ** Lange Dreef 17                   |  means, electronic or mechanical, for the      
 ** 4131 NJ Vianen                   |  purpose, without the express written    
 ** The Netherlands                  |  permission of the copyright holder.
 *------------------------------------------------------------------------------
 */
package com.pet.supplies.exception;

import java.util.Map;

/**
 * ????
 *
 * @version $Id:$
 * @author njanjyal (c) Nov 2, 2016, Sogeti B.V.
 */
public class FunctionalRunTimeException extends RuntimeException
{
   /**
    * <code>serialVersionUID</code> indicates/is used for.
    */
   private static final long serialVersionUID = 1L;

   private Map<String, String> exceptionsMap;

   public FunctionalRunTimeException(String message)
   {
      super(message);
   }

   public FunctionalRunTimeException(String message, Throwable cause)
   {
      super(message, cause);
   }

   public FunctionalRunTimeException(String message, Throwable cause, Map<String, String> exceptionsMap)
   {
      super(message, cause);
      this.exceptionsMap = exceptionsMap;
   }

   public FunctionalRunTimeException(String message, Map<String, String> exceptionsMap)
   {
      super(message);
      this.exceptionsMap = exceptionsMap;
   }

   /**
    * Get the exceptionsMap.
    *
    * @return Returns the exceptionsMap as a Map<String,String>.
    */
   public Map<String, String> getExceptionsMap()
   {
      return exceptionsMap;
   }
}
