package br.com.senac.api.utils;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {

    //metodo static nao precisa instanciar a class para usar o metodo
    //Map chave/valor
    public static Map<String, Object> responseMap(Object mensagem){
        Map<String,Object> response = new HashMap<>();
        response.put("menssages",mensagem);

        return response;
    }
}
