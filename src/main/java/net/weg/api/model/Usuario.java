package net.weg.api.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario {
    private Integer id;
    private String usuario;
    private String senha;
    private Integer idade;
    private Carro carro;

    public Usuario(Integer id, String usuario, String senha, Integer idade) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
        this.idade = idade;
    }

    public Usuario(Integer id, String usuario, String senha, Integer idade, Carro carro) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
        this.idade = idade;
        this.carro = carro;
    }

    public Usuario(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id_usuario");
        this.idade = resultSet.getInt("idade");
        this.usuario = resultSet.getString("nome");
        this.senha = resultSet.getString("senha");
        int idCarro = resultSet.getInt("carro_id");
        if (idCarro != 0) {
            this.carro = new Carro(idCarro);
        }
    }

    public Integer getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", usuario='" + usuario + '\'' +
                ", senha='" + senha + '\'' +
                ", idade=" + idade +
                '}';
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
}
