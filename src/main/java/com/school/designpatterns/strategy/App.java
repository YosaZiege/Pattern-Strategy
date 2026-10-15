package com.school.designpatterns.strategy;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Contexte contexte = new Contexte();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Quelle stratégie ? ");
            String strategyName = scanner.nextLine();

            try {
                Class<?> clazz = Class.forName(strategyName);
                Strategy strategy = (Strategy) clazz.getDeclaredConstructor().newInstance();
                contexte.setStrategy(strategy);
                contexte.effectuerOperation();
            } catch (Exception e) {
                System.out.println("Stratégie introuvable : " + strategyName);
            }
        }
    }
}
