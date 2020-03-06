package PG.Utils;

public class StringUtils {
    public static String replicate( String s, int multiple){
        String result = "";
        for( int i=1; i <= multiple; i++){ result = result+s; }
        return result;
    }
}
