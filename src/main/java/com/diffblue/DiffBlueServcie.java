package com.diffblue;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class DiffBlueServcie {
    final String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    boolean validateEmailid( String  emailAddress) {
      return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }
}
