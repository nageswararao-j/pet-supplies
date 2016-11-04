package com.pet.supplies.repository;

import com.pet.supplies.domain.AuthenticateUser;
import com.pet.supplies.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * ????
 *
 * @version $Id:$
 * @author njanjyal //I removed copyrights
 */
@Repository
public interface LoginRepository extends CrudRepository<User, Long>
{

   @Query("from AuthenticateUser authUser where authUser.emailId=:emailId and authUser.password=:password")
   public AuthenticateUser authenticateUser(@Param("emailId") String emailId, @Param("password") String password);

}
