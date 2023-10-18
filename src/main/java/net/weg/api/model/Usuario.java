package net.weg.api.model;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    private Integer id;
    private String usuario;
    private String senha;
    private Integer idade;
    private Carro carro;

    public Usuario(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.idade = resultSet.getInt("idade");
        this.usuario = resultSet.getString("nome");
        this.senha = resultSet.getString("senha");
        int idCarro = resultSet.getInt("id_carro");
        if (idCarro != 0) {
            this.carro = new Carro(idCarro);
        }
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
}

