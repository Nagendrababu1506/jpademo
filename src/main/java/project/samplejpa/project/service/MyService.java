package project.samplejpa.project.service;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import project.samplejpa.project.Exception.CustomException;

@Service
public class MyService {

    private static final Logger logger = LoggerFactory.getLogger(MyService.class);
    public void method1() {
        logger.info("Executing method1");


        logger.info("Method1: Business logic executed.");
    }

    public void method2() {
        int i=10;
        if(i==10){
            throw new CustomException("Custom exception message");
        }
        // Method implementation
    }


}