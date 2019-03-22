package com.example.demo.dal.dao;

import com.example.demo.dal.model.Todo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {

    Boolean addTodo(Todo todo);

    Boolean updateTitle(String title, Integer todoId);

    List<Todo> getAllTodoList(Long userId);

    Boolean deleteTodo(Integer todoId);
}
