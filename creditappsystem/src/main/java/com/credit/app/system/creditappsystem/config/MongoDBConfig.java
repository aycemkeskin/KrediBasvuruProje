package com.credit.app.system.creditappsystem.config;

import com.credit.app.system.creditappsystem.document.Users;
import com.credit.app.system.creditappsystem.repository.UserRepository;
import com.credit.app.system.creditappsystem.resource.UsersResource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@Configuration
//@ComponentScan(basePackageClasses =UsersResource.class)
public class MongoDBConfig {


    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository){
        return args -> {
            userRepository.save(new Users(11111111111L,"aycem","keskin",4000,"125",600,0));
            userRepository.save(new Users(22222222222L,"kemal","purali",7000,"125",5,0));
            userRepository.save(new Users(33333333333L,"deniz","ergen",8000,"125",1000,0));
            userRepository.save(new Users(44444444444L,"gözde","selvi",8000,"125",1000,0));

        };
    }
    
    @Autowired
	private UserRepository userRepository;
  //Create operation
  	public Users create(Integer id, String name, String surname, Integer salary, String phonenum, Integer credit_score, Integer limit) {
  		return userRepository.save(new Users(id, name, surname, salary, phonenum, credit_score,limit));
  	}
  	//Retrieve operation
  	public List<Users> getAll(){
  		return userRepository.findAll();
  	}
  	public Users getByname(String name) {
  		return userRepository.findByname(name);
  	}
  	//Update operation
  	public Users update(Integer id, String name, String surname, Integer salary, Integer phonenum, Integer credit_score,Integer limit) {
  		Users p = userRepository.findByname(name);
  		p.setSurname(surname);
  		return userRepository.save(p);
  	}
  	//Delete operation
  	public void deleteAll() {
  		userRepository.deleteAll();
  	}
  	public void delete(String name) {
  		Users p = userRepository.findByname(name);
  		userRepository.delete(p);
  	}
    
    
    
}
