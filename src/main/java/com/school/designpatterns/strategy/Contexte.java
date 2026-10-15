package com.school.designpatterns.strategy;

public class Contexte {
    private Strategy strategy;

    public Contexte() {
        this.strategy = new DefaultStrategy();
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void effectuerOperation() {
        System.out.println("**********");
        strategy.operationStrategy();
        System.out.println("**********");
    }
}
