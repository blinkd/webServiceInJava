package com.example.demo.dal.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName: User
 * @Auther: zhengchen
 * @Date: 2019/3/21 10:12
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User extends BaseModel {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String passWord;

    public User() {
        this.userName = "";
    }

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
        this.szVersion = 1;
    }

    public Long getPrimaryKey() {
        return id;
    }

}
