package com.example.demo.dal.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.swing.border.TitledBorder;

/**
 * @ClassName: Todo
 * @Auther: zhengchen
 * @Date: 2019/3/22 09:04
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Todo extends BaseModel {
    /**
     * 主键id
     */
    private Long id;

    /**
     * title
     */
    private String title;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户id
     */
    private Integer status;

    public Todo() {}

    public Todo(String title) {
        this.title = title;
    }

    public Todo(String title, Long userId){
        this.title = title;
        this.userId = userId;
    }

    public Long getPrimaryKey() {
        return id;
    }

}
