
package com.example.service;

import com.example.Model.Email;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    
    @Autowired
    private JavaMailSender javaMailSender;
    
    public void sendMail(Email em)
    {
        
        try{
          
           MimeMessage message= javaMailSender.createMimeMessage();
           MimeMessageHelper helper=new MimeMessageHelper(message);
         
           helper.setFrom("nandkishorasambe98@gmail.com");
           helper.setTo(em.getTo());
           helper.setSubject(em.getSubject());
           helper.setText(em.getMessage());
           
           javaMailSender.send(message);
        
        }catch(Exception e){
            e.printStackTrace();
            
        }
    }
}
