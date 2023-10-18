package net.weg.api.controller;

import net.weg.api.model.Usuario;
import net.weg.api.repository.UsuarioDAO;
import net.weg.api.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

//    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{id}")
    public Usuario buscarUsuario(@PathVariable Integer id){
        return usuarioService.buscarUm(id);
    }

    @GetMapping()
    public Collection<Usuario> buscarTodos(){
        return usuarioService.buscarTodos();
    }

    @DeleteMapping
    public void deletar(@RequestParam("value") Integer id) {
        usuarioService.deletar(id);
    }

    @PostMapping()
    public void inserir(@RequestBody Usuario usuario){
        usuarioService.inserir(usuario);
    }

    @PutMapping
    public void atualizar(@RequestBody Usuario usuario) {
        usuarioService.atualizar(usuario);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable Integer id,@RequestBody Usuario usuario) {
        usuarioService.atualizar(usuario);
    }


}
