package net.weg.api.service;

import net.weg.api.model.Carro;
import net.weg.api.model.Usuario;
import net.weg.api.repository.CarroDAO;
import net.weg.api.repository.UsuarioDAO;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.NoSuchElementException;

@Service
public class CarroService {

    private CarroDAO carroDAO;

    public CarroService() {
        this.carroDAO = new CarroDAO();
    }

    public void inserir(Carro carro){
        carroDAO.inserir(carro);
    }

    public Carro buscarUm(Integer id) {
        return carroDAO.buscarUm(id);
    }

    public Collection<Carro> buscarTodos() {
        return carroDAO.buscarTodos();
    }

    public void deletar(Integer id) {
        carroDAO.deletar(id);
    }

    public void atualizar(Carro carro) {
        carroDAO.atualizar(carro);
    }
}
