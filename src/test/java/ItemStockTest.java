import org.junit.Test;
import shop.Item;
import storage.ItemStock;

import static org.junit.Assert.*;


public class ItemStockTest {

    @Test
    public void testConstructor() {
        Item item = new Item(1, "Item 1" , 10, "category 1");
        ItemStock itemStock = new ItemStock(item);
        assertEquals(item, itemStock.getItem());
        assertEquals(0, itemStock.getCount());
    }

    @Test
    public void testIncreaseItemCount() {
        Item item = new Item(1, "Item 1" , 10, "category 1");
        ItemStock itemStock = new ItemStock(item);
        itemStock.IncreaseItemCount(5);
        assertEquals(5, itemStock.getCount());
        itemStock.IncreaseItemCount(3);
        assertEquals(8, itemStock.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIncreaseItemCountWithInvalidArgument() {
        Item item = new Item(1, "Item 1" , 10, "category 1");
        ItemStock itemStock = new ItemStock(item);
        itemStock.IncreaseItemCount(0);
    }

    @Test
    public void testDecreaseItemCount() {
        Item item = new Item(1, "Item 1" , 10, "category 1");
        ItemStock itemStock = new ItemStock(item);
        itemStock.IncreaseItemCount(10);
        itemStock.decreaseItemCount(5);
        assertEquals(5, itemStock.getCount());
        itemStock.decreaseItemCount(3);
        assertEquals(2, itemStock.getCount());
    }

    @Test
    public void testDecreaseItemCountWhenCountIsZero() {
        Item item = new Item(1, "Item 1" , 10, "category 1");
        ItemStock itemStock = new ItemStock(item);
        itemStock.decreaseItemCount(5);
        assertEquals(0, itemStock.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecreaseItemCountWithInvalidArgument() {
        Item item = new Item(1, "Item 1" , 10, "category 1");
        ItemStock itemStock = new ItemStock(item);
        itemStock.decreaseItemCount(0);
    }

    @Test
    public void testSetCount() {
        Item item = new Item(1, "Item 1" , 10, "category 1");
        ItemStock itemStock = new ItemStock(item);
        itemStock.setCount(5);
        assertEquals(5, itemStock.getCount());
        itemStock.setCount(0);
        assertEquals(0, itemStock.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCountWithInvalidArgument() {
        Item item = new Item(1, "Item 1" , 10, "category 1");
        ItemStock itemStock = new ItemStock(item);
        itemStock.setCount(-1);
    }
}


