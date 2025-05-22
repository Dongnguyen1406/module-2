package validate_email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidate {
    private static Pattern pattern;
    private static Matcher matcher;
    
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    
    public EmailValidate(){
        pattern = Pattern.compile(EMAIL_REGEX);
    }
    
    public boolean validate(String regex){
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
