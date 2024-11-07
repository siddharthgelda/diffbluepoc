package com.diffblue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DiffBlueController {
@Autowired
DiffBlueServcie diffBlueServcie;

    @GetMapping
    public ResponseEntity<StatusDTO> validateEmail(@RequestParam("emailId")String emailId){
        boolean result = diffBlueServcie.validateEmailid(emailId);
        if(result)
        {
            return ResponseEntity.ok(new StatusDTO(200,"valid EmailId"));
        }else{
            return ResponseEntity.badRequest().body(new StatusDTO(400,"EmailId not valid"));
        }

    }
}
