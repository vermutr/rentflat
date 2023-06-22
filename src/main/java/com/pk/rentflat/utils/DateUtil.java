package com.pk.rentflat.utils;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;

@UtilityClass
public class DateUtil {

    public static final String PATTERN_yyyyMMdd = "yyyy-MM-dd";

    public static final DateFormat DF_yyyyMMdd = new SimpleDateFormat(PATTERN_yyyyMMdd);

    public static LocalDate toyyyyMMddString(String dateString) {
        if (StringUtils.isEmpty(dateString)) {
            return null;
        }
        try {
            return DF_yyyyMMdd
                    .parse(dateString).toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
        } catch (ParseException e) {
            return null;
        }
    }
}
