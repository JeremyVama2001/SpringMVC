package com.jeremy.curso.springboot.webapp.springbootweb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jeremy.curso.springboot.webapp.springbootweb.models.dto.ParamDto;
import com.jeremy.curso.springboot.webapp.springbootweb.models.dto.ParamMixDto;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/params")

public class RequestParamsController {

    // Mapping para obtener solo un dato
    @GetMapping("/foo")
    // El required es para quitar el default y evitar errores, el defaultValue es
    // para poner un valor por defecto
    // en el requestParam, name es usado para cambiar el nombre de la variable, algo
    // similiar como un well-knwon
    public ParamDto foo(@RequestParam(required = false, defaultValue = "Hola mundo") String message) {

        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    // Mapping para obtener una cantidad de datos multiples
    @GetMapping("/bar")
    public ParamMixDto bar(@RequestParam String text, @RequestParam Integer code) {
        ParamMixDto params = new ParamMixDto();
        params.setMessage(text);
        params.setCode(code);
        return params;
    }

    @GetMapping("/request")
    public ParamMixDto request(HttpServletRequest request) {
        ParamMixDto params = new ParamMixDto();
        Integer code = 0;
        try {
            code = Integer.parseInt(request.getParameter("code"));
        } catch (NumberFormatException e) {
        }
        params.setCode(code);
        params.setMessage(request.getParameter("message"));
        return params;
    }

}
