package com.credit.app.system.creditappsystem.resource;

import com.credit.app.system.creditappsystem.document.Users;
import com.credit.app.system.creditappsystem.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping("/addUserss")
public class UsersResource {

    public static UserRepository userRepository;
    
    
    public UsersResource(UserRepository userRepository){
        this.userRepository = userRepository;
    } 
    
    //GET
    @GetMapping("/all")
    public List<Users> getAll(){
        return userRepository.findAll();
    }
    
    /////GET IDye gore
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Users> getPetById(@PathVariable("id") Long id) {
    //	System.out.println((userRepository.findById(id)).get().getCredit_score());
      return userRepository.findById(id);
    }
    

    //PUT
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyUsersById(@PathVariable("id") Long id, @Valid @RequestBody Users users) {
      users.setId(id);
      userRepository.save(users);
    }
    
    //POST
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Users createUser(@Valid @RequestBody Users users) {
      //users.setId(id);
      userRepository.save(users);
      return users;
    }
    
    //DELETE
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id) {
    	userRepository.delete(userRepository.findByid(id));
    }
}
