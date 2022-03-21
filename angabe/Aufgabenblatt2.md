# Aufgabenblatt 2

## Allgemeine Anmerkungen
Ihre Lösung für dieses Aufgabenblatt ist bis Montag, 28.3. 11h durch `git commit` und `push` 
abzugeben. Mit der Angabe werden folgende Dateien mitgeliefert: `BodyQueue.java`, `BodyForceMap.java` und `Aufgabe2Test.java`. Diese Klassen dürfen nur an den Stellen verändert werden, die mit TODO markiert sind. Zusätzliche Klassen, Interfaces, Methoden und Variablen dürfen aber eingefügt werden. Wenn Sie zusätzlich zu den gefragten Klassen, weitere Klassen definieren, achten Sie darauf, dass die Klassennamen mit `My` beginnen, um Konflikte mit späteren Aufgabenblättern zu vermeiden.

## Ziel
Ziel der Aufgabe ist die Implementierung einer linearer und einer assoziativen Datenstruktur (siehe Skriptum Seiten 50-59).

## Beschreibung der gegebenen Dateien
- `BodyQueue` ist das Gerüst für eine Implementierung einer linearer Datenstruktur zur Verwaltung 
von Objekten des Typs `Body`.
- `BodyForceMap` ist das Gerüst für eine Implementierung einer assoziativen Datenstruktur, die 
einen Himmelskörper mit der auf ihn wirkenden Kraft assoziiert.
- `Aufgabe2Test` ist eine vorgegebene Klasse, die Sie zum Testen Ihrer Implementierung verwenden 
sollten. Bei einer fehlerfreien Implementierung sollten bei der Ausführung dieser Klasse keine Exceptions geworfen werden und alle Tests als erfolgreich ("successful") ausgegeben werden. Sie müssen diese Klasse nicht verändern, können aber eigene Testfälle hinzufügen. 

## Aufgaben

Ihre Aufgaben sind folgende:

1. Fügen Sie in der Klasse `Body` eine öffentliche Objektmethode `mass()` hinzu, die die Masse des Himmelkörpers zurückliefert.
2. Vervollständigen Sie die Klassendefinitionen in `BodyQueue.java` gemäß der Kommentare in den Dateien. Die Implementierung soll mit Hilfe eines Arrays erfolgen. Bei der Erzeugung soll das Array die Länge haben, die im Konstruktor angegeben wird. Diese wird verdoppelt sobald alle Plätze belegt sind. Benutzen Sie keine vorgefertigten Klassen aus dem Java-Collection-Framework!
3. Vervollständigen Sie die Klassendefinition in `BodyForceMap.java`. Die Implementierung soll mit Hilfe eines Arrays erfolgen.  Benutzen Sie keine vorgefertigten Klassen aus dem Java-Collection-Framework!  Implementieren Sie diese Klasse so, dass die Einträge im Array nach der Masse der Himmelskörper absteigend sortiert sind. Das erhöht zwar den Aufwand beim erstmaligen Eintragen eines Schlüssels-Werte-Paars (Methode `put`), da alle Positionen ab der Einfügeposition verschoben werden müssen, es ermöglicht aber eine schnellere Suche nach dem Schlüssel (Methode `get`) mittels binärer Suche. Folgendes Beispiel zeigt die binäre Suche nach der Einfügeposition in einem absteigend sortierten Array. Mit einer entsprechenden zusätzlichen Überprüfung kann auf diese Weise auch der Schlüssel gefunden werden (z.B. `if (keys[middle] == toFind)` ...). Geordnet sind die Einträge nach der Masse, den Schlüssel bildet aber der Himmelskörper. 

    ```
     Body[] keys; // assume descending order according to mass
     Body toInsert;
     ...
     
     int left = 0;
     int right = size - 1;
     
     while (left <= right) {
         int middle = left + ((right - left) / 2);
         if (keys[middle].mass() < toInsert.mass()) {
             right = middle - 1;
         } else {
             left = middle + 1;
         }
     }
     
     // index where to insert: right + 1
   ```
4. Bauen Sie die bereits bestehende Klasse `Simulation` so um, dass keine Kollisionen von Himmelskörpern mehr berücksichtigt werden. Dadurch soll der Programmcode vereinfacht werden. Die Anzahl der Himmelskörper ändert sich im Laufe der Simulation somit nicht. Testen Sie die Simulation.
5. Ändern Sie nun die Klasse `Simulation` so, dass zur Verwaltung der Himmelskörper anstelle des Arrays Objekte der Klassen `BodyQueue` und `BodyForceMap` verwendet werden. Das heißt beispielsweise, dass die Zugriffe auf die Himmelskörper der Simulation über Methoden von `BodyQueue` erfolgen müssen. Anstelle des Arrays `forceOnBody` soll ein Objekt des Typs `BodyForceMap` benutzt werden. 
6. Testen Sie die Simulation wieder. Das Verhalten der Simulation sollte unverändert sein. Je nach Implementierung der Klassen `BodyQueue` und `BodyForceMap` ist es möglich (und kein Problem), dass die Simulation jetzt langsamer läuft, als nach dem Umbau in Schritt 4.
7. (Freiwillige Zusatzaufgabe ohne Bewertung:) Testen Sie die Simulation mit den folgenden fünf 
Himmelskörpern: 
```
   Body sun = new Body(1.989e30,new Vector3(0,0,0),new Vector3(0,0,0));
   Body earth = new Body(5.972e24,new Vector3(-1.394555e11,5.103346e10,0),new Vector3(-10308.53,-28169.38,0));
   Body mercury = new Body(3.301e23,new Vector3(-5.439054e10,9.394878e9,0),new Vector3(-17117.83,-46297.48,-1925.57));
   Body venus = new Body(4.86747e24,new Vector3(-1.707667e10,1.066132e11,2.450232e9),new Vector3(-34446.02,-5567.47,2181.10));
   Body mars = new Body(6.41712e23,new Vector3(-1.010178e11,-2.043939e11,-1.591727E9),new Vector3(20651.98,-10186.67,-2302.79));
```

#### _Punkteaufteilung_

- Implementierung von `BodyQueue`: 2 Punkte
- Implementierung von `BodyForceMap`: 2 Punkte
- Anpassung von `Simulation`: 1 Punkt
- Gesamt: 5 Punkte 


