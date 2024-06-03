package br.com.senac.api.useCases.clientes;

import br.com.senac.api.entitys.Clientes;
import br.com.senac.api.useCases.clientes.domains.ClientesRequestDom;
import br.com.senac.api.useCases.clientes.domains.ClientesResponseDom;
import br.com.senac.api.useCases.clientes.implement.mappers.ClientesMappers;
import br.com.senac.api.useCases.clientes.implement.repositorys.ClientesRepository;
import br.com.senac.api.utils.SenacException;
import br.com.senac.api.utils.SenhaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepository clientesRepository;

    public ClientesResponseDom criarCliente(ClientesRequestDom clienteInput) throws SenacException {
        Optional<Clientes> clienteValidacao = clientesRepository.findByEmail(clienteInput.getEmail());
        if(!clienteValidacao.isPresent()){

            Clientes clienteResult = clientesRepository.save(ClientesMappers.criarClientesRequestDomToClientes(clienteInput));

            return ClientesMappers.clientesToClientesResponseDom(clienteResult);
        }

        throw new SenacException("Email do cliente já existe na base");
    }

    public ClientesResponseDom atualizarCliente(Long id, ClientesRequestDom clienteInput) {
        Optional<Clientes> resultado = clientesRepository.findById(id).map(record -> {
            record.setNome(clienteInput.getNome());
            record.setSobrenome(clienteInput.getSobrenome());
            record.setEmail(clienteInput.getEmail());
            record.setDataNascimento(clienteInput.getDataNascimento());
            record.setSenha(clienteInput.getSenha());
            record.setDocumento(clienteInput.getDocumento());
            record.setTelefone(clienteInput.getTelefone());


            return clientesRepository.save(record);
        });

        if(resultado.isPresent()){
            Clientes clienteResult = resultado.get();

            return ClientesMappers.clientesToClientesResponseDom(clienteResult);
        }
        return null;
    }

    public ClientesResponseDom autenticarCliente(String email, String senha) throws SenacException {
        Optional<Clientes> clienteResult = clientesRepository.findByEmail(email);
        if(clienteResult.isPresent()){
            if(SenhaUtil.validarSenha(senha, clienteResult.get().getSenha())){
                return ClientesMappers.clientesToClientesResponseDom(clienteResult.get());
            }

            throw new SenacException("Senha invalida!");
        }

        throw new SenacException("Cliente não encontrado!");
    }
}
