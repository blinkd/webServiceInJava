package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @ClassName: AuthorSettings
 * @Auther: zhengchen
 * @Date: 2019/3/20 21:13
 * @Description:
 */

@Component
@PropertySource("classpath:config.properties")
@ConfigurationProperties(prefix="author")
public class AuthorSettings {

    private String name;

    private Long age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
