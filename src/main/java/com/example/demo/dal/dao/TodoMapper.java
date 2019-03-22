package com.example.demo.dal.dao;

import com.example.demo.dal.model.Todo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {

    Boolean addTodo(Todo todo);

    Boolean updateTitle(Todo todo);

    List<Todo> getAllTodoList(Long userId);

    Todo getByTodoId(Long todoId);

    Boolean deleteTodo(Long todoId);
}
