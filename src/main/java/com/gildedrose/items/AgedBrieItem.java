package com.gildedrose.items;

import com.gildedrose.GildedHelper;
import com.gildedrose.IQualityCheckerAgent;
import com.gildedrose.Item;

public class AgedBrieItem extends Item implements IQualityCheckerAgent {
    public AgedBrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        this.updateQuality();
    }

    @Override
    public void updateQuality() {
        // Increase Quality
        this.quality = GildedHelper.updateQualityByValue(this.quality, 1);
        // Update sellIn
        this.sellIn = GildedHelper.updateSellInValue(this.sellIn, -1);
        // Check sellIn
        if (this.sellIn < 0) {
            // Increase twice as fast
            this.quality = GildedHelper.updateQualityByValue(this.quality, 1);
        }
    }
}
