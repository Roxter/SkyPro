package pro.sky.java.homeworks.course2.lesson1;

public class Bicycle extends ServiceKit {

    public boolean serviceMe() {
        for (int wheelNum = 1; wheelNum <= getWheelsCount(); wheelNum++) {
            updateTyre(wheelNum);
        }
        return true;
    }

}