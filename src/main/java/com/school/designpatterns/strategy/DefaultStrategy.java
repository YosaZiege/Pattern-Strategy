package com.school.designpatterns.strategy;

public class DefaultStrategy implements Strategy {
    @Override
    public void operationStrategy() {
        System.out.println("Stratégie par défaut");
    }
}
