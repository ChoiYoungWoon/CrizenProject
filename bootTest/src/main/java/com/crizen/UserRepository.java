package com.crizen;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository("userDao")
public interface UserRepository extends CrudRepository<User, Long> {

	
	

}
