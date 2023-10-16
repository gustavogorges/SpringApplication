package net.weg.api.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class DAOPadrao<T,ID>  implements ICRUD<T,ID> {
    protected Connection connection;
    protected String comandoSQL;
    private String tabela;

    public DAOPadrao(String tabela) {
        this.connection = Banco.conectar();
        this.tabela = tabela;
    }

    @Override
    public void close() throws Exception {
        this.connection.close();
    }

    public Set<T> buscarTodos() {
        comandoSQL = "SELECT * FROM "+tabela+";";
        try {
            PreparedStatement statement = connection.prepareStatement(comandoSQL);
            ResultSet resultSet = statement.executeQuery();

            Set<T> lista = new HashSet<>();
            while (resultSet.next()) {
                lista.add(converter(resultSet));
            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deletar(Integer id) {
        comandoSQL = "DELETE FROM "+tabela+" WHERE id = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(comandoSQL);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public T buscarUm(Integer id) {

        comandoSQL = "SELECT * FROM "+tabela+" WHERE id = ?";
        try(PreparedStatement statement = connection.prepareStatement(comandoSQL)) {
            statement.setInt(1,id);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            if (resultSet.next()) {
                return converter(resultSet);
            }
        throw new NoSuchElementException();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public abstract T converter(ResultSet resultSet) throws SQLException;

}
