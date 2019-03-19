package com.gildedrose.items;

import com.gildedrose.GildedHelper;
import com.gildedrose.IQualityCheckerAgent;
import com.gildedrose.Item;

public class BackstagePassesItem extends Item implements IQualityCheckerAgent {
    public BackstagePassesItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        this.updateQuality();
    }

    @Override
    public void updateQuality() {
        // Update quality
        this.quality = GildedHelper.updateQualityByValue(this.quality, 1);
        if (this.sellIn < 11) {
            this.quality = GildedHelper.updateQualityByValue(this.quality, 1);
        }
        if (this.sellIn < 6) {
            this.quality = GildedHelper.updateQualityByValue(this.quality, 1);
        }

        // Update SellIn
        this.sellIn = GildedHelper.updateSellInValue(this.sellIn, -1);
        // Check when sellIn < 0
        if (this.sellIn < 0) {
            this.quality = GildedHelper.updateQualityByValue(this.quality, -this.quality);
        }
    }
}
