# Aufgabenblatt 4

## Allgemeine Anmerkungen
Ihre Lösung für dieses Aufgabenblatt ist bis Montag, 2.5. 11h durch `git commit` und `push`
abzugeben. Mit der Angabe werden die Dateien `CosmicSystem.java`, `Drawable.java`, 
`NamedBodyForcePair.java`, `HierarchicalSystem.java`, `Simulation4.java` und `Aufgabe4Test.java` 
mitgeliefert.

Wenn Sie zusätzlich zu den gefragten Klassen weitere Klassen definieren, achten Sie darauf, dass
die Klassennamen mit `My` beginnen, um Konflikte mit späteren Aufgabenblättern zu vermeiden.

## Ziel
Ziel der Aufgabe ist die Anwendung der Konzepte: Interfaces, dynamisches Binden, toString() 
(siehe Skriptum Seite 75-84).

## Beschreibung der gegebenen Dateien

- [CosmicSystem](../src/CosmicSystem.java) ist ein gegebenes Interface, das von den Klassen
`NamedBodyForcePair` und `HierarchicalSystem` implementiert wird. Mithilfe dieses lässt sich somit eine
Hierarchie von Systemen und Subsystemen beschreiben. Unser Sonnensystem ist ein Beispiel eines Systems,
das mehrere Teilsysteme beinhaltet. Ein solches Teilsystem ist beispielsweise das System Erde und Erdmond.
Ein anderes Teilsystem wäre Jupiter mit seinen Monden. Verändern Sie dieses Interface nicht.
- [Drawable](../src/Drawable.java) wird von `CosmicSystem` verwendet. Verändern Sie dieses Interface 
nicht.
- [NamedBodyForcePair](../src/NamedBodyForcePair.java) ist das Gerüst für eine Klassendefinition.
Die Klasse implementiert `CosmicSystem` und repräsentiert einen einzelnen benannten Himmelskörper
 (z.B. "Mars") zusammen mit der auf ihn wirkenden Kraft.
- [HierarchicalSystem](../src/HierarchicalSystem.java) ist das Gerüst für eine Klassendefinition.
Die Klasse implementiert `CosmicSystem`und repräsentiert ein System von Himmelskörpern (z.B.
Sonnensystem) bestehend aus einem zentralen Himmelskörper und beliebig vielen Untersystemen in
dessen Orbit. Für alle Himmelskörper werden die Kräfte, die auf diese jeweils wirken, mitverwaltet.
- [Simulation4](../src/Simulation4.java) ist ein Gerüst für eine ausführbare Klasse. Hier soll
die Simulation analog zur Klasse `Simulation` implementiert werden (damit Sie Ihre [ursprüngliche
 Datei](../src/Simulation.java) nicht überschreiben müssen).
- [Aufgabe4Test](../src/Aufgabe4Test.java) ist eine vorgegebene Klasse, die Sie zum Testen Ihrer
Implementierung verwenden sollten. Bei einer fehlerfreien Implementierung sollten bei der
Ausführung dieser Klasse keine Exceptions geworfen werden und alle Tests als erfolgreich ("successful") 
ausgegeben werden. Entfernen Sie die Kommentarzeichen, um diese Klasse verwenden zu können. Sie 
müssen diese Klasse nicht weiter verändern, können aber eigene Testfälle hinzufügen.

## Aufgaben

Ihre Aufgaben sind folgende:

**1. Implementierung von `CosmicSystem` in `NamedBodyForcePair`:**
 Fügen Sie in der Klasse `Body` eine öffentliche Methode `massCenter()` hinzu, die die
 Position des Himmelskörpers liefert.
 Definieren Sie die Klasse `NamedBodyForcePair` so, dass sie das Interface `CosmicSystem` 
 implementiert. Die Methoden `getMass()` und `getMassCenter()` geben lediglich die Masse bzw.
 Position des Himmelskörpers zurück.

**2. Implementierung von `CosmicSystem` in `HierarchicalSystem`:**

 Definieren Sie die Klasse `HierarchicalSystem` so, dass sie das Interface `CosmicSystem` implementiert.
 Die Klasse repräsentiert ein hierarchisch aufgebautes kosmisches System von Himmelskörpern.
 Ein solches System besteht aus einem zentralen Himmelskörper und beliebig vielen weiteren
 kosmischen Systemen, die sich im Orbit um diesen zentralen Himmelskörper befinden. Neben der
 Spezifikationen in `CosmicSystem` beachten Sie bitte folgende spezielle Anforderungen und Hinweise
 für die Implementierung:

