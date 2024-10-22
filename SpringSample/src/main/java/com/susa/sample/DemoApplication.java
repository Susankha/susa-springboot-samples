package com.susa.sample;

import com.susa.sample.config.MyBean;
import com.susa.sample.controller.EmployeeController;
import com.susa.sample.repository.EmployeeRepository;
import com.susa.sample.service.EmployeeService;
import com.susa.sample.service.EmployeeServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        EmployeeController ec = applicationContext.getBean(EmployeeController.class);
        System.out.println(" *********** ec "+ec.hashCode());

        EmployeeService es = applicationContext.getBean(EmployeeServiceImpl.class);
        System.out.println(" *********** es "+es.hashCode());

        EmployeeRepository er = applicationContext.getBean(EmployeeRepository.class);
        System.out.println(" *********** er "+ er.hashCode());

        MyBean mb   = applicationContext.getBean(MyBean.class);
        System.out.println(" ***************** mb "+mb.hashCode());
        System.out.println(" ***************** mb msg "+mb.msg());

        MyBean mb1 = applicationContext.getBean(MyBean.class);
        System.out.println(" ***************** mb1 "+mb1.hashCode());

        DemoApplication da = applicationContext.getBean(DemoApplication.class);
        System.out.println(" ***************** da "+da.hashCode());


 /*       for (String bean : beanDefinitionNames){
            System.out.println(" Bean : "+bean);
        }*/
    }
}
