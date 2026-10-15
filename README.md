# Pattern Strategy

Reprise de l'implémentation du pattern Strategy (Activité Pratique N°1).

## Objectif

Le pattern Strategy (comportement) permet de définir une **famille d'algorithmes**,
d'encapsuler chacun dans une classe séparée, et de les rendre **interchangeables**,
tout en laissant chaque algorithme **évoluer indépendamment** des clients qui l'utilisent.

## Structure

- `Strategy` : interface avec une seule méthode `operationStrategy()`.
- `DefaultStrategy`, `StrategyImpl1`, `StrategyImpl2`, `StrategyImpl3` :
  implémentations de la famille d'algorithmes.
- `Contexte` : le client, lié à l'interface `Strategy` (couplage faible).
  Sa méthode `effectuerOperation()` délègue la partie variable à la stratégie.
- `App` : application qui choisit la stratégie au moment de l'exécution
  (instanciation dynamique via `Class.forName`), avec un cache mémoire (`Map`)
  pour éviter de recréer plusieurs fois la même instance.

## Exécution

```bash
mvn test          # lance les tests JUnit
mvn compile       # compile

# lancer l'application (saisir le nom complet de la classe, ex. :
# com.school.designpatterns.strategy.StrategyImpl1)
mvn exec:java -Dexec.mainClass="com.school.designpatterns.strategy.App"
```

L'application tourne en boucle : elle demande le nom d'une classe de stratégie,
l'instancie (une seule fois grâce au cache), l'injecte dans le contexte, puis
exécute l'opération.
