package com.example.springbootdocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;
import com.example.modal.User;
import java.util.*;

@RestController
@SpringBootApplication
public class SpringBootDockerApplication {

    static List<User> users = new ArrayList<>();
    static {	
        users.add(new User(1, "tom"));
        users.add(new User(2, "jerry"));
    }

    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id) {
        Optional<User> optional = users.stream().filter(user -> user.id == id).findFirst();
        return optional.orElseThrow();
    }

    @PutMapping("/user/{id}")
    public User updateUserName(@PathVariable int id, @RequestParam String name) {
        Optional<User> optional = users.stream().filter(user -> user.id == id).findFirst();
        optional.ifPresent(user -> {
            user.name = name;
        });
        return optional.orElseThrow();
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDockerApplication.class, args);
	}

}
