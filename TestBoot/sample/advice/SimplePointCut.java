package com.hjk.testboot.sample.advice;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

public class SimplePointCut extends StaticMethodMatcherPointcut {
    
    @Override
    public boolean matches(Method method,Class<?> cls){
        return ("sing".equals(method.getName()));
    }

    @Override
    public ClassFilter getClassFilter(){
        return cls ->  (cls == GoodGuitarist.class);
    }




}
