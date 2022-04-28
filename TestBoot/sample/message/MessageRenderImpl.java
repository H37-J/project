package com.hjk.testboot.sample.message;

public class MessageRenderImpl implements MessageRender{

    private MessageProvider messageProvider;

    public MessageRenderImpl(){
    }

    @Override
    public void render(){
        if(messageProvider == null){
            throw new RuntimeException(MessageRenderImpl.class.getName()+"messageProvider 클래스의 프로퍼티를 설정해야 합니다");
        }
        System.out.println(this.messageProvider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider messageProvider){
        this.messageProvider = messageProvider;
    }

    @Override
    public MessageProvider getMessageProvider(){
        return this.messageProvider;
    }

}
