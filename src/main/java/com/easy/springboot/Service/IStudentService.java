package com.easy.springboot.Service;

import com.easy.springboot.pojo.entity.Student;
import com.easy.springboot.pojo.query.StudentQuery;
import com.github.pagehelper.PageInfo;

public interface IStudentService {
     PageInfo list(StudentQuery studentQuery);

     void add(Student student);

     void deleteById(Integer id);

     void deleteAll(Integer[] ids);

     Student selectById(Integer id);

     void update(Student student);
}
