package Dates;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateConversions {
    static String[] strDates = new String[]{
            "2020.03.03 i. sz. at 21:38:24 CET","02019.augusztus.15 i. sz. 05:40 de."};
    static String[] patterns = new String[]{
            "yyyy.MM.dd G 'at' HH:mm:ss z","yyyyy.MMMMM.dd G HH:mm a"};

    public static void main(String[] args) {
        for( int i = 0; i< strDates.length; i++){
            String pattern = patterns[i];
            String otherPattern = patterns[ strDates.length-1-i ];
            String strDate = strDates[i];

            SimpleDateFormat sdf = new SimpleDateFormat(pattern, new Locale("hu", "HU"));
            SimpleDateFormat sdfo = new SimpleDateFormat(otherPattern, new Locale("hu", "HU"));
            try {
                Date date = sdf.parse(strDate);
                System.out.println(strDate +", azaz: "+date);
                System.out.println(strDate +", másik forma szerint:" + sdfo.format(date));
            } catch( Exception e){
                System.out.println(pattern+" to "+strDate+" is not correct");
            }
        }

    }
}
