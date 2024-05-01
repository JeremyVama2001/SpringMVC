package com.jeremy.curso.springboot.webapp.springbootweb.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeremy.curso.springboot.webapp.springbootweb.models.User;
import com.jeremy.curso.springboot.webapp.springbootweb.models.dto.UserDto;

@RestController
@RequestMapping("/api")
public class UserRestController {
    /*
     * @GetMapping("/details")
     * public Map<String, Object> details() {
     * User user = new User("Jeremy", "Valencia");
     * Map<String, Object> body = new HashMap<>();
     * 
     * body.put("title", "Hola mundo Sping boot");
     * body.put("user", user);
     * 
     * // Regresa la plantilla
     * return body;
     * }
     */
    @GetMapping("/details")
    public UserDto details() {
        UserDto userDto = new UserDto();
        User user = new User("Jeremy", "Valencia");
        userDto.setUser(user);
        userDto.setTitle("Hola mundo Sping boot");

        // Regresa la plantilla
        return userDto;
    }

    @GetMapping("/list")
    public List<User> list() {
        User user = new User("Jeremy", "Valencia");
        User user2 = new User("Monica", "Ramirez");
        User user3 = new User("Eliah", "Valencia");

        List<User> users = Arrays.asList(user, user2, user3);
        // List<User> users = new ArrayList<>();
        // users.add(user);
        // users.add(user2);
        // users.add(user3);

        return users;
    }

}
