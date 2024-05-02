package com.jeremy.curso.springboot.webapp.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({ "", "/", "/home" })
    public String home() {
        /**
         * Foward vs Redirect
         * EL fowars se mantiene dentro de la misma peticion HTTP y no pierdes
         * paramentros
         * que tienes dentro del request, tampoco cambia la ruta URL, ya que no hace un
         * refresh a la pagina,
         * sino que despacha a otra accion del controlador, pero sin recargar la pagina,
         * mientras
         * que el redirect cambia la ruta de todos los paramentros del request que
         * teniamos antes de
         * redirect
         */
        return "redirect:/details";
        // return "foward:/list";

    }

}
