package com.school.designpatterns.strategy;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ShoppingCartTest {

    @Test
    void usesSelectedStrategy() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        ShoppingCart cart = new ShoppingCart();
        cart.setPaymentStrategy(new PaypalPayment());
        cart.checkout(42.0);

        assertTrue(out.toString().contains("PayPal"));
    }
}
