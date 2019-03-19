package com.gildedrose.items;

import com.gildedrose.GildedHelper;
import com.gildedrose.IQualityCheckerAgent;
import com.gildedrose.Item;

public class ConjuredItem extends Item implements IQualityCheckerAgent {
    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        this.updateQuality();
    }

    @Override
    public void updateQuality() {
        // This is item
        this.quality = GildedHelper.updateQualityByValue(this.quality, -2);
        // Update sellIn
        this.sellIn = GildedHelper.updateSellInValue(this.sellIn, -1);
        // Check sellIn
        if (this.sellIn < 0) {
            // Degrades twice as fast
            this.quality = GildedHelper.updateQualityByValue(this.quality, -2);
        }
    }
}
