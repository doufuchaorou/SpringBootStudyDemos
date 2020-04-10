package com.vegedog.springboot.mapper;

import com.vegedog.springboot.bean.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

//指定这是一个操作数据库的mapper
@Repository
//@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

}
