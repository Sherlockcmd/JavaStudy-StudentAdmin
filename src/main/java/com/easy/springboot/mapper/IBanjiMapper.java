package com.easy.springboot.mapper;

import com.easy.springboot.pojo.entity.Banji;
import com.easy.springboot.pojo.query.BanjiQuery;
import com.easy.springboot.pojo.vo.BanjiVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IBanjiMapper {
    List<Banji> list(BanjiQuery banjiQuery);

    void add(Banji banji);

    void deleteById(Integer id);

    void deleteAll(Integer[] ids);

    Banji selectById(Integer id);

    void update(Banji banji);

    List<Banji> selectAll();

    List<BanjiVO> selectBanjiCount();
}
