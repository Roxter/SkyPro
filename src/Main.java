import exception.WrongLoginException;
import exception.WrongPasswordException;

public class Main {

    public static void main(String[] args) {
        try {
            checkAuthenticate("Gerard", "Bat_ler", "Bat_ler");
            //checkAuthenticate("Gerard", "Bat ler", "Bat ler");
            checkAuthenticate("Gerard", "Bat_ler", "Batler");
            checkAuthenticate("Box", "Kubic_rounded24", "Kubic_rounded24");
            //checkAuthenticate("Box 5", "Kubic_rounded24", "Kubic_rounded2");
        } catch (WrongLoginException wle) {
            //System.out.println("Логин был введен неверно");
            System.out.println(wle.getMessage());
        } catch (WrongPasswordException wpe) {
            //System.out.println("Пароль был введен неверно");
            wpe.printStackTrace();
        } finally {
            System.out.println("Программа завершена.");
        }
    }

    private static void checkAuthenticate(String login, String password, String confirmPassword) {
        checkLogin(login);
        checkPassword(password);
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }

    public static void checkLogin(String login) {
        for (int i = 0; i < login.length(); i++) {
            char currentSymbol;
            currentSymbol = login.charAt(i);
            boolean isDigit = Character.isDigit(currentSymbol);
            boolean isLetter = Character.isLetter(currentSymbol);
            boolean isUnderscore = currentSymbol == '_';
            boolean isOver20Symb = i >= 20;
            if (isOver20Symb || !isDigit && !isLetter && !isUnderscore) {
                throw new WrongLoginException("Логин был введен неверно");
            }
        }
    }

    public static void checkPassword(String password) {
        for (int i = 0; i < password.length(); i++) {
            char currentSymbol;
            currentSymbol = password.charAt(i);
            boolean isDigit = Character.isDigit(currentSymbol);
            boolean isLetter = Character.isLetter(currentSymbol);
            boolean isUnderscore = currentSymbol == '_';
            boolean isOver20Symb = i >= 20;
            if (isOver20Symb || !isDigit && !isLetter && !isUnderscore) {
                throw new WrongPasswordException("Пароль был введен неверно");
            }
        }
    }
}