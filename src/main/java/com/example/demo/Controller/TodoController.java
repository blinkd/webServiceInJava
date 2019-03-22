package com.example.demo.Controller;

import com.example.demo.dal.dao.TodoMapper;
import com.example.demo.dal.dao.UserMapper;
import com.example.demo.dal.model.Todo;
import com.example.demo.dal.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: TodoController
 * @Auther: zhengchen
 * @Date: 2019/3/22 09:28
 * @Description:
 */

@Controller
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoMapper todoMapper;

    @Autowired
    private UserMapper userMapper;

    private final static Logger logger= LoggerFactory.getLogger(TodoController.class);

    @RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
    public String getTodoIndex(@PathVariable String id, Model modelMap) {
        logger.info("todoIndex--- user_id :{}", id);
        Long userId = Long.valueOf(id);
        User currentUser = userMapper.getByUserId(userId);
        return searchTodoByUserId(currentUser, modelMap);

    }

    @RequestMapping(value = "/add/{id}", method = RequestMethod.POST)
    public String addTodo(@PathVariable String id, String title, Model modelMap) {
        logger.info("todoIndex--- user_id :{}", id);
        Long userId = Long.valueOf(id);
        User currentUser = userMapper.getByUserId(userId);
        Todo todo = new Todo(title, userId);
        todoMapper.addTodo(todo);
        return searchTodoByUserId(currentUser, modelMap);

    }



    private String searchTodoByUserId(User currentUser, Model modelMap) {
        if (currentUser != null) {
            List<Todo> todoList = todoMapper.getAllTodoList(currentUser.getId());
            logger.info("todoList:{}", todoList.toString());


            modelMap.addAttribute("todoList", todoList);
            modelMap.addAttribute("user", currentUser);
            return "todo_index";
        } else {
            return "login";
        }

    }


}
