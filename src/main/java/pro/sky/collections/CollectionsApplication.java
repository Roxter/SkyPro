package pro.sky.collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pro.sky.collections.domain.Employee;
import pro.sky.collections.service.EmployeeService;

import java.util.ArrayList;

@SpringBootApplication
public class CollectionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CollectionsApplication.class, args);
    }

}