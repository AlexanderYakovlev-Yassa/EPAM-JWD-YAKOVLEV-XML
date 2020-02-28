package by.epam.jwd.yakovlev.xmlparser.util;

import java.util.GregorianCalendar;

public class DateTimeUtil {

    private static final String DASH = "-";
    private static final int THREE = 3;
    private static final int ZERO = 0;

    public GregorianCalendar parseToDate(String string){

        if (string == null) {
            return null;
        }

        String[] dateFields = string.split(DASH);

        if (dateFields.length != 3){
            return null;
        }

        int[] dateIntFields = new int[THREE];

        for (int i = 0; i < 3; i++){

            try {
                dateIntFields[i] = Integer.valueOf(dateFields[i]);
            } catch (NumberFormatException e){
                return null;
            }
        }

        GregorianCalendar resDate = new GregorianCalendar(
                dateIntFields[0], dateIntFields[1], dateIntFields[2], ZERO, ZERO);

        return resDate;
    }
}
