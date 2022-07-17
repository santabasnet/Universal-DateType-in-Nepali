package com.iict.nepalidate;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class is a part of the package com.iict.nepalidate and the package
 * is a part of the project NepaliDate.
 * <p>
 * Integrated ICT Pvt. Ltd. Lalitpur, Nepal.
 * https://www.iict.com.np/
 * <p>
 * Created by Santa on 2015-07-17.
 */
public class Global {
    /**
     * State Constants
     **/
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int FOUR = 4;
    public static final int FIVE = 5;
    public static final int SIX = 6;
    public static final int SEVEN = 7;
    public static final int EIGHT = 8;
    public static final int NINE = 9;
    public static final int TEN = 10;

    public static final int DEAD_STATE = 50; //Used as dead state in state diagram.

    /**
     * Initial Data as final variable
     **/
    public static final String[] YEAR_MONTHS = {
            "बैसाख", "जेष्ठ", "जेठ", "जेस्ठ", "असार", "आषाढ़", "साउन", "श्रावण", "भदौ", "भाद्र", "आस्विन", "असोज", "कार्तिक", "कात्तिक", "मार्ग", "मंसिर", "पुष", "पुस", "पौस", "पौष", "माघ", "फाल्गुन", "फागुन", "चैत", "चैत्र"
    };
    public static final String[] WEEK_DAYS = {
            "आइतवार", "आइतबार", "सोमवार", "सोमबार", "मङ्गलवार", "मंगलवार", "मङ्गलबार", "मंगलबार", "बुधवार", "बुधबार", "बिहिवार", "बिहिबार", "शुक्रवार", "शुक्रबार", "शनिवार", "शनिबार"
    };
    public static final String digit = "[०१२३४५६७८९]"; //Used for regular expression
    public static final String DATE_INDICATOR = "गते"; //Indicates end of date expression
    public static final ArrayList<Integer> FINAL_STATES = new ArrayList<>(Arrays.asList(NINE, TEN)); //Final states

    public static final int MAX_WORD_COUNT = 5;
}
