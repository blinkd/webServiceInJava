package com.example.demo.Controller;

import com.example.demo.dal.dao.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import org.apache.commons.lang3.StringUtils.*;
import com.example.demo.dal.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin2.message.Message;


/**
 * @ClassName: UserController
 * @Auther: zhengchen
 * @Date: 2019/3/21 09:38
 * @Description:
 */

@Controller
public class UserController {

    @Autowired
    UserMapper userMapper;


    @RequestMapping(value = "/username/{username}", method = RequestMethod.GET)
    public String hello(@PathVariable("username") String username, Model userModel) {
        userModel.addAttribute("name",username);
        return "hello";
        // return String.format("mapping url is /login/user/%s", username);
    }

    @RequestMapping(value = "/userid/{id}", method = RequestMethod.GET)
    public String method(@PathVariable("id") Integer id) {
        return String.format("mapping url is /login/user/%s", id);
    }



    private final static Logger logger= LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password, Model userModel) {

        String message = "";
        User loginUser = userMapper.getByUserName(username);
        if (loginUser != null) {
            userModel.addAttribute("username",username);
            return "index";

        } else {
            username = "";
            message = "用户名或密码错误";
        }
        userModel.addAttribute("username",username);
        userModel.addAttribute("message", message);
        return "login";
    }


    @RequestMapping("/register")
    public String register(String username, String password, Model userModel) {
        User user = new User(username,password);


        String message = "";
        if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
            if (validateRegister(username, password)) {
                boolean isSuccess = userMapper.insertUser(user);

                if (isSuccess) {
                    userModel.addAttribute("username", username);
                    return "index";
                } else {
                    message = "注册失败";
                }

            } else {
                message = "用户名或者密码长度必须大于2";
            }
        } else {
            message = "请输入用户名及密码";
        }

        userModel.addAttribute("message",message);
        return "register";
    }

    private boolean validateRegister(String userName, String passWord) {
        return userName.length() > 2 && passWord.length() > 2;
    }

}
