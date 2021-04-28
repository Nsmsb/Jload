package utils;

public class DefineType {

    public static boolean isInt(String str){
        try{
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            // not an integer!
        }
        return false;
    }

}
