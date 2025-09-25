package com.login.controllers;

import com.login.models.dtos.UsuarioDTO;
import com.login.servicies.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    UsuarioService usuarioService;

    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/cadastroUsuario")
    public String cadastro(){
        return "cadastro";
    }

    @RequestMapping(value = "/cadastroUsuario", method = RequestMethod.POST)
    public String cadastroUsuario(@Valid UsuarioDTO usuarioDTO, BindingResult result){
        if (result.hasErrors()){
            return "redirect:/cadastroUsuario";
        }

        usuarioService.save(usuarioDTO);
        return "redirect:/login";
    }

}