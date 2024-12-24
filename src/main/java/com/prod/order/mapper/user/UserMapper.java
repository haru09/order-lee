package com.prod.order.mapper.user;

import com.prod.order.model.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface UserMapper {

    User findByUsername(@Param("username") String username);

}