package com.easy.springboot.Service;

import com.easy.springboot.pojo.entity.Banji;
import com.easy.springboot.pojo.query.BanjiQuery;
import com.easy.springboot.pojo.vo.BanjiVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IBanjiService {
     PageInfo list(BanjiQuery banjiQuery);

     void add(Banji banji);

     void deleteById(Integer id);

     void deleteAll(Integer[] ids);

     Banji selectById(Integer id);

     void update(Banji banji);

     List<Banji> selectAll();

     List<BanjiVO> selectBanjiCount();

}
