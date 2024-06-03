package br.com.senac.api.useCases.clientes.implement.mappers;

import br.com.senac.api.entitys.Clientes;
import br.com.senac.api.useCases.clientes.domains.ClientesRequestDom;
import br.com.senac.api.useCases.clientes.domains.ClientesResponseDom;
import br.com.senac.api.utils.SenacException;
import br.com.senac.api.utils.SenhaUtil;

public class ClientesMappers {
    public static Clientes clientesRequestDomToClientes(ClientesRequestDom in){
        Clientes out = new Clientes();
        out.setNome(in.getNome());
        out.setSobrenome(in.getSobrenome());
        out.setEmail(in.getEmail());
        out.setDataNascimento(in.getDataNascimento());
        out.setSexo(in.getSexo());
        out.setDocumento(in.getDocumento());
        out.setTelefone(in.getTelefone());

        return out;
    }

    public static Clientes criarClientesRequestDomToClientes(ClientesRequestDom in) throws SenacException {
        Clientes out = clientesRequestDomToClientes(in);

        out.setSenha(in.getSenha());

        return out;
    }

    public static ClientesResponseDom clientesToClientesResponseDom(Clientes in){
        ClientesResponseDom out = new ClientesResponseDom();
        out.setNome(in.getNome());
        out.setSobrenome(in.getSobrenome());
        out.setEmail(in.getEmail());
        out.setDataNascimento(in.getDataNascimento());
        out.setSexo(in.getSexo());
        out.setId(in.getId());

        return out;
    }
}
