package com.easy.springboot.Controller;


import com.easy.springboot.Service.IBanjiService;
import com.easy.springboot.pojo.vo.BanjiVO;
import com.easy.springboot.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chart")
public class ChartController {

    @Autowired
    private IBanjiService banjiService;


    @GetMapping("/selectBanjiCount")
    public Result selectBanjiCount(){
       List<BanjiVO> list = banjiService.selectBanjiCount();
        return Result.ok(list);
    }
}
