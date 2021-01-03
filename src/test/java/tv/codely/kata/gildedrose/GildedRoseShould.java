package tv.codely.kata.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class GildedRoseShould {

    @Test
    public void testThatSellInValueIsDecreased() {
        final Item whateverItem = new Item("whatever", 10, 0);

        GildedRose gildedRose = new GildedRose(Arrays.asList(whateverItem));
        gildedRose.updateQuality();

        assertEquals(whateverItem.getSellIn(), 9);
    }

    @Test
    public void testThatQualityValueIsDecreased() {
        final Item whateverItem = new Item("whatever", 1, 10);

        GildedRose gildedRose = new GildedRose(Arrays.asList(whateverItem));
        gildedRose.updateQuality();

        assertEquals(whateverItem.getQuality(), 9);
    }

    @Test
    public void testThatQualityDecreasesTwiceAsMuchWhenSellByIsPassed() {
        final Item whateverItem = new Item("whatever", 0, 10);

        GildedRose gildedRose = new GildedRose(Arrays.asList(whateverItem));
        gildedRose.updateQuality();

        assertEquals(whateverItem.getQuality(), 8);
    }

    @Test
    public void testThatQualityIsNeverNegative() {
        final Item whateverItem = new Item("whatever", 0, 0);

        GildedRose gildedRose = new GildedRose(Arrays.asList(whateverItem));
        gildedRose.updateQuality();

        assertEquals(whateverItem.getQuality(), 0);
    }

    @Test
    public void testAgedBrieIncreasesQualityWithAge() {
        final Item agedBrie = new Item("Aged Brie", 5, 1);

        GildedRose gildedRose = new GildedRose(Arrays.asList(agedBrie));
        gildedRose.updateQuality();

        assertEquals(agedBrie.getQuality(), 2);
    }

    @Test
    public void testQualityNeverIncreasesPastFifty() {
        final Item agedBrie = new Item("Aged Brie", 5, 50);

        GildedRose gildedRose = new GildedRose(Arrays.asList(agedBrie));
        gildedRose.updateQuality();

        assertEquals(agedBrie.getQuality(), 50);
    }

    @Test
    public void testSulfurasNeverChanges() {
        final Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 25);

        GildedRose gildedRose = new GildedRose(Arrays.asList(sulfuras));
        gildedRose.updateQuality();

        assertEquals(sulfuras.getQuality(), 25);
        assertEquals(sulfuras.getSellIn(), 0);
    }

    @Test
    public void testBackstagePassIncreasesQualityByOneIfSellByGreaterThenTen() {
        final Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20);

        GildedRose gildedRose = new GildedRose(Arrays.asList(backstagePasses));
        gildedRose.updateQuality();

        assertEquals(backstagePasses.getQuality(), 21);
    }

    @Test
    public void testBackstagePassIncreasesQualityByTwoIfSellBySmallerThanTen() {
        final Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20);

        GildedRose gildedRose = new GildedRose(Arrays.asList(backstagePasses));
        gildedRose.updateQuality();

        assertEquals(backstagePasses.getQuality(), 22);
    }

    @Test
    public void testBackstagePassIncreasesQualityByThreeIfSellBySmallerThanFive() {
        final Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);

        GildedRose gildedRose = new GildedRose(Arrays.asList(backstagePasses));
        gildedRose.updateQuality();

        assertEquals(backstagePasses.getQuality(), 23);
    }

    @Test
    public void testBackstagePassLosesValueAfterSellByPasses() {
        final Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);

        GildedRose gildedRose = new GildedRose(Arrays.asList(backstagePasses));
        gildedRose.updateQuality();

        assertEquals(backstagePasses.getQuality(), 0);
    }
}
