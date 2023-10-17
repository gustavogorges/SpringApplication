package net.weg.api.controller;

import net.weg.api.model.Usuario;
import net.weg.api.repository.UsuarioDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    @GetMapping("/{id}")
    public Usuario buscarUsuario(@PathVariable Integer id){
        return usuarioDAO.buscarUm(id);
    }

    @GetMapping()
    public Collection<Usuario> buscarTodos(){
        return usuarioDAO.buscarTodos();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        usuarioDAO.deletar(id);
    }

    @PostMapping()
    public void inserir(@RequestBody Usuario usuario){
        usuarioDAO.inserir(usuario);
    }

    @PutMapping
    public void atualizar(@RequestBody Usuario usuario) {
        usuarioDAO.atualizar(usuario);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable Integer id,@RequestBody Usuario usuario) {
        usuarioDAO.atualizar(usuario);
    }


}
