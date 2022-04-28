package com.hjk.testboot.sample.io.injection;

public class SetterInjection {
    Dependency dependency;
    
    public void setDependency(Dependency dependency){
        this.dependency = dependency;
    }

    @Override
    public String toString(){
        return this.dependency.toString();
    }
}
