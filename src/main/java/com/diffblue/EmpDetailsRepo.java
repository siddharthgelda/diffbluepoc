package com.diffblue;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpDetailsRepo {
    public List<EmpDTO> getEmps() {
        List<EmpDTO> empDTOS = new ArrayList<>();
        empDTOS.add(new EmpDTO(1, "Ravi", "API Tech"));
        empDTOS.add(new EmpDTO(2, "Kavi", "DevOps"));
        empDTOS.add(new EmpDTO(3, "Javed", "INFRA"));
        empDTOS.add(new EmpDTO(4, "Prag", "BMB"));
        return empDTOS;
    }
}
