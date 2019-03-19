package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {
    // Once the sell by date has passed, Quality degrades twice as fast
    @Test
    public void qualityDegradesTwiceAsFast() {
        Item[] items = new Item[] {
                new Item(ItemTypes.NORMAL.getName(), -1, 10),
                new Item(ItemTypes.NORMAL.getName(), 10, 10),
                new Item(ItemTypes.CONJURED.getName(), 10, 10)
        };
        // Create an instance of the app
        GildedRose app = new GildedRose(items);
        // Call the update quality method
        app.updateQuality();

        assertEquals(-2, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);

        assertEquals(9, app.items[1].sellIn);
        assertEquals(9, app.items[1].quality);

        assertEquals(9, app.items[2].sellIn);
        assertEquals(8, app.items[2].quality);
    }

    // The Quality of an item is never negative
    @Test
    public void nonNegativeQuality() {
        Item[] items = new Item[] {
                new Item(ItemTypes.NORMAL.getName(), 10, 0)
        };
        // Create an instance of the app
        GildedRose app = new GildedRose(items);
        // Call the update quality method
        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    // "Aged Brie" actually increases in Quality the older it gets
    @Test
    public void agedBrieTwiceQualityIncrementWhenOlder() {
        Item[] items = new Item[] {
                new Item(ItemTypes.AGED_BRIE.getName(), 10, 10)
        };
        // Create an instance of the app
        GildedRose app = new GildedRose(items);
        // Call the update quality method
        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    // The Quality of an item is never more than 50
    @Test
    public void itemQualityUpperBoundChecking() {
        Item[] items = new Item[] {
                new Item(ItemTypes.AGED_BRIE.getName(), 10, 50)
        };
        // Create an instance of the app
        GildedRose app = new GildedRose(items);
        // Call the update quality method
        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    // "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    @Test
    public void sulfurasInvincibility() {
        Item[] items = new Item[] {
                new Item(ItemTypes.SULFURAS.getName(), 10, 80)
        };
        // Create an instance of the app
        GildedRose app = new GildedRose(items);
        // Call the update quality method
        app.updateQuality();

        assertEquals(10, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    /**
     * "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
     * 	Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
     * 	Quality drops to 0 after the concert
     */
    @Test
    public void backStagePassesCheck() {
        Item[] items = new Item[] {
                new Item(ItemTypes.BACKSTAGE_PASSES.getName(), 10, 10),
                new Item(ItemTypes.BACKSTAGE_PASSES.getName(), 5, 10),
                new Item(ItemTypes.BACKSTAGE_PASSES.getName(), -1, 10)
        };
        // Create an instance of the app
        GildedRose app = new GildedRose(items);
        // Call the update quality method
        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);

        assertEquals(4, app.items[1].sellIn);
        assertEquals(13, app.items[1].quality);

        assertEquals(-2, app.items[2].sellIn);
        assertEquals(0, app.items[2].quality);
    }

    // "Conjured" items degrade in Quality twice as fast as normal items
    @Test
    public void conjuredItemQualityCheck() {
        Item[] items = new Item[] {
                new Item(ItemTypes.CONJURED.getName(), 10, 10),
                new Item(ItemTypes.CONJURED.getName(), -1, 10)
        };
        // Create an instance of the app
        GildedRose app = new GildedRose(items);
        // Call the update quality method
        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);

        assertEquals(-2, app.items[1].sellIn);
        assertEquals(6, app.items[1].quality);
    }
}
