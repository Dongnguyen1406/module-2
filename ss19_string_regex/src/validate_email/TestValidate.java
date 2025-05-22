package validate_email;

public class TestValidate {
    private static EmailValidate emailValidate;
    public static final String[] validEmail = new String[]{"a@gmail.com", "abc@gmail.com", "abc@hotmail.com", "NguyenVanA2000@gmail.com"};
    public static final String[] invalidEmail = new String[]{"@gmail.com", "ab@gmail.", "@#abc@gmail.com"};
    
    public static void main(String[] args){
        emailValidate = new EmailValidate();
        for (String email : validEmail){
            boolean isValid = emailValidate.validate(email);
            System.out.println("Email is " + email + " is valid: " + isValid);
        }
        for (String email : invalidEmail){
            boolean isValid = emailValidate.validate(email);
            System.out.println("Email is " + email + " is invalid: " + isValid);
        }
    }
}
