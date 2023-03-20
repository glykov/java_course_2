/*
 * Так как по условию логин и пароль могут содержать только буквы латинского алфавита,
 * а метод Character.isAlphabeti() и Character.isLetter() будет возвращать true для любых
 * символов Unicode, которые считаются буквами (включая кириллицу, арабский алфавит и т.д.),
 * то я решил проверять по старинке через равенство символам ASCII. Ну и с цифрами сделал то же 
 * самое, не прибегая к Character.isDigit()
 */
import java.util.Arrays;

 public class Main {
    private static boolean checkStringValidity(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!(ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= 9 || ch == '_')) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkAuthorizationParameters(String login, String password, String confirmPassword) {
        boolean checkResult = true;
        try {
            if (login.length() > 20) {
                throw new WrongLoginException();
            }
            if (!checkStringValidity(login) || !checkStringValidity(password) || password.length() > 20) {
                checkResult = false;
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException();
            }
        } catch (WrongLoginException e) {
            System.out.println("Incorrect Login!");
            checkResult = false;
        } catch (WrongPasswordException e) {
            System.out.println("Passwords should be same!");
            checkResult = false;
        }
        return checkResult;
    }

    public static void main(String[] args) {
        System.out.println(
            checkAuthorizationParameters("AbCd_1234", "AbCd_1234", "AbCd_1234")
        );

        char[] login = new char[26];
        Arrays.fill(login, 'A');
        System.out.println(
            checkAuthorizationParameters(new String(login), "AbCd_1234", "AbCd_1234")
        );

        char[] password = new char[30];
        Arrays.fill(password, '1');
        System.out.println(
            checkAuthorizationParameters("AbCd_1234", new String(password), new String(password))
        );

        System.out.println(
            checkAuthorizationParameters("AbCd_1234", "AbCd_1234", "AbCd_5678")
        );
    }
    
}
