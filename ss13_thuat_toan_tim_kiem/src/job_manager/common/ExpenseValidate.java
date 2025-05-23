package job_manager.common;

import java.util.regex.Pattern;

public class ExpenseValidate {
    public static final String NAME_REGEX = "^[^\\d]+$";
    public static final String ID_REGEX = "";
    
    public static void validateExpenseName(String name) throws Exception{
        if (!Pattern.matches(NAME_REGEX, name)){
            throw new Exception("Vui lòng không nhập số hoặc để trống!");
        }
    }
    
    public static void validateExpenseCode(String id) throws Exception{
        if (Pattern.matches(ID_REGEX, id)){
            throw new Exception("ID chỉ chứa số và không để trống!");
        }
    }
}
