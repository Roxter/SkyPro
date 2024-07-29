package pro.sky.java.course2.calculator;

import org.springframework.stereotype.Service;

@Service
public abstract class Computer implements ComputationalService {
    double num1;
    double num2;

    public Computer(String num1, String num2) {
        this.num1 = Integer.parseInt(num1);
        this.num2 = Integer.parseInt(num2);
    }

    @Override
    public abstract String getResult();
}