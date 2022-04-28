package com.hjk.testboot.sample.io.lookup;

import org.springframework.beans.factory.parsing.ComponentDefinition;

public class LookupTest implements Component {
    
    Dependency dependency;

    @Override
    public void LookUp(Container container){
        this.dependency = (Dependency) container.getDependency("Dependeyncy");
    }

    @Override
    public String toString(){
        return dependency.toString();
    }
    
}
