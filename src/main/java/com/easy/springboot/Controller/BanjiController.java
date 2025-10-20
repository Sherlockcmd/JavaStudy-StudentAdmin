package com.easy.springboot.Controller;


import com.easy.springboot.Service.IBanjiService;
import com.easy.springboot.pojo.entity.Banji;
import com.easy.springboot.pojo.query.BanjiQuery;
import com.easy.springboot.util.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banji")
public class BanjiController {

    @Autowired
    private IBanjiService banjiService;

    //Restful    GET(查找)、POST(添加)、DELETE(删除)、PUT(修改)
    //@RequestMapping("/list")
    //@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    //@RequestMapping(value = "/list", method = RequestMethod.GET)

    @GetMapping("/list")
    public Result list(BanjiQuery banjiQuery){
        PageInfo pageInfo = banjiService.list(banjiQuery);
        return Result.ok(pageInfo);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Banji banji){
         banjiService.add(banji);
         return Result.ok("添加成功");
    }

    @DeleteMapping("/deleteById/{id}")
    public Result deleteById(@PathVariable Integer id){
        banjiService.deleteById(id);
        return Result.ok("删除成功");
    }

    @DeleteMapping("/deleteAll/{ids}")
    public Result deleteAll(@PathVariable Integer[] ids){
        banjiService.deleteAll(ids);
        return Result.ok("删除成功");
    }

    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id){
        Banji banji = banjiService.selectById(id);
        return Result.ok(banji);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Banji banji){
        banjiService.update(banji);
        return Result.ok("修改成功");
    }

    @GetMapping("/selectAll")
    public Result selectAll(){
        List<Banji> banji= banjiService.selectAll();

        return Result.ok(banji);
    }








}
