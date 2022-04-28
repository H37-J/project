package com.hjk.testboot.sample.message;

public class MessageProviderImpl implements MessageProvider {
    
    private String message="Default Message";

    public MessageProviderImpl(){

    }

    public MessageProviderImpl(String message){
        this.message = message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
