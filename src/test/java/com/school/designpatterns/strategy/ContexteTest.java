package com.school.designpatterns.strategy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ContexteTest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void usesDefaultStrategyWhenNoneIsSet() {
        Contexte contexte = new Contexte();
        contexte.effectuerOperation();
        assertTrue(out.toString().contains("Stratégie par défaut"));
    }

    @Test
    void delegatesToInjectedStrategy() {
        Contexte contexte = new Contexte();
        contexte.setStrategy(new StrategyImpl2());
        contexte.effectuerOperation();
        assertTrue(out.toString().contains("Stratégie 2"));
    }

    @Test
    void switchesStrategyDynamically() {
        Contexte contexte = new Contexte();
        contexte.setStrategy(new StrategyImpl1());
        contexte.effectuerOperation();

        contexte.setStrategy(new StrategyImpl3());
        contexte.effectuerOperation();

        String output = out.toString();
        assertTrue(output.contains("Stratégie 1"));
        assertTrue(output.contains("Stratégie 3"));
    }
}
