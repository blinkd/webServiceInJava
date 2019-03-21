package com.example.demo;

import com.example.demo.dal.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.AuthorSettings;

@Controller
@SpringBootApplication
public class DemoApplication {


    @Value("${book.author}")
    private String bookAuthor;

    @Value("${book.name}")
    private String bookName;

    @Autowired
    private AuthorSettings authorSettings;

    @RequestMapping("/")
    String Index(Model model) {
        // return "book name is " + bookName + "book author is " + bookAuthor + "Hello Spring Boot"
        //         + " author name " + authorSettings.getName() + " author age " + authorSettings.getAge();
        User userModel = new User();
        model.addAttribute("username", userModel.getUserName());
        model.addAttribute("message", "");
        return "login";
    }



    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
