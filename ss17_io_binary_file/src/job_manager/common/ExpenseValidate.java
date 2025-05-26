package job_manager.common;

import java.util.regex.Pattern;

public class ExpenseValidate {
    public static final String NAME_REGEX = "^[^\\d]+$";
    
    public static void validateExpenseName(String name) throws Exception{
        if (!Pattern.matches(NAME_REGEX, name)){
            throw new Exception("Vui lòng không nhập số hoặc để trống!");
        }
    }
}
