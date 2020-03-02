package by.epam.jwd.yakovlev.xmlparser.util;

import java.util.GregorianCalendar;

public class DateTimeUtil {

    private static final String DATE_FIELD_DELIMITER = "-";
    private static final int DATE_FIELD_COUNT = 3;
    private static final int ZERO = 0;

    public GregorianCalendar parseToDate(String string){

        if (string == null) {
            return null;
        }

        String[] dateFields = string.split(DATE_FIELD_DELIMITER);

        if (dateFields.length != 3){
            return null;
        }

        int[] dateIntFields = new int[DATE_FIELD_COUNT];

        for (int i = 0; i < 3; i++){

            try {
                dateIntFields[i] = Integer.parseInt(dateFields[i]);
            } catch (NumberFormatException e){
                return null;
            }
        }

        return new GregorianCalendar(
                dateIntFields[0], dateIntFields[1], dateIntFields[2], ZERO, ZERO);
    }
}
