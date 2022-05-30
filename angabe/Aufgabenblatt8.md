# Aufgabenblatt 8

## Allgemeine Anmerkungen
Ihre Lösung für dieses Aufgabenblatt ist bis Dienstag, 13.6., 11h durch `git commit` und `git push` 
abzugeben.
Wenn Sie zusätzlich zu den gefragten Klassen und Interfaces weitere Klassen oder 
Interfaces definieren, achten Sie darauf, dass die Klassennamen mit `My` beginnen, um Konflikte 
mit späteren Aufgabenblättern zu vermeiden.

Weiters werden die Dateien `StateFileNotFoundException.java`, 
`StateFileFormatException.java`, `ReadDataUtil.java`, `Simulation8.java`, `Simulation9.java`,
 `Aufgabe8Test.java` und das Verzeichnis `states` mit `txt`-Dateien mitgeliefert. 

## Ziel
Ziel der Aufgabe ist das Verständnis und die Anwendung der Konzepte: Java-Collections, Eingabe mit 
Validierung, Exceptions (S. 110-123).

## Beschreibung der gegebenen Dateien

- [states](../states) ist ein Verzeichnis, in dem mehrere Dateien mit der Endung `.txt` 
 mitgeliefert werden. Diese enthalten Daten von je einem Himmelskörper sowie dessen Positionen und
 Geschwindigkeitsvektoren für alle Tage der Jahre 2019-2021. Die Angaben sind wie gewohnt in 
 kartesischen Koordinaten, wobei die Sonne den Urspung des Koordinatensystems bildet und die 
 Ekliptik die x-y-Ebene darstellt. Die Daten stammen von [https://ssd.jpl.nasa.gov/horizons.cgi#top](https://ssd.jpl.nasa.gov/horizons.cgi#top). 
   
    **ACHTUNG**: Die Werte sind in km bzw. km/sec angegeben! 
                      
- [StateFileNotFoundException](../src/StateFileNotFoundException.java) enthält die Definition
der Klasse `StateFileNotFoundException`. Diese sollen Sie vervollständigen.
- [StateFileFormatException](../src/StateFileFormatException.java) enthält die Definition
der Klasse `StateFileFormatException`. Diese sollen Sie vervollständigen.
- [ReadDataUtil](../src/ReadDataUtil.java) ist eine Klasse mit einer statischen Methode zum
Einlesen von Position- und Bewegungsvektoren von Himmelskörpern aus Dateien. 
Diese sollen Sie vervollständigen.
- [Simulation8](../src/Simulation8.java) ist ein Gerüst für eine ausführbare Klasse. Hier soll
die Simulation analog zur Klasse `Simulation` implementiert werden (damit Sie Ihre [ursprüngliche
 Datei](../src/Simulation.java) nicht überschreiben müssen).
- [Simulation9](../src/Simulation9.java) ist eine leere Datei. Hier soll eine weitere Simulation
implementiert werden, die so wie `Simulation8` funktioniert, mit dem Unterschied, dass anstelle 
der selbst implementierten Datenstrukturen nur vorgefertigte Klassen aus dem 
Java-Collection-Framework benutzt werden sollen.
- [Aufgabe8Test](../src/Aufgabe8Test.java) ist eine vorgegebene Klasse, die Sie zum Testen Ihrer
Implementierung verwenden sollten. Bei einer fehlerfreien Implementierung sollten bei der
Ausführung dieser Klasse keine Exceptions geworfen werden und alle Tests als erfolgreich ("successful")
ausgegeben werden. Entfernen Sie die Kommentarzeichen, um diese Klasse verwenden zu können. Sie
müssen diese Klasse nicht weiter verändern, können aber eigene Testfälle hinzufügen.


## Aufgaben

1. Ändern Sie Ihre Implementierung, sodass ein `MassiveIterator` eine Exception 
    vom Typ `java.util.NoSuchElementException` wirft, falls `next()` aufgerufen wird,
    jedoch der Iterator keine weitere Iteration hat (`hasNext()` liefert `false`).
    
2. Ändern Sie den Iterator von der von `getKeys()` zurückgelieferten 
    Sichtweise auf `MassiveForceTreeMap` so, dass `remove()` überschrieben wird 
    ([siehe API Dokumentation](https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html#remove--)), 
    sodass der Iterator Einträge in Objekten von `MassiveForceTreeMap` löschen kann. Achten Sie 
    darauf, dass hier in bestimmten Fällen eine `java.lang.IllegalStateException` geworfen werden
    soll. Der Iterator von `HierarchicalSystem` muss nicht geändert werden.

3. Validierung von Eingabedaten:
    - Implementieren Sie in der Klasse `ReadDataUtil.java` die Methode `readConfiguration`.
    Es soll ein gepufferter Stream zum Einlesen genutzt werden (siehe Skriptum Seite 128). 
    Erstellen Sie zum Testen auch Varianten der txt-Dateien mit Formatfehlern.
    - Fügen Sie der Klasse `NamedBody` bei Bedarf 
    eine Methode `setState(Vector3 position, Vector3 velocity)` zum Setzen der Position 
    und des Geschwindigkeitsvektors des Himmelskörpers hinzu. 
    - Definieren Sie die beiden angegebenen Exceptionklassen in den entsprechenden 
    mitgelieferten Dateien.
  
4. Ausnahmebehandlung:
    In der Klasse `Simulation8` sollen nun die Himmelskörper mit Daten aus den gegebenen 
    txt-Dateien initialisiert werden. Dabei sollen zumindest die Sonne sowie die 
    inneren Planeten
    Merkur, Venus, Erde und Mars vorkommen. Sie können weitere Himmelskörper (siehe txt-Dateien) 
    hinzufügen. Nutzen Sie die Klasse `MassiveForceTreeMap` und ihre Iteratoren, um die 
    Himmelskörper der Simulation zu verwalten. (Kollisionen von Himmelskörpern müssen nicht 
    berücksichtigt werden.)
    Ändern Sie die Klasse `Simulation8` so, dass sie zwei Kommandozeilenargumente verarbeitet. 
    Das erste Argument ist ein String mit der Angabe des Pfades zum Verzeichnis, wo die 
    entsprechenden txt-Dateien (z.B. `Venus.txt`,`Mercury.txt`,`Earth.txt`) mit den Konfigurationen 
    der Himmelskörper zu finden sind. Die Dateien haben die Namen der Himmelskörper mit Endung `
    .txt`. Für die Sonne gibt es keine txt-Datei (es wird die Position (0,0,0) angenommen).
    Das zweite Argument ist ein String mit einer Datumsangabe der Form YYYY-MMM-DD, also z.B. 
    2020-Dec-04, die den Tag der auszulesenden Position und Bewegungsvektor bestimmt. Die Klasse 
    soll beim Auftreten von Problemen bei der Ausführung entsprechende Fehlermeldungen ausgeben und
    die Ausführung in bestimmten Fällen beenden. Beispiele für Aufrufe im Kommandozeileninterpreter 
    mit entsprechenden Fehlermeldungen (Sie können zum Ausführen das Terminal in IntelliJ nutzen
    oder die Programmargumente unter `Edit Configurations` angeben):
    ```
         $ javac Simulation8.java
         $ java Simulation8 ../states 2021-May-28
         Running simulation ...
         $ java Simulation8 ../states
         Error: wrong number of arguments.
         $ java Simulation8 ../states 2025-Dec-12
         Warning: State not available for Earth.
         Running simulation without Earth.
         Warning: State not available for Venus.
         Running simulation without Venus.
         ...
         $ java Simulation8 ../states-altered 2021-May-28
         Warning: File ../states-altered/Venus.txt does not have required format. 
         Running simulation without Venus.
         Warning: File ../states-altered/Mars.txt not found. 
         Running simulation without Mars.
         Running simulation ...
         $ java Simulation8 ../states -17
         Error: State has wrong format (requires YYYY-MM-DD), aborting. 
         $ java Simulation8 blah 2021-May-28
         Warning: File blah/Earth.txt not found. 
         Running simulation without Earth.
         Warning: File blah/Venus.txt not found. 
         Running simulation without Venus.
         ...
    ```

5. Kopieren Sie den Inhalt der Datei `Simulation8.java` in die Datei `Simulation9.java` und bauen
    Sie `Simulation9` so um, dass anstelle der selbst implementierten Datenstrukturen nur 
    vorgefertigte Klassen aus dem Java-Collection-Framework benutzt werden.
    
6. Freiwillige Zusatzaufgabe (ohne Bewertung):
    Ändern Sie die Klasse `Simulation8` so um, dass ein drittes optionales Kommandozeilenargument
    verarbeitet werden kann. Dieses gibt an, wieviele Tage simuliert werden sollen. Beispielsweise
    kann eine zweite Datumsangabe möglich sein, oder die Anzahl an Tagen. 
    Sobald dieser Zeitpunkt in der Simulation erreicht wurde, können die aktuellen Positionen der
    Himmelskörper mit den in den txt-Dateien angegebenen Positionen verglichen werden (z.B. 
    durch erneutem Aufruf von `readConfiguration` und `draw`). Wie groß sind die Abweichungen 
    der von NASA errechneten Positionen zu den Positionen, die Ihre Simulation liefert?

### Denkanstöße (ohne Bewertung)

1. Haben Sie die remove-Methode des Iterators so implementiert, dass der Aufruf keine 
zusätzliche Suche nach dem zu löschenden Eintrag benötigt?
2. Wie verhalten sich die von der Methode `toList()` der Klasse `MassiveForceTreeMap` 
zurückgelieferten Listen, wenn deren enthaltene Himmelskörper durch `setState` verändert werden? 
Werden dadurch die Himmelskörper der ursprünglichen `MassiveForceTreeMap`-Objekte auch geändert? 
(Anmerkung: diesbezüglich gibt es im Aufgabenblatt 6 keine Vorgaben).
3. Wie verhalten sich Ihre Iteratoren, wenn Objekte geändert werden?
4. Wie kann man durch Einfügen von Zeichen `,` und newlines (`\n`) aus den `txt`-Dateien eine 
"fehlerhafte" Datei machen, die trotzdem von der Methode akzeptiert wird? Kann man solche Probleme 
verhindern?

#### _Punkteaufteilung_

- Änderung von `next()` von `MassiveIterator`: 0.5 Punkte
- Implementierung der Methode `remove()` im Iterator der `MassiveSet`-Sichtweise  
  von `MassiveForceTreeMap`: 2 Punkte
- Implementierung der Exceptionklassen und Implementierung von `readConfiguration` 
  in `ReadDataUtil`: 1.5 Punkte
- Implementierung von `Simulation8` und `Simulation9`: 1 Punkt
