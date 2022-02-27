package design.boilerplate.readingisgood.security.utils;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateUtils {

  static public LocalDateTime getFirstDateOfMonth(int year, int month) {
    return getFirstDateOfMonth(year, month, TimeZone.getDefault());
  }


  static public LocalDateTime getLastDateOfMonth(int year, int month) {
    return getLastDateOfMonth(year, month, TimeZone.getDefault());
  }



  static public LocalDateTime getFirstDateOfMonth(int year, int month, TimeZone tz) {
    GregorianCalendar cal = new GregorianCalendar(year, (month - 1), 1);
    cal.setTimeZone(tz);
    return  LocalDateTime.ofInstant(cal.toInstant(), tz.toZoneId());
  }


  static public LocalDateTime getFirstDateOfMonth(long timestamp, TimeZone tz) {
    GregorianCalendar cal = new GregorianCalendar();
    cal.setTimeZone(tz);
    cal.setTime(new Date(timestamp));
    cal.set(Calendar.DAY_OF_MONTH, 1);
    cal.set(Calendar.HOUR_OF_DAY, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MILLISECOND, 0);

    return  LocalDateTime.ofInstant(cal.toInstant(), tz.toZoneId());
  }


  static public LocalDateTime getLastDateOfMonth(int year, int month, TimeZone tz) {
    GregorianCalendar cal = new GregorianCalendar(year, (month - 1), 1);
    cal.setTimeZone(tz);

    // set the maximum last day
    int lastday = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
    cal.set(GregorianCalendar.DAY_OF_MONTH, lastday);

    // set other calendar maximums. - we should do this programatically
    // too but i'm too lazy, and i dont think they're gonna change the gregorian
    // calendar anytime soon.. eh?
    cal.set(GregorianCalendar.HOUR_OF_DAY, 23);
    cal.set(GregorianCalendar.MINUTE, 59);
    cal.set(GregorianCalendar.SECOND, 59);
    cal.set(GregorianCalendar.MILLISECOND, 999);

    return LocalDateTime.ofInstant(cal.toInstant(), tz.toZoneId());

  }
}
