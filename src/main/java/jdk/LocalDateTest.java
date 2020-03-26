package jdk;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by think on 2019/12/27.
 */
public class LocalDateTest {
    @Test
    public void test(){
        LocalDate localDate = LocalDate.now();
        //LocalDate l = new LocalDate(new Date);
        System.out.println(localDate);
        LocalDateTime dataTime = LocalDateTime.now();

    }
    @Test
    public void dateToLocalDateTime(){
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = instant.atZone(zoneId);
        LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();
        System.out.println(localDateTime);
        DateTimeFormatter fomat = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        String date1 = localDateTime.format(fomat);
        System.out.println(date1);
        DateTimeFormatter fomat2= DateTimeFormatter.ISO_DATE_TIME;
        String date2 = localDateTime.format(fomat2);
        System.out.println(date2);

        DateTimeFormatter fomat3= DateTimeFormatter.ISO_LOCAL_DATE;
        String date3 = localDateTime.format(fomat3);
        System.out.println(date3);

        DateTimeFormatter fomat4= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:MM:ss");
        String date4 = localDateTime.format(fomat4);
        System.out.println(date4);
    }
    @Test
    public void LocalDateTimeToDate(){
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
        Date from = Date.from(zonedDateTime.toInstant());
        System.out.println(from);

    }
}
