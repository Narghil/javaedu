//Minden hónap második keddje,2020-ban
package Dates;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Calendar;
import java.util.Locale;

public class SecondTuesdays {
    public static void main(String[] args) {
        List<Date> tuesdays= new LinkedList<Date>();
        Calendar cal = GregorianCalendar.getInstance();
        Date date;

        //cal = GregorianCalendar.getInstance();
        for( int month = 1; month <= 12; month++){
            int tuesdayCounter = 0;
            for( int day = 1; day <= 14; day++){
                cal.set( 2020, month -1, day,0,0, 0);
                date = cal.getTime();
                String pattern = "EEEEE"; //zone, dayofweek, name of month
                SimpleDateFormat sdf = new SimpleDateFormat(pattern, new Locale("hu", "HU"));
                //System.out.println(sdf.format(date));
                if( sdf.format(date).equalsIgnoreCase("kedd")){ tuesdayCounter++;
                    if( tuesdayCounter == 2){
                        tuesdays.add(date);
                    }
                }
            }
        }
        for( Date d:tuesdays){
            System.out.println(d);
        }
    }
}
