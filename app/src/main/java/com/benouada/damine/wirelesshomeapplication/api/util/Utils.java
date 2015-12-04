package com.benouada.damine.wirelesshomeapplication.api.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;

// Helper Class
public class Utils {

    // Format Mac Address
    public static String formatMacAddress(String macAddress) {
        if (macAddress == null) {
            return null;
        }

        String stringWithoutColons = macAddress.replace(":", "");
        if (stringWithoutColons.length() != 12) {
            return macAddress;
        }

        StringBuffer sbMacData = new StringBuffer();
        sbMacData.append(stringWithoutColons.substring(0, 2)).append(":")
                .append(stringWithoutColons.substring(2, 4)).append(":")
                .append(stringWithoutColons.substring(4, 6)).append(":")
                .append(stringWithoutColons.substring(6, 8)).append(":")
                .append(stringWithoutColons.substring(8, 10)).append(":")
                .append(stringWithoutColons.substring(10, 12));

        return sbMacData.toString();
    }

    // Date
    public static Date stringToDate(String dateString, String timeZone) {
        DateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", new Locale("en_gb"));
        dateFormate.setTimeZone(TimeZone.getTimeZone(timeZone));

        Date date = null;
        try {
            date = dateFormate.parse(dateString);
        } catch (ParseException e) {
            return null;
        }
        return date;
    }

    public static Date stringToDateForTime(String dateString) {
        DateFormat dateFormate = new SimpleDateFormat("HH:mm:ss", new Locale("en_gb"));
        dateFormate.setTimeZone(TimeZone.getTimeZone("UTC"));

        Date date = null;
        try {
            date = dateFormate.parse(dateString);
        } catch (ParseException e) {
            return null;
        }
        return date;
    }

    // Returns a pseudo-random number between min and max, inclusive.
    public static int randomInteger(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    // List<Double> --> Float[]
    public static float[] getFloatArrayFromDoubleList(ArrayList<Double> list) {
        return new float[]{Float.valueOf(String.valueOf(list.get(0)))
                , Float.valueOf(String.valueOf(list.get(1)))};

    }

    //  empty List<T> ?
    public static <T> boolean emptyList(List<T> list) {
        return list == null || list.isEmpty();
    }

    // empty string ?
    public static boolean emptyString(String s) {
        return s == null || s.trim().length() == 0;
    }
}
