package com.diffblue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiffBlueController {
@Autowired
DiffBlueServcie diffBlueServcie;
    @GetMapping
    public ResponseEntity validateEmail(String emailId){
        boolean result = diffBlueServcie.validateEmailid(emailId);
        if(result)
        {
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }

    }
}
