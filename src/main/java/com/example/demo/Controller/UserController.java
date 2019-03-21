package com.example.demo.Controller;

import org.springframework.ui.Model;

import com.example.demo.dal.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @ClassName: UserController
 * @Auther: zhengchen
 * @Date: 2019/3/21 09:38
 * @Description:
 */

// @RestController

@Controller
@RequestMapping("/usertest")
public class UserController {

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
}
