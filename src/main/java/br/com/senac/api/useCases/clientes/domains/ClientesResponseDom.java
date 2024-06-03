package br.com.senac.api.useCases.clientes.domains;

import br.com.senac.api.entitys.enums.ClientesSexoEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ClientesResponseDom {

    private Long id;

    private String nome;

    private String sobrenome;

    private String email;

    private LocalDate dataNascimento;

    private LocalDateTime deletedAt;

    private ClientesSexoEnum sexo;

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
}
