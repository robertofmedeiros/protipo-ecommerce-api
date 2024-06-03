package br.com.senac.api.useCases.clientes.domains;

import br.com.senac.api.entitys.enums.ClientesSexoEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.validation.constraints.NotNull;

public class ClientesRequestDom {

    @NotNull(message = "O campo 'nome' não pode ser nulo")
    private String nome;

    @NotNull(message = "O campo 'nome' não pode ser nulo")
    private String sobrenome;

    @NotNull(message = "O campo 'nome' não pode ser nulo")
    private String email;

    @NotNull(message = "O campo 'nome' não pode ser nulo")
    private LocalDate dataNascimento;

    @NotNull(message = "O campo 'nome' não pode ser nulo")
    private ClientesSexoEnum sexo;

    private String senha;
    
    private String telefone;
    
    private String documento;

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

    public ClientesSexoEnum getSexo() {
        return sexo;
    }

    public void setSexo(ClientesSexoEnum sexo) {
        this.sexo = sexo;
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
