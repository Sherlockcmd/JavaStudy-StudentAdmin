package com.easy.springboot.mapper;

import com.easy.springboot.pojo.entity.Student;
import com.easy.springboot.pojo.query.StudentQuery;
import com.easy.springboot.pojo.vo.StudentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IStudentMapper {
    List<StudentVO> list(StudentQuery studentQuery);

    void add(Student student);

    void deleteById(Integer id);

    void deleteAll(Integer[] ids);

    Student selectById(Integer id);

    void update(Student student);
}
