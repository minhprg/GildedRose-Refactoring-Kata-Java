package com.gildedrose.items;

import com.gildedrose.GildedHelper;
import com.gildedrose.IQualityCheckerAgent;
import com.gildedrose.Item;

public class NormalItem extends Item implements IQualityCheckerAgent {
    public NormalItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        this.updateQuality();
    }

    @Override
    public void updateQuality() {
        // The quality of a normal item decreases in value
        this.quality = GildedHelper.updateQualityByValue(this.quality, -1);
        // Update sellIn
        this.sellIn = GildedHelper.updateSellInValue(this.sellIn, -1);
        // If sellIn is expired, the item decreases twice as fast
        if (this.sellIn < 0) {
            this.quality = GildedHelper.updateQualityByValue(this.quality, -1);
        }
    }
}
