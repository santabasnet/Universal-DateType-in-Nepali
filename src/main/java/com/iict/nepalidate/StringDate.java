package com.iict.nepalidate;

import static com.iict.nepalidate.Global.MAX_WORD_COUNT;

/**
 * This class is a part of the package com.iict.nepalidate and the package
 * is a part of the project NepaliDate.
 * <p>
 * Connecting Creations Pvt. Ltd. Lalitpur, Nepal.
 * https://c2.my/
 * <p>
 * Created by santa on 2022-07-17.
 */
public class StringDate {

    private final String strDate;
    private int strIndex;
    private int wordCount;

    /**
     * Default Constructor.
     * @param strDate
     */
    public StringDate(String strDate) {
        /**
         * Initialize the variables (Non-final)
         */
        this.strDate = strDate.trim();
        this.strIndex = 0;
        this.wordCount = 0;
        //End of initialization
    }

    //Return next word if available, Empty string if end of limit
    public String GetNextWord() {
        StringBuilder result = new StringBuilder("");
        while (this.strIndex < this.strDate.length()) {
            //Check if the look ahead pointer crosses the maximum limit of word count or not.
            if (this.wordCount > MAX_WORD_COUNT) break;

            //End of checking look ahead pointer.
            if (IsSpecialCharacter(this.strDate.charAt(this.strIndex))) {
                this.wordCount++;
                this.strIndex++;
                //Check if there are more special characters or not, if yes advance pointer
                while (this.strIndex < this.strDate.length()) {
                    if (IsSpecialCharacter(this.strDate.charAt(this.strIndex))) this.strIndex++;
                    else break;//Break if there is no more special character.
                }
                //End of checking special characters
                break; //Break for current word
            } else {
                result.append(this.strDate.charAt(this.strIndex++));
            }
        }
        return (result.toString());
    }

    public void resetDate() {
        this.strIndex = 0;
        this.wordCount = 0;
    }

    // Special character are used for word delimiter.
    private boolean IsSpecialCharacter(char tChar) {
        switch (tChar) {
            case ' ':
            case ',':
            case '/':
            case '-':
                return true;
            default:
                return false;
        }
    }
    //End of word delimiter
}
