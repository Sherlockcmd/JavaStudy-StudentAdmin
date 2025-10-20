package com.easy.springboot.mapper;

import com.easy.springboot.pojo.entity.User;
import com.easy.springboot.pojo.query.UserQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IUserMapper {
    List<User> list(UserQuery userQuery);

    void add(User user);

    void deleteById(Integer id);

    void deleteAll(Integer[] ids);

    User selectById(Integer id);

    void update(User user);

    User login(User user);
}
