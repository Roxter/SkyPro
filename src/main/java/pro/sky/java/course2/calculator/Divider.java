package pro.sky.java.course2.calculator;

public class Divider extends Computer{

    Divider (String num1, String num2) {
        super(num1, num2);
    }

    @Override
    public String getResult() {
        return Double.toString(num1 / num2);
    }
}
