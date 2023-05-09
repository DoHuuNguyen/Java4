package utils;

public class CheckString {
    public static String checkValues(String value,String ten){
        if (value.trim().isEmpty()){
            return "Phải nhập "+ten;
        }
        return "";
    }
}
