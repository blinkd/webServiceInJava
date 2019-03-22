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


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editTodo(@PathVariable String id, Model modelMap) {
        Long todoId = Long.valueOf(id);
        Todo todo = todoMapper.getByTodoId(todoId);
        modelMap.addAttribute("todo", todo);
        return "todo_edit";
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(String id, String title, Model modelMap) {
        logger.info("id:<{}>  title:<{}>", id, title);

        Long todoId = Long.valueOf(id);
        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setId(todoId);
        todoMapper.updateTitle(todo);

        Todo originTodo = todoMapper.getByTodoId(todoId);
        User user = userMapper.getByUserId(originTodo.getUserId());

        return searchTodoByUserId(user, modelMap);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteTodo(@PathVariable String id, Model modelMap) {

        Long todoId = Long.valueOf(id);
        Todo todo = todoMapper.getByTodoId(todoId);
        boolean deleteResult = todoMapper.deleteTodo(todoId);

        if (deleteResult) {
            User user = userMapper.getByUserId(todo.getUserId());
            return searchTodoByUserId(user, modelMap);
        } else {
            return "login";
        }
    }


    private String searchTodoByUserId(User currentUser, Model modelMap) {
        if (currentUser != null) {
            List<Todo> todoList = todoMapper.getAllTodoList(currentUser.getId());
            modelMap.addAttribute("todoList", todoList);
            modelMap.addAttribute("user", currentUser);
            return "todo_index";
        } else {
            return "login";
        }

    }


}
