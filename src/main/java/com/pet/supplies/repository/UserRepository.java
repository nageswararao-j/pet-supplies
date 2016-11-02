package com.pet.supplies.repository;

import com.pet.supplies.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * ????
 *
 * @version $Id:$
 * @author njanjyal //I removed copyrights
 */
public interface UserRepository extends CrudRepository<User, Long>
{
   @Query("from User user where user.userId=:userId")
   public User findOne(@Param("userId") Long userId);
}