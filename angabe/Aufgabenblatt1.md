# Aufgabenblatt 1

## Allgemeine Anmerkungen
Ihre Lösung für dieses Aufgabenblatt ist bis Montag, 21.3.2022 11:00 Uhr durch `git commit` und `push` abzugeben. Mit der Angabe werden folgende Dateien mitgeliefert, die sie gemäß der Angabe verändern müssen: `Simulation.java`, `Vector3.java`, `Body.java` und zum Testen `Aufgabe1Test.java`. Die zusätzliche Datei `CodeDraw.jar` wird nur zum Zeichnen verwendet und sollte nicht entfernt oder verändert werden. Die zusätzliche Datei `SpaceDraw.java` enthält Methoden, die in der Simulation benötigt werden. Diese Methoden können Sie auch in Ihrer Lösung aufrufen.

Vorgegebene Programmteile dürfen nur an den Stellen verändert werden, die mit TODO markiert sind. Zusätzliche Klassen, Interfaces, Methoden und Variablen dürfen aber eingefügt werden. Wenn Sie zusätzlich zu den gefragten Klassen weitere Klassen definieren, achten Sie darauf, dass die Klassennamen mit `My` beginnen, um Konflikte mit späteren Aufgabenblättern zu vermeiden.

## Verwendung in IntelliJ
Diese Aufgabenstellung ist ein vollständiges IntelliJ-Projekt, das Sie bereits in IntelliJ öffnen können. Sie müssen daher kein eigenes Projekt anlegen. Öffnen Sie nach dem Klonen des Repos in IntelliJ einfach den entsprechenden Ordner. Gegebenenfalls muss noch folgender Schritt ausgeführt werden:

- Einstellen des _Project SDK_: Öffnen Sie dazu in IntelliJ die Projekteinstellungen (_File_ -> _Project Structure..._) und wählen Sie ein JDK unter _Project | Project SDK_ aus.

## Thema 
Das allgemeine Thema dieses und der kommenden Aufgabenblätter ist der Weltraum und die Simulation der physikalischen Gesetze, die für Himmelskörper gelten. Obwohl ein möglichst exaktes physikalisches Modell wünschenswert ist, ist bei der Implementierung die Genauigkeit der physikalischen Modelle sekundär. Konzeptuelle Fehler bei den physikalischen Berechnungen spielen keine Rolle bei der Bewertung. Schwerpunkt sind die Konzepte der Programmiersprache. 

## Ziel
Ziel der Aufgabe ist die Anwendung der Konzepte: Objekt- vs. Klassenmethode, Datensatz, Data Hiding, Konstruktoren (siehe Skriptum Seiten 31-50).

## Aufgaben
1. Lesen Sie sich die Kommentare in den Dateien durch und führen Sie die Klasse `Simulation` aus. 
2. Data hiding: 
    1. Machen Sie in den Klassen `Vector3` und `Body` alle Objektvariablen `private`.
    2. Definieren Sie entsprechende Konstruktoren, um die Objektvariablen zu initialisieren. `Simulation` soll nur noch diese nutzen und nicht mehr direkt auf die Objektvariablen zugreifen dürfen. Testen Sie zunächst die vervollständigten Klassen `Vector3` und `Body` mit der Klasse `Aufgabe1Test`. Entfernen Sie dazu die Kommentarzeichen in der Klassendefinition.
3. Datenkapselung: Anstelle der gegebenen statischen Methoden in der Datei `Simulation.java` sollen nur noch entsprechende Objektmethoden der Klassen `Body` und `Vector3` benutzt werden. (Ausnahme ist die Methode `main`. Die statischen Methoden der Klasse `SpaceDraw` müssen auch nicht verändert werden.) Implementieren Sie dazu die spezifizierten Methoden und bauen Sie `Simulation` so um, dass anstelle der Aufrufe statischer Methoden Objektmethoden genutzt werden. Sie sollen alle in `Body` und `Vector3` spezifizierten Methoden implementieren, auch wenn nicht alle von `Simulation` genutzt werden. Die in `Simulation.java` gegebenen statischen Methoden können dann entfernt werden (natürlich bis auf die erwähnten Ausnahmen). Nutzen Sie die implementierten Methoden auch in `Simulation.java`, um die Himmelskörper zu bewegen und zu zeichnen.  

## Zusatzfragen
Beantworten Sie folgende Zusatzfragen als Kommentar in `Simulation.java`:

1. Was versteht man unter _Datenkapselung_? Geben Sie ein Beispiel, wo dieses Konzept in dieser Aufgabenstellung angewendet wird. 
2. Was versteht man unter _Data Hiding_? Geben Sie ein Beispiel, wo dieses Konzept in dieser Aufgabenstellung angewendet wird.
3. Was steht bei einem Methodenaufruf links vom `.` (z.B. bei `SpaceDraw.massToColor(1e30)` oder 
`body.radius()`)? Woran erkennt man dabei Objektmethoden?

### Denkanstöße (ohne Bewertung)
Folgende Fragen sind als Denkanstöße gedacht und bilden die Grundlage für eine Diskussion in der Übungseinheit zu diesem Aufgabenblatt.

1. Welche anderen oder weiteren Objektmethoden hätten Sie zur Verfügung gestellt, wenn es keine Vorgaben gegeben hätte?
2. Wann wäre es sinnvoll, die Klasse `SpaceDraw` so zu ändern, dass diese ebenfalls Objektmethoden 
zur Verfügung stellt?

#### _Punkteaufteilung_

- Korrekte Sichtbarkeit von Objektvariablen in `Vector3` und `Body` und Initialisierung mittels Konstruktoren: 1 Punkt
- Korrekte Objektmethoden in `Vector3`: 1 Punkt
- Korrekte Objektmethoden in `Body`: 1.5 Punkte
- Korrekte Verwendung der Objektmethoden in `Simulation`: 1 Punkt
- Korrekte Beantwortung der Zusatzfragen: 0.5 Punkte
- Gesamt: 5 Punkte
