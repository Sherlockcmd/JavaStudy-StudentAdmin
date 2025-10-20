package com.easy.springboot.Service.impl;

import com.easy.springboot.Service.IStudentService;
import com.easy.springboot.mapper.IStudentMapper;
import com.easy.springboot.pojo.entity.Student;
import com.easy.springboot.pojo.query.StudentQuery;
import com.easy.springboot.pojo.vo.StudentVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentMapper studentMapper;

    @Override
    public PageInfo list(StudentQuery studentQuery) {

        PageHelper.startPage(studentQuery.getPage(),studentQuery.getLimit());
        List<StudentVO> list = studentMapper.list(studentQuery);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public void add(Student student) {
        studentMapper.add(student);
    }

    @Override
    public void deleteById(Integer id) {
        studentMapper.deleteById(id);
    }

    @Override
    public void deleteAll(Integer[] ids) {
        studentMapper.deleteAll(ids);
    }

    @Override
    public Student selectById(Integer id) {
        return studentMapper.selectById(id);
    }

    @Override
    public void update(Student student) {
         studentMapper.update(student);
    }
}
