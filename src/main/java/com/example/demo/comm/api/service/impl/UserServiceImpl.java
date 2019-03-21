package com.example.demo.comm.api.service.impl;

import com.example.demo.comm.api.service.UserService;
import com.example.demo.dal.dao.UserMapper;
import com.example.demo.dal.model.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: UserServiceImpl
 * @Auther: zhengchen
 * @Date: 2019/3/21 16:04
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /** 根据活动口令查询活动信息*/
    public User getByUsername(String userName){
        if (StringUtils.isNotBlank(userName)) {

        }
        return null;
    }

}
