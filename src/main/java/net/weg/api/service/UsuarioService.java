package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.Usuario;
import net.weg.api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private CarroService carroService;

    public void salvar(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public Usuario buscarUm(Integer id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        Usuario usuario = usuarioOptional.get();

        return usuario;
    }

    public Collection<Usuario> buscarTodos() {
        Collection<Usuario> usuarios = usuarioRepository.findAll();

        return usuarios;
    }

    public void deletar(@RequestParam Integer id) {
        usuarioRepository.deleteById(id);
    }

}
