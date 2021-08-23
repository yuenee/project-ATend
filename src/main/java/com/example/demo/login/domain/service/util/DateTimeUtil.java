package com.example.demo.login.domain.service.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;


@Service
public class DateTimeUtil {

    /**
     * 年月を年と月に分け、mapにいれてreturnする。
     *
     * @param yearMonth 年月(yyyyMM)
     * @return map([0] = 年, [1] = 月)
     */
    public Map<String, Integer> getYearAndMonth(String yearMonth) {
        final LocalDate createDate = BeginningOfMonth(yearMonth);
        final int year = createDate.getYear();
        final int month = createDate.getMonthValue();

        Map<String, Integer> map = new HashMap<>();
        map.put("year", year);
        map.put("month", month);

        return map;
    }

    /**
     * 日付のフォーマットを指定してreturnする。
     *
     * @param localDate 日付(yyyy-MM-dd)
     * @param format    日付のフォーマットを指定する(yyyyMMdd, yyyy年MM月dd日(E), etc.)
     * @return 日付
     */
    public String toStringDate(LocalDate localDate, String format) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);

        return localDate.format(dateTimeFormatter);
    }

    /**
     * 年と月を合わせてreturnする。
     *
     * @param year  年
     * @param month 月
     * @return 年月(yyyyMM)
     */
    public String toStringYearMonth(int year, int month) {
        String stringYear = Integer.toString(year);
        String stringMonth = String.format("%02d", month);

        return stringYear + stringMonth;
    }

    /**
     * 年月に1日を追加し、LocalDateに変換してreturnする。
     *
     * @param yearMonth 年月
     * @return 年月の1日(yyyyMM01)
     */
    public LocalDate BeginningOfMonth(String yearMonth) {
        String strYearMonthDay = yearMonth + "01";

        return LocalDate.parse(strYearMonthDay, DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

    /**
     * 分を時間・分のフォーマットに変換してreturnする。
     *
     * @param totalTime 分
     * @return 時間・分(hh時間mm分, hhh時間mm分, etc.)
     */
    public String getTotalTime(int totalTime) {
        int hour = totalTime / 60;
        int minute = totalTime % 60;

        return hour + "時間" + minute + "分";
    }

    /**
     * Stringの年月日をLocalDate型に変換してreturnする。
     *
     * @param yyyyMMdd 年月日
     * @return 年月日(yyyyMMdd)
     */
    public LocalDate createDate(String yyyyMMdd) {

        return LocalDate.parse(yyyyMMdd, DateTimeFormatter.ofPattern("yyyyMMdd"));
    }
}
