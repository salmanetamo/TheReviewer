package utils;

public class Validator {
    public static boolean validateMaxLength(String input, int maxLength){
        return input.length() <= maxLength;
    }

    public static String getMaxLengthError(String input){
        return "The " + input + " field is too long.";
    }

    public static boolean validateMinLength(String input, int minLength){
        return input.length() >= minLength;
    }

    public static String getMinLengthError(String input){
        return "The " + input + " field is too short.";
    }

    /**
     * Email regex: https://emailregex.com/
     * General Email Regex (RFC 5322 Official Standard)
     * */
    public static boolean validateEmail(String email){
        return email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
    }

    public static String getInvalidEmailError(){
        return "The email address is invalid.";
    }

    /**
     * Strong password with at least 8 characters, at least one digit, one uppercase letter, one lowercase letter, and one symbol.
     * */
    public static boolean validateStrongPassword(String password){
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
    }

    public static String getWeakPasswordError(){
        return "Password requirements not met, it must contain at least 8 characters, at least one digit, " +
                "one uppercase letter, one lowercase letter, and one symbol.";
    }

    public static boolean validateConfirmationPassword(String initialPassword, String confirmPassword){
        return initialPassword.equals(confirmPassword);
    }

    public static String confirmPasswordsError(){
        return "The passwords do not match.";
    }
}
