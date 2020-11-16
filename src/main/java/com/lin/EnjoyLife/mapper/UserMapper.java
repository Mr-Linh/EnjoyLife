package com.lin.EnjoyLife.mapper;

import com.lin.EnjoyLife.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    List<User> queryUserList();

    User queryUserById(Integer id);

    Integer addUser(User user);

    Integer updateUser(User user);
}
