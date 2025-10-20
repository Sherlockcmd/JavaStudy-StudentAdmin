package com.easy.springboot.Service.impl;

import com.easy.springboot.Service.IBanjiService;
import com.easy.springboot.mapper.IBanjiMapper;
import com.easy.springboot.pojo.entity.Banji;
import com.easy.springboot.pojo.query.BanjiQuery;
import com.easy.springboot.pojo.vo.BanjiVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BanjiServiceImpl implements IBanjiService {

    @Autowired
    private IBanjiMapper banjiMapper;

    @Override
    public PageInfo list(BanjiQuery banjiQuery) {

        PageHelper.startPage(banjiQuery.getPage(),banjiQuery.getLimit());
        List<Banji> list = banjiMapper.list(banjiQuery);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public void add(Banji banji) {
        banjiMapper.add(banji);
    }

    @Override
    public void deleteById(Integer id) {
        banjiMapper.deleteById(id);
    }

    @Override
    public void deleteAll(Integer[] ids) {
        banjiMapper.deleteAll(ids);
    }

    @Override
    public Banji selectById(Integer id) {
        return banjiMapper.selectById(id);
    }

    @Override
    public void update(Banji banji) {
         banjiMapper.update(banji);
    }

    @Override
    public List<Banji> selectAll() {
        return banjiMapper.selectAll();
    }

    @Override
    public List<BanjiVO> selectBanjiCount() {
        return banjiMapper.selectBanjiCount();
    }
}
