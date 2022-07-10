package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;


class ShoppingCartTest {

    private ShoppingCart shoppingCart;

    @Test
    void thereShouldBeAnEmptyShoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Assertions.assertEquals(0, shoppingCart.getProductList().size());
    }

    @Test
    void shouldAddProductsToShoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product product = new Product("Dove Soap", 39.99);
        shoppingCart.addItem(product, 5);

        Assertions.assertEquals(5, shoppingCart.getProductList().get(product));
        Assertions.assertEquals(199.95, shoppingCart.calculateTotalPrice());
    }

    @Test
    void shouldAddExtraQuantityToTheShoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product product = new Product("Dove Soap", 39.99);
        shoppingCart.addItem(product, 5);
        shoppingCart.addItem(product, 3);

        Assertions.assertEquals(8, shoppingCart.getProductList().get(product));
        Assertions.assertEquals(319.92, shoppingCart.calculateTotalPrice());
    }

    @Test
    void shouldAddDifferentProductToTheCart(){
        ShoppingCart shoppingCart = new ShoppingCart();
        Product dove = new Product("Dove Soap", 39.99);
        shoppingCart.addItem(dove, 2);
        Product axeDeo = new Product("Axe Deo", 99.99);
        shoppingCart.addItem(axeDeo, 2);

        Assertions.assertEquals(2, shoppingCart.getProductList().get(dove));
        Assertions.assertEquals(2, shoppingCart.getProductList().get(axeDeo));
        Assertions.assertEquals(314.95, shoppingCart.calculateTotalPrice());
    }

}
