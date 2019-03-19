package com.gildedrose;

enum ItemTypes {
    NORMAL("Normal"),
    AGED_BRIE("Aged Brie"),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"),
    CONJURED("Conjured")
    ;

    private final String itemName;

    // Setter
    ItemTypes(final String itemName) {
        this.itemName = itemName;
    }

    // Getter
    public String getName() {
        return this.itemName;
    }
}
