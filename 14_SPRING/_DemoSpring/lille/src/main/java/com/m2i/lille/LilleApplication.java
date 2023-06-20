package com.m2i.lille;

import com.m2i.lille.controller.EmployeeController;
import com.m2i.lille.service.EmployeeService;
import com.m2i.lille.service.impl.EmployeeServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class LilleApplication {

    public static void main(String[] args) {
        // Par constructeur
        System.out.println("Par constructeur");
        EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
        EmployeeController employeeController = new EmployeeController(employeeServiceImpl);
        employeeController.getAllEmployee().stream().forEach(System.out::println);
        System.out.println("*********************");

        System.out.println("Par setter");
        // Par setter
        EmployeeServiceImpl employeeServiceImpl1 = new EmployeeServiceImpl();
        EmployeeController employeeController1 = new EmployeeController(employeeServiceImpl1);
        employeeController1.getAllEmployee().stream().forEach(System.out::println);
        System.out.println("*********************");

//        System.out.println("Par interface");
//        // Par interface
//        EmployeeService employeeService = new EmployeeServiceImpl();
//        EmployeeController employeeController2 = new EmployeeController(employeeService);
//        employeeController2.setEmployeeServiceImpl(employeeServiceImpl1);
//        employeeController2.getAllEmployee().stream().forEach(System.out::println);
//        System.out.println("*********************");

    }

}
