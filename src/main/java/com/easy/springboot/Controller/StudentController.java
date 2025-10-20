package com.easy.springboot.Controller;


import com.easy.springboot.Service.IStudentService;
import com.easy.springboot.pojo.entity.Student;
import com.easy.springboot.pojo.query.StudentQuery;
import com.easy.springboot.util.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    //Restful    GET(查找)、POST(添加)、DELETE(删除)、PUT(修改)
    //@RequestMapping("/list")
    //@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    //@RequestMapping(value = "/list", method = RequestMethod.GET)

    @GetMapping("/list")
    public Result list(StudentQuery studentQuery){
        PageInfo pageInfo = studentService.list(studentQuery);
        return Result.ok(pageInfo);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Student student){
         studentService.add(student);
         return Result.ok("添加成功");
    }

    @DeleteMapping("/deleteById/{id}")
    public Result deleteById(@PathVariable Integer id){
        studentService.deleteById(id);
        return Result.ok("删除成功");
    }

    @DeleteMapping("/deleteAll/{ids}")
    public Result deleteAll(@PathVariable Integer[] ids){
        studentService.deleteAll(ids);
        return Result.ok("删除成功");
    }

    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id){
        Student student = studentService.selectById(id);
        return Result.ok(student);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Student student){
        studentService.update(student);
        return Result.ok("修改成功");
    }









}
