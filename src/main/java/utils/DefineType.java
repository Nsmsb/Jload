package utils;

/**
 * @author walid BOUKRIS
 */
public class DefineType {

    /**
     * @param str la chaine a verifier
     * @return boolean true if it's an Integer else false
     */
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
