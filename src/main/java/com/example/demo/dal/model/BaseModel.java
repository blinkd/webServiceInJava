package com.example.demo.dal.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @ClassName: BaseModel
 * @Auther: zhengchen
 * @Date: 2019/3/21 10:14
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = false)
public abstract class BaseModel {
    /**
     * 创建时间
     */
    private Date createTime;


    private Date updateTime;

    /**版本号*/
    private Integer szVersion;
    /**
     * 获取主键值
     * @return 主键值
     */
    public abstract Long getPrimaryKey();
}
