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

    public static final String PATTERN_MMddyyyy_slash = "MM/dd/yyyy";

    public static final DateFormat DF_MMddyyyy_slash = new SimpleDateFormat(PATTERN_MMddyyyy_slash);

    public static LocalDate toMMddyyyySlashString(String dateString) {
        if (StringUtils.isEmpty(dateString)) {
            return null;
        }
        try {
            return DF_MMddyyyy_slash
                    .parse(dateString).toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
        } catch (ParseException e) {
            return null;
        }
    }
}
