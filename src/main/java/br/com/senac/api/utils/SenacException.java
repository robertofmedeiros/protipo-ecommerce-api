package br.com.senac.api.utils;

import java.util.ArrayList;
import java.util.List;

public class SenacException extends Exception{
    private List<String> messageList =  new ArrayList<>();

    public SenacException(List<String> mensagens){
        this.messageList = mensagens;
    }


    public SenacException(String mensagem){
        super(mensagem);//como se estivese usando o construtor da classe pai
    }

    public List<String> getMessages(){
        if (messageList.isEmpty()){
            messageList.add(super.getMessage());
        }

        return messageList;
    }

    public String getMenssage(){
        if(messageList.isEmpty()){
            return super.getMessage();
        }
        return messageList.toString();
    }
}
