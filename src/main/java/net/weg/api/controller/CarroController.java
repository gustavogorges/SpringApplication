package net.weg.api.controller;

import net.weg.api.model.Carro;
import net.weg.api.repository.CarroDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/carro")
public class CarroController {

    private CarroDAO carroDAO = new CarroDAO();

    @GetMapping("/{id}")
    public Carro buscarCarro(@PathVariable Integer id){
        return carroDAO.buscarUm(id);
    }

    @GetMapping()
    public Collection<Carro> buscarTodos(){
        return carroDAO.buscarTodos();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        carroDAO.deletar(id);
    }

    @PostMapping()
    public void inserir(@RequestBody Carro carro){
        carroDAO.inserir(carro);
    }

    @PutMapping
    public void atualizar(@RequestBody Carro carro) {
        carroDAO.atualizar(carro);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable Integer id,@RequestBody Carro carro) {
        carroDAO.atualizar(carro);
    }


}
