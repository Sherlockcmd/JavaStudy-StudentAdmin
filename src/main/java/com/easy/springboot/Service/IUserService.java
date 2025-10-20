package com.easy.springboot.Service;

import com.easy.springboot.pojo.entity.User;
import com.easy.springboot.pojo.query.UserQuery;
import com.github.pagehelper.PageInfo;

public interface IUserService {
     PageInfo list(UserQuery userQuery);

     void add(User user);

     void deleteById(Integer id);

     void deleteAll(Integer[] ids);

     User selectById(Integer id);

     void update(User user);

    User login(User user);
}
