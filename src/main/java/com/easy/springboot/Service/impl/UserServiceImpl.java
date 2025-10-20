package com.easy.springboot.Service.impl;

import com.easy.springboot.Service.IUserService;
import com.easy.springboot.mapper.IUserMapper;
import com.easy.springboot.pojo.entity.User;
import com.easy.springboot.pojo.query.UserQuery;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserMapper userMapper;

    @Override
    public PageInfo list(UserQuery userQuery) {

        PageHelper.startPage(userQuery.getPage(),userQuery.getLimit());
        List<User> list = userMapper.list(userQuery);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public void add(User user) {
        userMapper.add(user);
    }

    @Override
    public void deleteById(Integer id) {
        userMapper.deleteById(id);
    }

    @Override
    public void deleteAll(Integer[] ids) {
        userMapper.deleteAll(ids);
    }

    @Override
    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public void update(User user) {
         userMapper.update(user);
    }

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }
}
