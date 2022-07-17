package com.iict.nepalidateapp;

import com.iict.nepalidate.NepaliDate;

/**
 * This class is a part of the package com.iict.nepalidateapp and the package
 * is a part of the project NepaliDate.
 * <p>
 * Integrated ICT Pvt. Ltd. Lalitpur, Nepal.
 * https://www.iict.com.np/
 * <p>
 * Created by Santa on 2015-07-17.
 */
public class DateApp {

    /**
     * Demo App.
     * @param args
     */
    public static void main(String args[]){
        String textDate = "२०७१ फाल्गुन १० आइतबार";
        NepaliDate instance = new NepaliDate(textDate);
        boolean result = instance.IsValid();
        System.out.println("Date " + textDate + " is " + result + ".");
    }

}
