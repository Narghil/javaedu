package Dates;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TomorrowAfterTomorrow {

    public static void main(String[] args) {
        Long oneDay = (24L*60*60*1000);
        Date today = new Date();
        Date tomorrow = new Date(today.getTime() + oneDay);
        Date afterTomorrow = new Date( today.getTime() + oneDay * 2);

        String pattern = "yyyy.MM.dd HH:mm:ss.SSS Z EEEEE MMMMM";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern,new Locale("hu", "HU"));

        System.out.println("Today:"+simpleDateFormat.format(today) );
        System.out.println("Tomorrow:" + simpleDateFormat.format(tomorrow) );
        System.out.println("After tomorrow:"+simpleDateFormat.format(afterTomorrow));

//        Calendar cal = Calendar.getInstance();
//        today = cal.getTime();


    }
}
