import org.junit.jupiter.api.Test;
import shop.EShopController;
import shop.Item;
import shop.ShoppingCart;
import shop.StandardItem;
import storage.ItemStock;
import storage.NoItemInStorage;
import storage.Storage;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class EShopControllerTest {

//     Buying 1 product
// 1. Fill the inventory (add 1 product to it)
// 2. Add to cart
// 3. Place an order
// 4. Buy the product (pay for the order)
// 5. Check the inventory (to ensure the product has been deducted from it)
    @Test
    public void shoppingCartTestBuyingOneItemTest() throws NoItemInStorage {
        EShopController.startEShop();
        StandardItem item = new StandardItem(1, "Some name", 10000, "GADGETS", 5);

        // Check if count 0
        assertThrows(IllegalArgumentException.class, () -> {
            EShopController.addItemToStorage(item, 0);
        });

        // Adding whit count 1
        EShopController.addItemToStorage(item, 1);
        ArrayList<ItemStock> itemsFromStorage = new ArrayList<>(EShopController.getItemsFromStorage());

        assertEquals(1, itemsFromStorage.size());
        assertEquals(1, itemsFromStorage.get(0).getCount());
        assertSame(item, itemsFromStorage.get(0).getItem());

        // Cart Creating
        ShoppingCart cart = EShopController.newCart();
        assertEquals(1, EShopController.getCarts().size());
        assertTrue(EShopController.getCarts().contains(cart));
        assertEquals(0, cart.getItemsCount());

        // Adding Item to cart
        cart.addItem(item);
        assertEquals(1, cart.getItemsCount());
        assertTrue(cart.getCartItems().contains(item));

        // Creating an order
        EShopController.purchaseShoppingCart(cart, "Viktoriia", "Praha 6");

        // Count of item has to be 0
        itemsFromStorage = new ArrayList<>(EShopController.getItemsFromStorage()); // update
        assertEquals(1, itemsFromStorage.size());
        assertEquals(0, itemsFromStorage.get(0).getCount());
        assertEquals(1, EShopController.getArchive().getHowManyTimesHasBeenItemSold(item));
    }

    // Buying 1 product
// 1. Fill the inventory (add 5 products to it)
// 2. Add 3 to cart
// 3. Remove 1 product from cart and inventory (stock = 4)
// 4. Place an order (should be prevented)

    @Test
    public void shoppingCartTestBuyingWithNoProductInStorage() throws NoItemInStorage {
        EShopController.startEShop();

        int[] itemCount = {1,1,1,1,1};

        Item[] storageItems = {
                new StandardItem(1, "Sleeping teddy", 500, "GADGETS", 5),
                new StandardItem(2, "Sleeping teddy with USB", 1000, "GADGETS", 10),
                new StandardItem(3, "Screwdriver", 200, "TOOLS", 5),
                new StandardItem(4, "God of War", 1400, "VIDEOGAMES", 20),
                new StandardItem(5, "Shopping cart", 202, "ITEMS", 7),
        };

        for (int i = 0; i < storageItems.length; i++) {
            EShopController.addItemToStorage(storageItems[i], itemCount[i]);
        }

        Storage storage = EShopController.getStorage();

        for (int i = 0; i < storageItems.length; i++) {
            assertEquals(1, storage.getItemCount(storageItems[i]));
        }

        // Cart Creating
        ShoppingCart cart = EShopController.newCart();
        assertEquals(1, EShopController.getCarts().size());
        assertTrue(EShopController.getCarts().contains(cart));
        assertEquals(0, cart.getItemsCount());

        // Adding Item to cart (3 items)
        cart.addItem(storageItems[0]);
        cart.addItem(storageItems[1]);
        cart.addItem(storageItems[2]);

        ArrayList<Item> cartItems = cart.getCartItems();

        assertEquals(3, cart.getItemsCount());

        assertTrue(cart.getCartItems().contains(storageItems[0]));
        assertTrue(cart.getCartItems().contains(storageItems[1]));
        assertTrue(cart.getCartItems().contains(storageItems[2]));

        // Removing 1 item of cart from storage
        storage.removeItems(storageItems[1], 1);
        assertEquals(0, storage.getItemCount(storageItems[1]));

        assertThrows(NoItemInStorage.class, () -> {
            EShopController.purchaseShoppingCart(cart, " some name", "Bla  29");
        });
    }
}