- `toString()`: diese Methode soll eine textuelle Beschreibung der Hierarchie von Himmelskörpern
und Subsystemen liefern. Dafür wird der Namen des zentralen Himmelskörpers eines Systems
gefolgt von den Objekten im Orbit jeweils in {}-Klammern repräsentiert. Beispiel:

    `"Sun {Mercury, Venus, Earth {Moon} , Mars {Deimos, Phobos} , Vesta, Pallas, Hygiea, Ceres}"`

- `numberOfBodies()`: diese Methode liefert die Gesamtanzahl aller Himmelskörper (nicht Systeme)
im System bzw. Himmelskörper, das heißt alle Objekte vom Typ `NamedBodyForcePair`. Das oben genannte
Beispiel-System besteht z.B. aus 12 Himmelskörpern, das Mars-System im Orbit der Sonne jedoch nur
aus 3.

- `getMass()`: diese Methode liefert die Summe der Massen aller Himmelskörper im System.

- `getMassCenter()`: diese Methode liefert den Schwerpunkt aller Himmelskörper im System. Dieser
entspricht dem mit den Massen gewichteten Mittelwert aller Positionen, es müssen daher alle Positionen
mit der jeweiligen Masse multipliziert und aufsummiert werden und das Resultat durch die Summe aller
Massen dividiert werden. Nutzen Sie dafür die bereits implementierten Rechenoperationen in `Vector3`.

- `addForceFrom(Body b)` aktualisiert für jedes `NamedBodyForcePair`-Objekt in `this` die Kraft,
indem die von `b` auf das `NamedBodyForcePair`-Objekt ausgeübte Kraft zur Kraft hinzuaddiert wird.

- `addForceTo(CosmicSystem cs)` aktualisiert für jedes `NamedBodyForcePair`-Objekt in `cs` die
Kraft, indem alle Kräfte die von Körpern aus `this` auf das `NamedBodyForcePair`-Objekt
ausgeübt werden, zur Kraft im Objekt hinzuaddiert werden. Beispiel: Die
Anweisung `cs.addForce(cs)` aktualisiert alle wechselseitigen im System `cs` wirkenden Kräfte.

- `update()` führt auf Basis der gespeicherten Kräfte alle Bewegungen im System `this` durch und 
setzt danach alle Kräfte wieder auf den null-Vektor zurück.

- `getBodies()` liefert eine Liste (Typ: `BodyLinkedList`) mit allen Himmelskörpern aus `this`.

**3. Implementierung von `Simulation4`:**

Implementieren Sie die Simulationsschleife unter Verwendung eines Objekts vom Typ 
`HierachicalSystem`. Alle Berechnungen sollen mittels Methoden von `CosmicSystem` durchgeführt
werden.

### Hinweise: ###

- Nutzen Sie für die Implementierung dieser Methoden Rekursion sowie das Konzept des _dynamischen Bindens_.
Da `NamedBodyForcePair` und `HierarchicalSystem` Untertypen von `CosmicSystem` sind, haben sie
jeweils eine eigene Implementierung der in `CosmicSystem` definierten Methoden und es wird zur
Laufzeit entschieden, von welchem dynamischen Typ ein Objekt ist und welche Methode somit ausgeführt
wird. Sie dürfen hier keine Typumwandlungen (Casts) und auch nicht die Methoden `getClass()` und
`instanceOf()` verwenden.

- Es ist möglich, aber nicht verlangt, `addForceTo(CosmicSystem cs)` ohne Verwendung von
`getBodies()` zu implementieren. Dazu kann in `addForceTo(CosmicSystem cs)` der Zugriff auf
die eizelnen Körper in `cs` dadurch erreicht werden, dass `this` für alle seine Himmelskörper
und Untersysteme `addForceTo(cs)` aufruft. Wird beim rekursiven Abstieg ein einzelner Himmelskörper
erreicht (Blattknoten) ruft dieser `cs.addForceFrom(this)` auf.

- Achten Sie bei der Berechnung der Kräfte in `addForceFrom(Body b)` darauf, dass die Kraft nicht 
verändert wird, wenn `this` und `b` derselbe Himmelskörper sind.

#### _Punkteaufteilung_

- Implementierung von `CosmicSystem` in `NamedBodyForcePair`: 1.5 Punkte
- Implementierung von `CosmicSystem` in `HierarchicalSystem`: 2.5 Punkte
- Implementierung von `Simulation4`: 1 Punkte

- Gesamt: 5 Punkte



