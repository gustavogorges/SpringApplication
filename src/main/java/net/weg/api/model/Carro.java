package net.weg.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Carro {
    private Integer id;
    private String marca;
    private String cor;
    private String modelo;
    private Double preco;
    private Integer ano;

    public Carro (Integer id) {
        this.id = id;
    }

    public Carro(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.ano = resultSet.getInt("ano");
        this.marca = resultSet.getString("marca");
        this.modelo = resultSet.getString("modelo");
        this.cor = resultSet.getString("cor");
        this.preco = resultSet.getDouble("preco");
    }

}
