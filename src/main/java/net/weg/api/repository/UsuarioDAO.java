package net.weg.api.repository;

import net.weg.api.model.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO extends DAOPadrao <Usuario,Integer>{

    private String comandoSQL; //implementar comando SQL aqui

    public UsuarioDAO() {
        super("usuario");
    }

    public void inserir(Usuario usuario) {
        conectar();
        String comandoSQL = "INSERT INTO usuario " +
                "VALUES(?,?,?,?,?);";
        try ( PreparedStatement statement = connection.prepareStatement(comandoSQL) ){
            statement.setInt(1,usuario.getId());
            statement.setString(2,usuario.getUsuario());
            statement.setString(3,usuario.getSenha());
            statement.setInt(4,usuario.getIdade());
            try {
                statement.setInt(5, usuario.getCarro().getId());
            } catch (NullPointerException e) {
                statement.setNull(5,0);
            }
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                this.connection.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


    public void atualizar(Usuario usuario) {
        conectar();
        String comandoSQL = "UPDATE usuario SET nome = ?,senha = ?,idade = ?,id_carro = ? WHERE id = ?;";
        try(PreparedStatement statement =
                connection.prepareStatement(comandoSQL)) {
            statement.setString(1,usuario.getUsuario());
            statement.setString(2,usuario.getSenha());
            statement.setInt(3,usuario.getIdade());
            try {
                statement.setInt(4,usuario.getCarro().getId());
            } catch (NullPointerException e) {
                statement.setNull(4,0);
            }
            statement.setInt(5,usuario.getId());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                this.connection.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Usuario converter(ResultSet resultSet) throws SQLException {
        return new Usuario(resultSet);
    }


}
