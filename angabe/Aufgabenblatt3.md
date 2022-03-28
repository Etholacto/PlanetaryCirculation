# Aufgabenblatt 3

## Allgemeine Anmerkungen

Ihre Lösung für dieses Aufgabenblatt ist bis Montag, 4.4. 11h durch `git commit` und `push` abzugeben. Mit der Angabe werden folgende Dateien mitgeliefert: [Simulation3](../src/Simulation3.java), [BodyLinkedList](../src/BodyLinkedList.java), [BodyForceTreeMap](../src/BodyForceTreeMap.java) und [Aufgabe3Test](../src/Aufgabe3Test.java).
Zusätzliche Klassen, Interfaces, Methoden und Variablen dürfen aber eingefügt werden. Wenn Sie zusätzlich zu den gefragten Klassen weitere Klassen definieren, achten Sie darauf, dass die Klassennamen mit `My` beginnen, um Konflikte mit späteren Aufgabenblättern zu vermeiden.

## Ziel

Ziel der Aufgabe ist die Implementierung einer Liste für eine lineare und eines Baums für eine assoziative Datenstruktur (siehe Skriptum Seiten 60-69).

## Beschreibung der gegebenen Dateien

- [BodyLinkedList](../src/BodyLinkedList.java) ist das Gerüst für eine Implementierung einer linearen Datenstruktur zur
  Verwaltung von Objekten des Typs `Body`.
- [BodyForceTreeMap](../src/BodyForceTreeMap.java) ist das Gerüst für eine Implementierung einer assoziativen Datenstruktur, die einen Himmelskörper mit der auf ihn wirkenden Kraft assoziiert.
- [Aufgabe3Test](../src/Aufgabe3Test.java) ist eine vorgegebene Klasse, die Sie zum Testen Ihrer Implementierung verwenden sollten.
  Bei einer fehlerfreien Implementierung sollten bei der Ausführung dieser Klasse keine Exceptions geworfen werden und alle Tests als erfolgreich ("successful") ausgegeben werden. Sie müssen diese Klasse nicht verändern, können aber eigene Testfälle hinzufügen.
- [Simulation3](../src/Simulation3.java) ist ein Gerüst für eine ausführbare Klasse. Hier soll die Simulation analog
  zur Klasse `Simulation` implementiert werden (damit Sie Ihre [ursprüngliche Datei](../src/Simulation.java)
  nicht überschreiben müssen).

## Aufgaben

Ihre Aufgaben sind folgende:

1. Vervollständigen Sie die Klassendefinitionen in [BodyLinkedList](../src/BodyLinkedList.java) gemäß der Kommentare in den Dateien. Die Implementierung soll mit Hilfe einer verketteten Liste erfolgen. Sie können selbst entscheiden, ob Sie eine einfach oder doppelt verkettete Liste implementieren wollen. Benutzen Sie keine Arrays oder vorgefertigten Klassen aus dem Java-Collection-Framework!
2. Vervollständigen Sie die Klassendefinition in [BodyForceTreeMap](../src/BodyForceTreeMap.java). Die Implementierung
   soll mit Hilfe eines binären Suchbaums erfolgen, in dem die Himmelskörper nach deren Masse sortiert sind. Die eigentlichen Schlüssel sind somit Objekte vom Typ `Body`, die interne Ordnung im Suchbaum erfolgt jedoch durch deren Masse. Benutzen Sie keine Arrays oder vorgefertigten Klassen aus dem Java-Collection-Framework!
3. Vervollständigen Sie die gegebene Klasse [Simulation3](../src/Simulation3.java) unter der Verwendung der Klassen
   [BodyLinkedList](../src/BodyLinkedList.java) und [BodyForceTreeMap](../src/BodyForceTreeMap.java), so dass sich diese wie die bereits bestehende Klasse
   [Simulation](../src/Simulation.java) verhält. Kollisionen sollen wieder berücksichtigt werden. Die Zugriffe auf die
   Himmelskörper der Simulation sollen über Methoden von [BodyLinkedList](../src/BodyLinkedList.java) erfolgen. Die Klasse [BodyForceTreeMap](../src/BodyForceTreeMap.java) soll zur Verwaltung der Kräfte benutzt werden.

Allgemeiner Hinweis: bei einigen Methoden sind Vorbedingungen (_pre-conditions_) angegeben. Diese Vorbedingungen müssen innerhalb der Methode NICHT überprüft werden, sondern stellen Zusicherungen dar, auf die die Methode sich verlassen kann. Diese Regel gilt allgemein auch für zukünftige Aufgabenblätter.

### Denkanstöße (ohne Bewertung)

1. Haben Sie bei der Implementierung darauf geachtet, dass die Zugriffe möglichst effizient
   erfolgen können (Z.B. ohne die Liste beim Zugriff wiederholt durchlaufen zu müssen)? Was ist in dem Zusammenhang der Vorteil der verketteten Liste?
2. Wofür eignen sich eher die Queue-Methoden `addFirst`, `addLast`, `pollFirst` bzw.
   `pollLast` und wofür eher die List-Methoden `get`?

#### _Punkteaufteilung_

- Implementierung von `BodyLinkedList`: 2 Punkte
- Implementierung von `BodyForceTreeMap`: 2 Punkte
- Implementierung von `Simulation3`: 1 Punkt
- Gesamt: 5 Punkte

