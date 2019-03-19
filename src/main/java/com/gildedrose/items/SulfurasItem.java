package com.gildedrose.items;

import com.gildedrose.IQualityCheckerAgent;
import com.gildedrose.Item;

public class SulfurasItem extends Item implements IQualityCheckerAgent {
    public SulfurasItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        this.updateQuality();
    }

    @Override
    public void updateQuality() {
        // Legendary item, never be changed in Quality or SellIn
    }
}
