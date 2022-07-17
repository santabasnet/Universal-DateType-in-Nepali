package com.iict.nepalidate;

import static com.iict.nepalidate.Global.*;

/**
 * This class is a part of the package com.iict.nepalidate and the package
 * is a part of the project NepaliDate.
 * <p>
 * Integrated ICT Pvt. Ltd. Lalitpur, Nepal.
 * https://www.iict.com.np/
 * <p>
 * Created by Santa on 2015-07-17.
 */
public class NepaliDate {

    String newsDate;
    StringDate dateStrObj;

    /**
     * Default Constructor.
     *
     * @param newsDate
     */
    public NepaliDate(String newsDate) {
        //Initialize non final variables.
        this.newsDate = newsDate;
        this.dateStrObj = new StringDate(newsDate);
    }

    /**
     * Checks if the date is valid or not and implemented the designed state diagram.
     *
     * @return true if the given string of valid Nepali date type.
     */
    public boolean IsValid() {
        int currentState = ZERO;
        String strToken = dateStrObj.GetNextWord();
        while (!strToken.isEmpty()) {
            switch (currentState) {
                case ZERO:
                    if (isYear(strToken)) currentState = ONE;
                    else if (isDayName(strToken)) currentState = TWO;
                    else if (isDay(strToken)) currentState = THREE;
                    else if (isMonthName(strToken)) currentState = FOUR;
                    else currentState = DEAD_STATE;
                    break;

                case ONE:
                    if (isMonthName(strToken) || isMonth(strToken)) currentState = FIVE;
                    else currentState = DEAD_STATE;
                    break;

                case TWO:
                    if (isMonthName(strToken)) currentState = SIX;
                    else if (isDay(strToken)) currentState = SEVEN;
                    else currentState = DEAD_STATE;
                    break;

                case THREE:
                    if (isMonthName(strToken) || isMonth(strToken)) currentState = EIGHT;
                    else currentState = DEAD_STATE;
                    break;

                case FOUR:
                case SIX:
                    if (isDay(strToken)) currentState = EIGHT;
                    else currentState = DEAD_STATE;
                    break;

                case FIVE:
                    if (isDay(strToken)) currentState = NINE;
                    else currentState = DEAD_STATE;
                    break;

                case SEVEN:
                    if (isMonthName(strToken)) currentState = EIGHT;
                    else currentState = DEAD_STATE;
                    break;

                case EIGHT:
                    if (isYear(strToken)) currentState = TEN;
                    else currentState = DEAD_STATE;
                    break;

                case NINE:
                    if (isDayName(strToken) || IsTime(strToken) || strToken.equals(DATE_INDICATOR)) currentState = TEN;
                    else currentState = DEAD_STATE;
                    break;

                case TEN:
                    break;

                default:
                    currentState = DEAD_STATE;
            }
            strToken = dateStrObj.GetNextWord();
        }
        return (FINAL_STATES.contains(currentState)); //Return if we reach final state or not.
    }
    //End of state diagram implementation.

    //Checks exactly 4 digit Nepali number as a year.
    private boolean isYear(String tStr) {
        return tStr.matches(digit + "{4}");
    }

    //Check two digits Nepali number string and month range.
    private boolean isMonth(String tStr) {
        int value = getValue(tStr);
        return (tStr.matches(digit + "{1,2}") && (value > 0 && value <= 12));
    }

    //Checks two digits Nepali number string and date range.
    private boolean isDay(String tStr) {
        int value = getValue(tStr);
        return (tStr.matches(digit + "{1,2}") && (value > 0 && value <= 31));
    }

    //Checks whether the given string is valid name of the months or not.
    private boolean isMonthName(String tStr) {
        for (String str : YEAR_MONTHS) {
            if (str.equals(tStr)) return true;
        }
        return false;
    }

    //Checks whether the given string is valid name of the week days.
    private boolean isDayName(String tStr) {
        for (String str : WEEK_DAYS) {
            if (str.equals(tStr)) return true;
        }
        return false;
    }

    //Regular Expression to validate the time format, e.g.: ०९:०४
    private boolean IsTime(String tStr) {
        return tStr.matches(digit + "{1,2}:" + digit + "{1,2}");
    }

    /**
     * Calculates Equivalent value of Nepali date components(year, month, day, time)
     */
    private int getValue(String tStr) {
        String eStr = "";
        for (char ch : tStr.toCharArray()) {
            if (ch >= '०' && ch <= '९') {
                eStr += (ch - 0x966); // 0x966 is devanagari unicode zero., can use '०' too.
            } else {
                eStr = "";
                break;
            }
        }
        try {
            //Return integer value of the converted string on success.
            return Integer.parseInt(eStr);
        } catch (Exception ee) {
            //In case of unsuccessful, it returns zero.
            return 0;
        }
    }

    /**
     * Converts and return space delimited string of a given date.
     * We can write some custom formats here if we need it.
     *
     * @return dateString
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("");
        this.dateStrObj.resetDate();
        String strToken = this.dateStrObj.GetNextWord();
        while (!strToken.isEmpty()) {
            result.append(strToken);
            result.append(" ");
            strToken = this.dateStrObj.GetNextWord();
        }
        return result.toString().trim();
    }
}
