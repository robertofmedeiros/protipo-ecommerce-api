package br.com.senac.api.entitys;

import br.com.senac.api.entitys.enums.ClientesSexoEnum;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@SQLDelete(sql = "UPDATE clientes SET deleted_at = now() WHERE id=?")
@Where(clause = "deleted_at is null")
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column
    private LocalDateTime deletedAt;

    @Column(nullable = false)
    private ClientesSexoEnum sexo;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.REMOVE)
    private List<ClientesEnderecos> enderecos;

    @Column
    private String senha;

    @Column
    private String telefone;

    @Column
    private String documento;

    public List<ClientesEnderecos> getEnderecos() {
        return enderecos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public ClientesSexoEnum getSexo() {
        return sexo;
    }

    public void setSexo(ClientesSexoEnum sexo) {
        this.sexo = sexo;
    }

    public void setEnderecos(List<ClientesEnderecos> enderecos) {
        this.enderecos = enderecos;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
