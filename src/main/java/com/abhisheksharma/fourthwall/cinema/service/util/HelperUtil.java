package com.abhisheksharma.fourthwall.cinema.service.util;

import com.abhisheksharma.fourthwall.cinema.config.Constants;

import java.time.format.DateTimeFormatter;

public class HelperUtil {

    public static final DateTimeFormatter getUSDateFormat(){
        return DateTimeFormatter.ofPattern(Constants.US_DATE_FORMAT);
    }

    public static final DateTimeFormatter getTimeFormat(){
        return DateTimeFormatter.ofPattern(Constants.TIME_FORMAT);
    }
}
