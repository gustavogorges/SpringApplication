package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.Carro;
import net.weg.api.service.CarroService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/carro")
@AllArgsConstructor
public class CarroController {

    private CarroService carroService;

    @GetMapping("/{id}")
    public Carro buscarCarro(@PathVariable Integer id){
        return carroService.buscarUm(id);
    }

    @GetMapping()
    public Collection<Carro> buscarTodos(){
        return carroService.buscarTodos();
    }

    @DeleteMapping
    public void deletar(@RequestParam("value") Integer id) {
        carroService.deletar(id);
    }

    @PostMapping()
    public void inserir(@RequestBody Carro carro){
        carroService.salvar(carro);
    }

    @PutMapping
    public void atualizar(@RequestBody Carro carro) {
        carroService.salvar(carro);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable Integer id,@RequestBody Carro carro) {
        carroService.salvar(carro);
    }


}
