package com.example.demo.comm.api.service;

import com.example.demo.dal.model.User;

/**
 * @ClassName: loginUser
 * @Auther: zhengchen
 * @Date: 2019/3/21 16:02
 * @Description:
 */
public interface UserService {

    User getByUsername(String userName);
}
