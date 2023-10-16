package net.weg.api.controller;

import net.weg.api.model.Usuario;
import net.weg.api.repository.UsuarioDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    @GetMapping
    public Usuario buscarUsuario(Integer id){
        return usuarioDAO.buscarUm(id);
    }

}
