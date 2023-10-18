package net.weg.api.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "username", nullable = false, unique = true)
    private String usuario;
    private String senha;
    private Integer idade;
    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Carro> carro;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Endereco> endereco;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Habilitacao habilitacao;
    @ManyToOne
    private Consorcio consorcio;

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

