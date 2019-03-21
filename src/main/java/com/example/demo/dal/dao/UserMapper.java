package com.example.demo.dal.dao;

import com.example.demo.dal.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User getByUserName(String userName);

    User getByUserId(String id);

}
