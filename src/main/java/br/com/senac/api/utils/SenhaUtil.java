package br.com.senac.api.utils;


import java.util.Objects;

public class SenhaUtil {

    /*
    public static String criprografarSenha(String senha) throws SenacException {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if(Objects.nonNull(senha)){
            return passwordEncoder.encode(senha);
        }

        throw new SenacException("Senha não pode se null");
    }
    */
    public static boolean validarSenha(String senha, String senhaBanco) throws SenacException {

        if(Objects.nonNull(senha)){
            if(senha.equals(senhaBanco)){
                return true;
            }

            return false;
        }

        throw new SenacException("Senha não pode se null");
    }
}
