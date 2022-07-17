package com.iict.nepalidate;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class is a part of the package com.iict.nepalidate and the package
 * is a part of the project NepaliDate.
 * <p>
 * Integrated ICT Pvt. Ltd. Lalitpur, Nepal.
 * https://www.iict.com.np/
 * <p>
 * Created by Santa on 2015-07-17.
 */
public class DateIterator {

    long startDate;
    long endDate;
    static final long oneDayMilSec = 86400000;
    SimpleDateFormat dateFormat;

    public DateIterator(Date startDate, Date endDate) {
        this.startDate = startDate.getTime();
        this.endDate = endDate.getTime();
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    public String getNextDate() {
        String result;
        if (startDate <= endDate) {
            result = dateFormat.format(startDate);
            result = result.replaceAll("-", "/");
            startDate += oneDayMilSec;
        } else {
            result = "";
        }
        return result;
    }

}
