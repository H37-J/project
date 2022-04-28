package com.hjk.aop;

import org.springframework.aop.framework.ProxyFactory;

public class AfterAdvice {
    private static KeyGenerator getKeyGenerator(){
        KeyGenerator target = new KeyGenerator();
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvice(new WeakCheckAdvice());

        return (KeyGenerator)factory.getProxy();
    }

    public static void main(String... args){
        KeyGenerator KeyGen = getKeyGenerator();

        for(int x=0; x<10; x++){
            try{
                long key = KeyGen.getKey();
                System.out.println(key);
            }catch(SecurityException ex){
                System.out.println("취약한 키가 생성 되었습니다");
            }
        }
    }
}
