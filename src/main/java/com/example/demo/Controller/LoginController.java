package com.example.demo.Controller;

import com.example.demo.dal.dao.UserMapper;
import com.example.demo.dal.model.User;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName: LoginController
 * @Auther: zhengchen
 * @Date: 2019/3/21 11:06
 * @Description:
 */
@Controller
public class LoginController {

    @Autowired
    UserMapper userMapper;

    private final static Logger logger= LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String hello(String username, String password, Model userModel) {
        logger.info("username:{}", username);
        logger.info("password:{}", password);

        String message = "";
        User loginUser = userMapper.getByUserName(username);
        if (loginUser != null) {
            username = loginUser.getUserName();
            message = "登录成功";
        } else {
            username = "";
            message = "用户名或密码错误";
        }


        userModel.addAttribute("username",username);
        userModel.addAttribute("message", message);
        return "login";

        // return String.format("mapping url is /login/user/%s", username);
    }

}
