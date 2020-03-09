package Dates;

import java.util.Date;
import java.util.GregorianCalendar;

import static PG.Utils.ScreenUtils.cls;

public class DatesBetween {
    public static void main(String[] args) {
        String[] dateStrings = {"1997-11-32","2003-12-02","1997-04-13","2020-01-13","2019-11-25"};
        Date minDate = new GregorianCalendar(2019,01,01).getTime();
        Date maxDate = new GregorianCalendar(2020,01,01).getTime();

        cls();
        for (String s:dateStrings ) {
            System.out.println( s+" result:"+between(s,minDate,maxDate) );
        }

    }

    static boolean between(String formattedDate, Date minDate, Date maxDate) {
        String[] dateParts = formattedDate.split("-");
        GregorianCalendar gc = new GregorianCalendar(
                Integer.parseInt(dateParts[0]),
                Integer.parseInt(dateParts[1]) -1,
                Integer.parseInt(dateParts[2])
        );

        System.out.println();
        System.out.println(formattedDate + "=>" + gc.getTime().toString());

        return (gc.getTime().after(minDate) && gc.getTime().before(maxDate) );

    }
}
