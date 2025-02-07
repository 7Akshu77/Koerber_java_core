package com.empapp.serviceproxy;

import com.empapp.dto.Department;
import org.apache.naming.factory.webservices.ServiceProxy;
import org.springframework.stereotype.Component;

@Component
public class EmpFallBack implements DeptServiceProxy {
    @Override
    public Department getByName(String name) {
        return new Department(0,"NA","NA");
    }
}
