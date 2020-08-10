package com.credit.app.system.creditappsystem.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.credit.app.system.creditappsystem.document.Users;
import com.credit.app.system.creditappsystem.repository.UserRepository;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import credit_process.*;
 
@Controller
public class MvcController {
     
    @RequestMapping("/")
    public String home() {
        System.out.println("Going home...");
        return "index";
    }
   
    
    @GetMapping("/register2")
    public String showForm2(Model model) {
    	System.out.println("Going home2...");
        Users user = new Users();         
        model.addAttribute("user", user);
    
        return "krediform";

    }
    
   
    @PostMapping("/register2")
    public String submitForm(@ModelAttribute("user") Users user) {

    	int a=0;
    	System.out.println(user);
        System.out.println(user.getId());
        a= CreditProcess.myProcess(user);    
        
        String page;
        page ="";
        
       if(a==0) {
    	   page= "form_red";
    	   
       }
       else if(a==1) {
    	   page= "form_success";
       }

       return page;
    }
       
}