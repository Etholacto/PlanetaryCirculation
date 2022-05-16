# Aufgabenblatt 6

## Allgemeine Anmerkungen

Ihre Lösung für dieses Aufgabenblatt ist bis Montag, 23.5. 11h durch `git commit` und `git push`
abzugeben. Mit der Angabe werden die Dateien `MassiveIterable.java`, `MassiveIterator.java`, 
`MassiveSet.java`, `MassiveForceTreeMap.java`, `Simulation6.java` und `Aufgabe6Test.java` 
mitgeliefert.

Wenn Sie zusätzlich zu den gefragten Klassen weitere Klassen definieren, achten Sie darauf, dass
die Klassennamen mit `My` beginnen, um Konflikte mit späteren Aufgabenblättern zu vermeiden.

## Ziel

Ziel der Aufgabe ist die Anwendung der Konzepte: Iterator, Kopie vs. Sichtweise, Sortieren
(siehe Skriptum Seite 91-109).

## Beschreibung der gegebenen Dateien

- [MassiveIterable](../src/MassiveIterable.java) ist ein Interface, das iterierbare Objekte mit
Elementen vom Typ `Massive` spezifiziert. Verändern Sie diese Datei bitte nicht.
- [MassiveIterator](../src/MassiveIterator.java) ist ein Interface, das einen Iterator über
Elemente vom Typ `Massive` spezifiziert. Verändern Sie diese Datei bitte nicht.
- [MassiveSet](../src/MassiveSet.java) ist ein Interface, das iterierbare Mengen mit 
`Massive`-Elementen spezifiziert. Verändern Sie diese Datei bitte nicht.
- [MassiveForceTreeMap](../src/MassiveForceTreeMap.java) ist das Gerüst für eine Implementierung
einer assoziativen Datenstruktur, die ein `Massive`-Objekt mit der auf das Objekt wirkenden Kraft
assoziiert.
- [Simulation6](../src/Simulation6.java) ist ein Gerüst für eine ausführbare Klasse. Hier soll
die Simulation analog zur Klasse `Simulation` implementiert werden (damit Sie Ihre [ursprüngliche
 Datei](../src/Simulation.java) nicht überschreiben müssen).
- [Aufgabe6Test](../src/Aufgabe6Test.java) ist eine vorgegebene Klasse, die Sie zum Testen Ihrer
Implementierung verwenden sollten. Bei einer fehlerfreien Implementierung sollten bei der
Ausführung dieser Klasse keine Exceptions geworfen werden und alle Tests als erfolgreich ("successful")
ausgegeben werden. Entfernen Sie die Kommentarzeichen, um diese Klasse verwenden zu können. Sie
müssen diese Klasse nicht weiter verändern, können aber eigene Testfälle hinzufügen.

## Aufgaben

Ihre Aufgaben sind folgende:

**1. Implementieren Sie die Klasse `MassiveForceTreeMap`.**

 Implementieren Sie die Klasse `MassiveForceTreeMap`. `MassiveForceTreeMap` ist wie 
 `BodyForceTreeMap` aufgebaut, mit dem Unterschied, dass der Typ des Schlüssels statt `Body` nun 
 der Typ `Massive` ist. Weiters soll die Klasse Methode `getKeys()` zur Verfügung stellen, 
 die eine `MassiveSet`-Sichtweise auf die Menge der Schlüssel liefert. Änderungen an dem 
 zurückgelieferten `MassiveSet`-Objekt wirken sich auf das zugrunde 
 liegende `MassiveForceTreeMap`-Objekt aus. Die Methode `toList()` liefert dagegen eine 
 unabhängige Liste (Kopie) mit allen Schlüsseln der Map. Für die Implementierung von 
 `MassiveSet` können Sie einen eigenen Klassennamen beginnend mit `My` wählen. Die Definition kann 
 in einer eigenen Datei oder in der Datei `MassiveForceTreeMap.java` erfolgen.
 
**2. Adaptieren Sie die Klasse `HierarchicalSystem`:**

 Die Klasse `HierarchicalSystem` soll so geändert werden, dass sie das gegebene 
 Interface `MassiveIterable` implementiert. Die Reihenfolge der vom Iterator gelieferten 
 Elemente ist nicht festgelegt. Sie dürfen für die Implementierung bei Bedarf Ihren Klassen 
 `NamedBodyForcePair` und `HierarchicalSystem` neue, nicht angegebene Methoden hinzufügen.
 Die Verwendung von Klassen des Java-Collection-Frameworks (z.B. java.util.Stack) ist erlaubt
 (aber nicht notwendig).
 
**3. Implementierung von `Simulation6`:**

 Implementieren Sie die Simulationsschleife unter Verwendung eines Objekts vom Typ
 `MassiveForceTreeMap`. Die Methode `getKeys()` hilft beim Iterieren der gespeicherten Schlüssel.
 Kollisionen von Himmelskörpern müssen in dieser Simulation nicht berücksichtigt werden.

#### _Punkteaufteilung_

- Implementierung von `MassiveForceTreeMap`: 3 Punkte
- Implementierung von `MassiveIterable` in `HierarchicalSystem`: 1.5 Punkte
- Implementierung von `Simulation6`: 0.5 Punkte
 
- Gesamt: 5 Punkte





