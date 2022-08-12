package utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversions {

    public static String convertCountry(String dbCountry) // short
    {
        String countryFulForm="";

        switch (dbCountry)
        {
            case "IN" : countryFulForm="India";break;
            case "GE" : countryFulForm="Georgia";break;
            case "DE" : countryFulForm="Germany";break;
            case "IL" : countryFulForm="Israel";break;
            case "JP" : countryFulForm="Japan";break;
            case "RO" : countryFulForm="Romania";break;
        }

        return countryFulForm;
    }

    public static String getGenderFullForm(String dbGender)
    {
        String genderFullForm="";

        switch (dbGender)
        {
            case "0" : genderFullForm="Male";break;
            case "1" : genderFullForm="Female";break;
            case "2" : genderFullForm="Other";break;
        }

        return genderFullForm;
    }

    /* Actual - DB format - yyyy-MM-dd
    Expected - Excel format - MM/dd/yyyy */

    public static String convertDate(String dbDateStr) throws ParseException //  yyyy-MM-dd
    {
        String convertedDate="";

        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dbDateStr);

        convertedDate = new SimpleDateFormat("MM/dd/yyyy").format(date) ;

        return convertedDate;
    }

}
