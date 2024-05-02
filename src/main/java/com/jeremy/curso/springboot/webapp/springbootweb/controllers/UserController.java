package com.jeremy.curso.springboot.webapp.springbootweb.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.jeremy.curso.springboot.webapp.springbootweb.models.User;

@Controller // Es importante e indica lo que es, en este caso que es un controlador

public class UserController {
    // Maneja metodos handler, viene de manejar peticiones de un usuario
    @GetMapping("/details")

    // Class using Map for show information with controller on template HTML
    /**
     * public String details(Map<String, Object> model) {
     * model.put("title", "Hola mundo Sping boot");
     * model.put("name", "Jeremy");
     * model.put("lastName", "Valencia");
     * 
     * // Regresa la plantilla
     * return "details";
     * }
     */
    // Class using Model for show information with controller on template HTML
    public String details(Model model) {
        User user = new User("Jeremy", "Valencia");
        user.setEmail("jeremyvalencia@gmail.com");
        model.addAttribute("title", "Hola mundo Spring boot");
        model.addAttribute("user", user);

        // Regresa la plantilla
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {
        // Esta es la manera de hacerlo si solo se maneja en un metodo, sin necesidad de
        // reutlizar la informacion
        /**
         * List<User> users = Arrays.asList(
         * new User("Eliah", "Valencia"),
         * new User("Ainhoa", "Ramirez", "ainhoa@gmail.com"),
         * new User("Jeremy", "Valencia"),
         * new User("Monica", "Ramirez", "monica@gmail.com"));
         * 
         * model.addAttribute("users", users);
         */
        model.addAttribute("title", "Listado de usuarios");
        return "list";
    }

    // El nombre del arreglo o variable que estamos pasando al template
    // Pasar datos a la vista que sean en comun
    @ModelAttribute("users")
    public List<User> userModel() {
        List<User> users = Arrays.asList(
                new User("Eliah", "Valencia"),
                new User("Ainhoa", "Ramirez", "ainhoa@gmail.com"),
                new User("Jeremy", "Valencia"),
                new User("Monica", "Ramirez", "monica@gmail.com"));
        return users;

    }
}
