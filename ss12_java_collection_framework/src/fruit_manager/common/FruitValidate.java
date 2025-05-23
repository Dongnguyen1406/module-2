package fruit_manager.common;

import java.util.regex.Pattern;

public class FruitValidate {
    private static final String TYPE_FRUIT_REGEX = "^[^\\d]+$";
    private static final String ID_FRUIT_REGEX = "^\\d+$";
    
    public static void validateTypeFruit(String name) throws Exception{
        if (!Pattern.matches(TYPE_FRUIT_REGEX, name)){
            throw new Exception("Vui lòng không nhập số !");
        }
    }

    public static void validateIdFruit(String id) throws Exception {
        if (!Pattern.matches(ID_FRUIT_REGEX, id)) {
            throw new Exception("ID chỉ được chứa số !");
        }
    }
}
