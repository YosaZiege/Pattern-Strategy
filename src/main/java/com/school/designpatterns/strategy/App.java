package com.school.designpatterns.strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Contexte contexte = new Contexte();
        Map<String, Strategy> strategyMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Quelle stratégie ? ");
            String strategyName = scanner.nextLine();

            Strategy strategy = strategyMap.get(strategyName);
            if (strategy == null) {
                try {
                    Class<?> clazz = Class.forName(strategyName);
                    strategy = (Strategy) clazz.getDeclaredConstructor().newInstance();
                    strategyMap.put(strategyName, strategy);
                    System.out.println("Création d'un nouvel objet : " + strategyName);
                } catch (Exception e) {
                    System.out.println("Stratégie introuvable : " + strategyName);
                    continue;
                }
            }

            contexte.setStrategy(strategy);
            contexte.effectuerOperation();
        }
    }
}
