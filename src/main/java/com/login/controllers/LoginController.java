package com.login.controllers;

import com.login.models.dtos.UsuarioDTO;
import com.login.models.dtos.UsuarioLoginDTO;
import com.login.models.entities.Usuario;
import com.login.repositories.UsuarioRepository;
import com.login.servicies.UsuarioService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    UsuarioService usuarioService;
    UsuarioRepository usuarioRepository;

    public LoginController(UsuarioService usuarioService, UsuarioRepository usuarioRepository) {
        this.usuarioService = usuarioService;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/")
    public String paginaPrincipal(){
        return "index";
    }

    @PostMapping("/logar")
    public String loginUsuario(@ModelAttribute UsuarioLoginDTO dto, Model model, HttpServletResponse response){
        System.out.println("Tentando logar com: " + dto.nome() + " - " + dto.senha());

        Usuario usuarioLogado = usuarioRepository.login(dto.nome(), dto.senha());
        if (usuarioLogado != null){
            return "redirect:/";
        }

        model.addAttribute("erroLogin", "Nome ou senha inválido");
        return "login";
    }

    @GetMapping("/cadastroUsuario")
    public String cadastro(){
        return "cadastro";
    }

    @RequestMapping(value = "/cadastroUsuario", method = RequestMethod.POST)
    public String cadastroUsuario(@Valid UsuarioDTO dto, BindingResult result){
        if (result.hasErrors()){
            return "redirect:/cadastroUsuario";
        }

        usuarioService.save(dto);
        return "redirect:/login";
    }

}