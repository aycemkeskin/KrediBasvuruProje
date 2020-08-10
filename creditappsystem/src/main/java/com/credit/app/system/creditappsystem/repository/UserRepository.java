package com.credit.app.system.creditappsystem.repository;

import com.credit.app.system.creditappsystem.document.Users;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<Users,Long> {
	
	Users findByid(long id);
	Users findByname(String name);
	Users findBysurname(String surname);
	Users findByphonenum(Integer phonenum);
	
	
}
