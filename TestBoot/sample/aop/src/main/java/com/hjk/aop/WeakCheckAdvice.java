package com.hjk.aop;
import static com.hjk.aop.KeyGenerator.WEAK_KEY;

import java.lang.reflect.Method;

import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

import org.springframework.aop.AfterReturningAdvice;

public class WeakCheckAdvice implements AfterReturningAdvice{

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        if((target instanceof KeyGenerator) && ("getKey".equals((method.getName())))){
            long key = ((Long) returnValue).longValue();

            if(key == WEAK_KEY){
                throw new SecurityException("키가 취약 합니다");
            }
        }
    }
}
