package com.gildedrose;

public class GildedHelper {
    /**
     * This method updates the quality of an item based on some constraints:
     * - The Quality of an item is never negative
     * - The Quality of an item is never more than 50
     *
     * @param quality
     * @param changeInValue
     * @return Updated quality based on the condition
     */
    public static int updateQualityByValue(int quality, int changeInValue) {
        int newValue = quality + changeInValue;
        if (newValue < 0) {
            return 0;
        }
        else if (newValue <= 50) {
            return newValue;
        }
        else {
            return quality;
        }
    }

    /**
     * This method updates the value of sellIn by a value
     * @param sellInt
     * @param changeValue
     * @return
     */
    public static int updateSellInValue(int sellInt, int changeValue) {
        return sellInt + changeValue;
    }
}
