package br.com.senac.api.controllers;

import br.com.senac.api.useCases.clientes.ClientesService;
import br.com.senac.api.useCases.clientes.domains.ClientesAutenticacaoRequestDom;
import br.com.senac.api.useCases.clientes.domains.ClientesRequestDom;
import br.com.senac.api.useCases.clientes.domains.ClientesResponseDom;
import br.com.senac.api.utils.ResponseUtil;
import br.com.senac.api.utils.SenacException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
@CrossOrigin
public class ClientesController {

    @Autowired
    private ClientesService clientesService;

    @PostMapping("/")
    public ResponseEntity<?> criarCliente(@Valid  @RequestBody ClientesRequestDom cliente){
        try {
            ClientesResponseDom response = clientesService.criarCliente(cliente);
            return ResponseEntity.status(201).body(response);
        } catch (SenacException e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.responseMap(e.getMessages()));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(ResponseUtil.responseMap("Erro não Mapeado " + e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarCliente (@PathVariable Long id, @Valid @RequestBody ClientesRequestDom cliente){
        try {
            ClientesResponseDom response = clientesService.atualizarCliente(id, cliente);

            if (response == null){
                return ResponseEntity.badRequest().body(null);
            }

            return ResponseEntity.ok(response);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/autenticar/")
    public ResponseEntity<?> autenticarCliente(@Valid @RequestBody ClientesAutenticacaoRequestDom cliente){
        try {
            ClientesResponseDom response = clientesService.autenticarCliente(cliente.getEmail(), cliente.getSenha());
            return ResponseEntity.ok(response);
        } catch (SenacException e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.responseMap(e.getMessages()));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(ResponseUtil.responseMap("Erro não Mapeado " + e.getMessage()));
        }
    }

}
