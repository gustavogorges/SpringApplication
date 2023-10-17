package net.weg.api.service;

import net.weg.api.model.Usuario;
import net.weg.api.repository.CarroDAO;
import net.weg.api.repository.UsuarioDAO;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UsuarioService {

    private UsuarioDAO usuarioDAO;
    private CarroDAO carroDAO;

    public UsuarioService() {
        this.usuarioDAO = new UsuarioDAO();
        this.carroDAO = new CarroDAO();
    }

    public void inserir(Usuario usuario){
        try {
            carroDAO.buscarUm(usuario.getCarro().getId());
        } catch (NoSuchElementException e) {
            carroDAO.inserir(usuario.getCarro());
        }
        usuarioDAO.inserir(usuario);
    }
}
