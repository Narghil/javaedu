package Dates;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class LeapYears {
    public static void main(String[] args) {
        GregorianCalendar gc = new GregorianCalendar();
        List leapYears = new ArrayList();

        for( int year = 1500; year <= 2020; year ++){
            if( gc.isLeapYear( year )){
                leapYears.add( (Integer)year);
            }
        }

        System.out.println(leapYears.toString());
    }
}
