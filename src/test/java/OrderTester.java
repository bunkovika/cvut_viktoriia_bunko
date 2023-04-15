import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shop.Order;
import shop.ShoppingCart;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTester {
    ShoppingCart cart;

    @BeforeEach
    public void initTest() {
        cart = new ShoppingCart();
    }

    @Test
    public void constructorWithoutStateTest() {
        // ARRANGE
        int expectedState = 0;
        String expectedCustomerName = "Viktoriia";
        String expectedCustomerAddress = "Praha 6";

        // ACT
        Order order = new Order(cart, expectedCustomerName, expectedCustomerAddress);

        // ASSERT
        assertEquals(expectedState, order.getState());
        assertEquals(expectedCustomerName, order.getCustomerName());
        assertEquals(expectedCustomerAddress, order.getCustomerAddress());
    }

    @Test
    public void constructorWithStateTest() {
        // ARRANGE
        int expectedState = 2;
        String expectedCustomerName = "Viktoriia";
        String expectedCustomerAddress = "Praha 6";

        // ACT
        Order order = new Order(cart, expectedCustomerName, expectedCustomerAddress, expectedState);

        // ASSERT
        assertEquals(expectedState, order.getState());
        assertEquals(expectedCustomerName, order.getCustomerName());
        assertEquals(expectedCustomerAddress, order.getCustomerAddress());
    }

    @Test
    public void constructorWithCartNullTest() {
        // ACT + ASSERT
        assertThrows(NullPointerException.class, () -> {
            new Order(null, "Viktoriia", "Praha 6");
        });
    }
}