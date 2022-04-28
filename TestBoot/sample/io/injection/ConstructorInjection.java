package com.hjk.testboot.sample.io.injection;

public class ConstructorInjection {
    Dependency dependency;

    public ConstructorInjection(Dependency dependency){
        this.dependency = dependency;
    }

    @Override
    public String toString(){
        return dependency.toString();
    }
}
