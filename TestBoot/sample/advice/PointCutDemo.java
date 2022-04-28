package com.hjk.testboot.sample.advice;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class PointCutDemo {
    
    public static void main(String... args){
        GoodGuitarist test = new GoodGuitarist();
        
        Singer proxyOne;

        Pointcut pc =new SimplePointCut();
        Advice advice = new SimpleAdvice();
        Advisor advisor = new DefaultPointcutAdvisor(pc, advice);

        ProxyFactory pf =new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(test);
        proxyOne = (Singer) pf.getProxy();

        proxyOne.sing();


    }
}
