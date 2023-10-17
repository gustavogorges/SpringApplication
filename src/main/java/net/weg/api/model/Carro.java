package net.weg.api.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Carro {
    private Integer id;
    private String marca;
    private String cor;
    private String modelo;
    private Double preco;
    private Integer ano;

    public Carro(){

    }

    public Carro(Integer id, String marca, String cor, String modelo, Double preco, Integer ano) {
        this.id = id;
        this.marca = marca;
        this.cor = cor;
        this.modelo = modelo;
        this.preco = preco;
        this.ano = ano;
    }

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

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }
}
