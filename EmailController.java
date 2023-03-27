
package com.example.controller;

import com.example.Model.Email;
import com.example.service.EmailService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@Controller
public class EmailController {
    
    @Autowired
    private EmailService emailService;
    
  // @RequestMapping(method=RequestMethod.GET)
   @GetMapping("/")
   public String index(ModelMap modelMap ){
       
       return "index";
   }
   
   @PostMapping("/sendMail")
   public String sendMail(@ModelAttribute Email email,HttpSession session)
   {
       emailService.sendMail(email);
       
       session.setAttribute("msg","Email send Sucessfully");
  
       return "redirect:/";
   }
   
    }
    
