package com.diffblue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class DiffBlueServcie {
    @Autowired
    EmpDetailsRepo empDetailsRepo;
    final String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    boolean validateEmailid(String emailAddress) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

    public EmpDTO getEmpDetails(int id) {
        return empDetailsRepo.getEmps().stream().filter(emp -> emp.id == id).findAny().get();
    }
    public int add(String one,String two)
    {
        int a=Integer.parseInt(one);
        int b= Integer.parseInt(two);
        return a+b;
    }
}
