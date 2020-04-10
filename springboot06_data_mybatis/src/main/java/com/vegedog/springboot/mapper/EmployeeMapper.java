package com.vegedog.springboot.mapper;

import com.vegedog.springboot.bean.Employee;
import org.springframework.stereotype.Repository;

//@Mapper或者@MapperScan将接口扫描装配到容器中
@Repository
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);
}
