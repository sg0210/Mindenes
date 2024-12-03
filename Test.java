package src.Classes;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void testCreatingOrder() {
        // 1. Teszt adatok előkészítése
        Meal meal1 = new Meal("Pizza", 2000); // Példa Meal osztály
        Meal meal2 = new Meal("Burger", 1500);
        Meal meal3 = new Meal("Pasta", 1800);

        ArrayList<Meal> meals = new ArrayList<>();
        meals.add(meal1);
        meals.add(meal2);
        meals.add(meal3);

        int orderNumber = 1;

        // 2. A tesztelt metódus meghívása
        Order order = new Order();
        ArrayList<Basket> baskets = new ArrayList<>();
        baskets.add(new Basket(meal1, 2)); // Feltételezzük, hogy 2 pizzát rendeltek
        baskets.add(new Basket(meal2, 1)); // Feltételezzük, hogy 1 burgert rendeltek

        order.creatingOrder(meals, orderNumber);

        // 3. Assert hívások az eredmény ellenőrzésére
        assertNotNull(order.getBaskets(), "The baskets should not be null");
        assertEquals(2, order.getBaskets().size(), "The order should contain 2 baskets");
        assertEquals(1, order.getOrder_number(), "Order number should be 1");

        Basket firstBasket = order.getBaskets().get(0);
        assertEquals("Pizza", firstBasket.getMeal().getName(), "First basket should contain Pizza");
        assertEquals(2, firstBasket.getQuantity(), "Quantity of the first basket should be 2");

        Basket secondBasket = order.getBaskets().get(1);
        assertEquals("Burger", secondBasket.getMeal().getName(), "Second basket should contain Burger");
        assertEquals(1, secondBasket.getQuantity(), "Quantity of the second basket should be 1");
    }
}
