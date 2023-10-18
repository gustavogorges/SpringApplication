package net.weg.api.service;

import net.weg.api.model.Usuario;
import net.weg.api.repository.CarroDAO;
import net.weg.api.repository.UsuarioDAO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.NoSuchElementException;

@Service
public class UsuarioService {

    private UsuarioDAO usuarioDAO;
    private CarroService carroService;

    public UsuarioService() {
        this.usuarioDAO = new UsuarioDAO();
        this.carroService = new CarroService();
    }

    public void inserir(Usuario usuario){
        try {
            carroService.buscarUm(usuario.getCarro().getId());
        } catch (NoSuchElementException e) {
            carroService.inserir(usuario.getCarro());
        }
        usuarioDAO.inserir(usuario);
    }

    public Usuario buscarUm(Integer id) {
        Usuario usuario = usuarioDAO.buscarUm(id);
        try {
            usuario.setCarro(carroService.buscarUm(usuario.getCarro().getId()));
        }catch (Exception ignore) {

        }
        return usuario;
    }

    public Collection<Usuario> buscarTodos() {
        Collection<Usuario> usuarios = usuarioDAO.buscarTodos();
        try {
            for (Usuario usuarioFor: usuarios) {
                usuarioFor.setCarro(carroService.buscarUm(usuarioFor.getCarro().getId()));
            }
        }catch (Exception ignore) {

        }
        return usuarios;
    }

    public void deletar(@RequestParam Integer id) {
        usuarioDAO.deletar(id);
    }

    public void atualizar(Usuario usuario) {
        try {
            carroService.buscarUm(usuario.getCarro().getId());
        } catch (NoSuchElementException e) {
            carroService.inserir(usuario.getCarro());
        }
        usuarioDAO.atualizar(usuario);
    }
}
