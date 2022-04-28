package com.hjk.testboot.sample.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class Hell {
    
    private static Logger logger =
        LoggerFactory.getLogger(Hell.class);

    public void hi(){
        logger.info("Hell");
    }
}
