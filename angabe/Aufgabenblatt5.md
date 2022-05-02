# Aufgabenblatt 5

## Allgemeine Anmerkungen

Ihre Lösung für dieses Aufgabenblatt ist bis Montag, 9.5. 11h durch `git commit` und `git push`
abzugeben. Mit der Angabe werden die Dateien `Massive.java`, `NamedBody.java`, `MassiveLinkedList.java`,
`MassiveForceHashMap.java`, `Simulation5.java` und `Aufgabe5Test.java` mitgeliefert.

Wenn Sie zusätzlich zu den gefragten Klassen weitere Klassen definieren, achten Sie darauf, dass
die Klassennamen mit `My` beginnen, um Konflikte mit späteren Aufgabenblättern zu vermeiden.

## Ziel

Ziel der Aufgabe ist die Anwendung der Konzepte: Gleichheit und Hash-Werte, Hash-Tabelle
(siehe Skriptum Seite 85-91).

## Beschreibung der gegebenen Dateien

- [Massive](../src/Massive.java) ist ein Interface, das Himmelskörper (als kohärente Massen)
beschreibt. `Massive` ist der gemeinsame Obertyp für verschiedene Klassen von Himmelkörpern. Die
meisten spezifizierten Methoden sind mit einer `default`-Implementierung definiert. Dieser
Programcode wird ausgeführt, falls die entsprechende Klasse (`Body` oder `NamedBody`) über keine
eigene Definition der Methode verfügt. Verändern Sie diese Datei bitte nicht.
- [NamedBody](../src/NamedBody.java) ist das Gerüst einer Klassendefinition. Die Klasse
repräsentiert Himmelskörper, die einen Namen haben.
- [MassiveLinkedList](../src/MassiveLinkedList.java) ist das Gerüst für eine Implementierung einer
verketteten Liste von `Massive`-Objekten. Die Liste unterscheidet sich von `BodyLinkedList`
dadurch, dass der Elementtyp statt `Body` der Obertyp `Massive` ist.
- [MassiveForceHashMap](../src/MassiveForceHashMap.java) ist das Gerüst für eine Implementierung
einer assoziativen Datenstruktur, die ein `Massive`-Objekt mit der auf das Objekt wirkenden Kraft
assoziiert.
- [Simulation5](../src/Simulation5.java) ist ein Gerüst für eine ausführbare Klasse. Hier soll
die Simulation analog zur Klasse `Simulation` implementiert werden (damit Sie Ihre [ursprüngliche
 Datei](../src/Simulation.java) nicht überschreiben müssen).
- [Aufgabe5Test](../src/Aufgabe5Test.java) ist eine vorgegebene Klasse, die Sie zum Testen Ihrer
Implementierung verwenden sollten. Bei einer fehlerfreien Implementierung sollten bei der
Ausführung dieser Klasse keine Exceptions geworfen werden und alle Tests als erfolgreich ("successful")
ausgegeben werden. Entfernen Sie die Kommentarzeichen, um diese Klasse verwenden zu können. Sie
müssen diese Klasse nicht weiter verändern, können aber eigene Testfälle hinzufügen.

## Aufgaben

Ihre Aufgaben sind folgende:

**1. Implementieren Sie `Massive` in den Klassen `Body` und `NamedBody`.**

 Passen Sie die bestehende Definition von `Body` so an, dass die Klasse `Massive` implementiert wird.
 Vervollständigen Sie auch `NamedBody` so, dass sie `Massive` implementiert und die vorgegebene
 Spezifikationen der Methoden erfüllt.

**2. Überschreiben von `equals` und `hashCode` in `NamedBody`:**

 Überschreiben Sie in `NamedBody` die Methoden `equals` und `hashCode` gemäß der dort angeführten
 Spezifikation. Achten Sie bei der Implementierung darauf, dass die in der Klasse `Object`
 beschriebenen Bedingungen für `equals` und `hashCode` eingehalten werden. `equals` und `hashCode`
 müssen zusammen passen.

**3. Vervollständigen von `MassiveLinkedList`:**

 Definieren Sie `MassiveLinkedList`. Die Klasse ist wie `BodyLinkedList` aufgebaut, mit dem
 Unterschied, dass der Elementtyp statt `Body` nun der Typ `Massive` ist. Die Methode `indexOf` 
 vergleicht Objekte mittels `equals`.

**4. Implementierung von `MassiveForceHashMap`:**

 Vervollständigen Sie die Definition der Klasse `MassiveForceHashMap`, die eine Hash-Tabelle
 mit Schlüssel vom Typ `Massive` und Wert vom Typ `Vector3` implementiert. Die Klasse ist ähnlich
 zur Klasse `BodyForceTreeMap`. Die Unterschiede sind:
 - Der Typ des Schlüssels ist der gemeinsame Obertyp von `Body` und `NamedBody` (`Massive`).
   Dadurch lassen sich Objekte beider Klassen gemeinsam in der Hash-Tabelle speichern.
 - Die Schlüssel-Werte-Paare sind nicht nach Masse sortiert. Stattdessen wird der Hash-Wert zur
   Suche benutzt.
 - Es gibt eine zusätzliche Methode `keyList()`. Die Methoden `equals` und `hashCode` werden
   redefiniert.

**5. Implementierung von `Simulation5`:**

 Implementieren Sie die Simulationsschleife unter Verwendung eines Objekts vom Typ
 `MassiveForceHashMap`. Die Methode `keyList()` hilft beim Iterieren der Hash-Tabelle.
 Kollisionen von Himmelskörpern müssen in dieser Simulation nicht berücksichtigt werden.

### Hinweise:

- Verwenden Sie bei der Implementierung von `MassiveForceHashMap` eine geeignete Kollisionsbehandlung
  für gleiche Hash-Werte. Als Vorlage können Sie den Beispielcode aus dem Skriptum nutzen.

### Denkanstöße (ohne Bewertung)

1. Wie könnte man vorgehen, wenn man - wie in früheren Simulationen - Himmelskörper im Fall von
   Kollisionen verschmelzen will?
2. Was ändert sich am Verhalten von `MassiveForceHashMap`, wenn man in `Body` die Methoden
   `equals` und `hashCode` überschreiben würde?

#### _Punkteaufteilung_

- Implementierung von `Massive` in `NamedBody`: 1 Punkt
- Implementierung von `Massive` in `Body`: 0.5 Punkt
- Implementierung von `MassiveForceHashMap`: 2 Punkte
- Implementierung von `MassiveLinkedList`: 0.5 Punkte
- Implementierung von `Simulation5`: 1 Punkte
 
- Gesamt: 5 Punkte





