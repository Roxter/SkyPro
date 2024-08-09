import ch.qos.logback.core.UnsynchronizedAppenderBase;

public class Main {

    public static void main(String[] args) {
        try {
            checkParams("Gerard", "Bat_ler", "Bat_ler");
            checkParams("Gerard", "Bat_ler", "Batler");
            checkParams("Box", "Kubic_rounded24", "Kubic_rounded24");
            checkParams("Box 5", "Kubic_rounded24", "Kubic_rounded2");
        } catch (WrongLoginException w) {
            System.out.println("Логин был введен неверно");
        } catch (WrongPasswordException w) {
            System.out.println("Пароль был введен неверно");
        }
        System.out.println("Программа завершена.");
    }

    private static void checkParams(String login, String password, String confirmPassword) {
        checkString(login, false);
        checkString(password, true);
        checkString(confirmPassword, true);
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException();
        }
    }

    private static void checkString(String string, boolean isPassword) {
        for (int i = 0; i < string.length(); i++) {
            char currentSymbol;
            currentSymbol = string.charAt(i);
            boolean isDigit = Character.isDigit(currentSymbol);
            boolean isLetter = Character.isLetter(currentSymbol);
            boolean isUnderscore = currentSymbol == '_';
            boolean isOver20Symb = i >= 20;
            if (isOver20Symb | !isDigit & !isLetter & !isUnderscore) {
                if (!isPassword) {
                    throw new WrongLoginException();
                } else {
                    throw new WrongPasswordException();
                }
            }
        }
    }
}