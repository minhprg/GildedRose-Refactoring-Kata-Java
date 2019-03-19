package com.gildedrose;

import com.gildedrose.items.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            // For each item, we decide the type of it based on its name and then
            // we redefine this item under its appropriate child class
            if (items[i].name.equals(ItemTypes.AGED_BRIE.getName())) {
                items[i] = new AgedBrieItem(items[i].name, items[i].sellIn, items[i].quality);
            }
            else if (items[i].name.equals(ItemTypes.BACKSTAGE_PASSES.getName())) {
                items[i] = new BackstagePassesItem(items[i].name, items[i].sellIn, items[i].quality);
            }
            else if (items[i].name.equals(ItemTypes.SULFURAS.getName())) {
                items[i] = new SulfurasItem(items[i].name, items[i].sellIn, items[i].quality);
            }
            else if (items[i].name.equals(ItemTypes.CONJURED.getName())) {
                items[i] = new ConjuredItem(items[i].name, items[i].sellIn, items[i].quality);
            }
            else {
                items[i] = new NormalItem(items[i].name, items[i].sellIn, items[i].quality);
            }
        }
    }
}