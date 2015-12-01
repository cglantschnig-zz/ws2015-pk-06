import java.util.*;

/*
    Aufgabenstellung zur Klasse District:

    Karlis Fahrradbotendienst hat die Stadt in verschiedene Distrikte (engl. District) eingeteilt. Pro Distrikt
    gibt es eine Sammelstelle, in der sich Fahrer treffen und auf Aufträge warten. Führt ein Auftrag von einem
    Distrikt in einen anderen, kommt der Fahrer nach Erledigung des Auftrags zur Sammelstelle des Distrikts, in dem
    die Fahrt endet. Dort wartet der Fahrer auf einen Auftrag. Fahrer erhalten Aufträge in der Reihenfolge, in der
    Sie in der Sammelstelle eingetroffen sind. Manchmal kommt es zu ungleichen Auslastungen. Dann muss ein Fahrer, der
    als nächster eine Fahrt zu absolvieren hätte, in einen anderen Distrikt wechseln. Damit es zu keinen
    Ungerechtigkeiten kommt, wird ein solcher Fahrer gleich nach Eintreffen ganz nach vorne gereiht.

    Simulieren Sie diese Vorgehensweise in der Klasse District:
    Ein Objekt der Klasse erhält den Namen des Distrikts über einen Konstruktor. Es wird eine Uhr (eigentlich nur ein
    Minutenzähler) mitgeführt, die jede Minute (beginnend mit 0) weitergeschaltet wird.
    Folgende Methoden werden benötigt:

    - tick:   Diese parameterlose Methode schaltet die Uhr um eine Minute weiter.

    - arrive: Ein Fahrer (Name als String-Parameter übergeben) trifft in der Sammelstelle des Distrikts ein.
              Eine Ausgabe wird gemacht: "Um <Uhrzeit> ist <Name des Fahrers> in <Name des Distrikts> eingetroffen."

    - help:   Ein Fahrer (Name als String-Parameter übergeben) trifft in der Sammelstelle des Distrikts ein, weil er
              von einem anderen Distrikt hierher gewechselt hat um auszuhelfen. Es wird dieselbe Ausgabe gemacht wie
              bei arrive.

    - job:    Ein Auftrag ist eingetroffen. Der Distrikt des Ziels der Fahrt wird als Parameter übergeben. Wenn kein
              Fahrer verfügbar ist, wird als Ergebnis false zurückgegeben, andernfalls true. Eine Ausgabe wird
              gemacht, entweder: "Um <Uhrzeit> Auftrag ohne Fahrer in <Name des Distrikts>."
              oder: "Um <Uhrzeit> fährt <Name des Fahrers> von <Name des Distrikts> nach <Name des Distrikts>.".
              Dieselbe Methode wird verwendet, wenn ein Fahrer in einen anderen Distrikt wechseln soll.

    Verwenden Sie in District KEIN Array, sondern ein Objekt vom Typ Queue bzw. Deque.

    Schreiben Sie in District eine Methode main, die ein Gesamtszenario simuliert. Es sollen mehrere Distrikte erzeugt
    und mehrere Fahrer zwischen ihnen hin und her geschickt werden. Auch tick ist regelmäßig aufzurufen. In den
    entstehenden Bildschirmausgaben sollen alle wesentlichen unterschiedlichen Fälle sichtbar werden.

    Zusatzfragen:
    1. Was unterscheidet Queue von Deque?
       Queue = FIFO
       Deque = LIFO
    2. Was versteht man unter dem FIFO- bzw. LIFO-Prinzip?
       First-In First-out
       Last-In Last-In
    3. Welche dieser Methoden sind static, welche nicht? Warum ist das so?
*/
public class District {

    // TODO: All necessary object variables, constructors and methods shall be declared or defined here.

    private String name;
    private static int time;
    private Queue<String> drivers;

    public District(String name) {
        this.name = name;
        this.time = 0;
        this.drivers = new LinkedList<String>();
    }

    public static void tick() {
        time += 1;
    }

    public void arrive(String driver) {
        this.printDriverInfo(driver);
        this.drivers.add(driver);
    }

    public void help(String driver) {
        this.printDriverInfo(driver);
        this.drivers.poll();
        /*
          destination.drivers.add(driver);
         */

    }

    private void printDriverInfo(String driver) {
        System.out.println("Um " + this.time + " ist " + driver + " in " + this.name + " eingetroffen.");
    }

    public boolean job(District destination) {
        if (this.drivers.isEmpty()) {
            System.out.println("Um " + this.time + " Auftrag ohne Fahrer in " + this.name + ".");
            this.help(destination.drivers.poll());
            return false;
        }
        String driver = this.drivers.poll();
        System.out.println("Um " + this.time + " fährt " + driver + " von " + this.name + " nach " + destination.name + ".");
        this.arrive(driver);
        return true;
    }

    @Override
    public String toString() {
        String output = "";
        Iterator itr = this.drivers.iterator();
        while (itr.hasNext()) {
            output += itr.next() + ", ";
        }
        return output;
    }


    public static void main(String[] args) {
        District d = new District("Wien");
        District e = new District("Semmering");
        d.arrive("Tom");
        d.arrive("Lisa");
        District.tick();
        e.job(d);
        District.tick();
        District.tick();
        d.help("Lukas");
    }

}
