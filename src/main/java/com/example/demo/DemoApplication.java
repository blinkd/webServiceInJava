package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.AuthorSettings;

@RestController
@SpringBootApplication
public class DemoApplication {


    @Value("${book.author}")
    private String bookAuthor;

    @Value("${book.name}")
    private String bookName;

    @Autowired
    private AuthorSettings authorSettings;

    @RequestMapping("/")
    String Index() {
        return "book name is " + bookName + "book author is " + bookAuthor + "Hello Spring Boot"
                + " author name " + authorSettings.getName() + " author age " + authorSettings.getAge();
    }



    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
