package com.empapp.serviceproxy;

import com.empapp.dto.Department;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name="deptapp",fallback = EmpFallBack.class)
public interface DeptServiceProxy {

    @GetMapping("departments/{name}")
    public Department getByName(@PathVariable String name);

}

