import java.util.Queue;

/*
    Aufgabenstellung zur Klasse StreetMap:

    Um die Suche nach einer Zieladresse zu erleichtern, haben die Fahrer in Karlis Fahrradbotendienst einen einfachen
    elektronischen Stadtplan bei sich: Nach Eingabe einer Adresse erscheinen der Name des entsprehenden Distrikts und
    die GPS-Koordinaten. Objekte der Klasse StreetMap stellen einen wesentlichen Teil des Stadtplans dar.
    Vervollständigen Sie die Implementierung, so wie in den Kommentaren beschrieben.

    Bitte verwenden Sie in der Implementierung von StreetMap KEIN Array, sondern nur Objekte von Typen wie Queue, Deque
    und Map (neben MapData - siehe unten).

    Zusatzfragen:
    1. Wieso ist die zusätzliche Klasse MapData sinnvoll?
    2. Wie werden die Daten in MapData zugreifbar? Geht das auch, wenn die Objektvariablen private sind?
    3. Wofür ist Queue besser geeignet, wofür Map?
    4. Warum ist Double mit großem Anfangsbuchstaben geschrieben (nicht double)?
*/

public class StreetMap {

    // TODO: Object variables shall be declared here.

    // The parameters specify the initial contents of a street map:
    //     addr:  addresses that can be found in the street map
    //     distr: names of the districts of corresponding addresses
    //     lon:   longitudes in the GPS coordinates
    //     lat:   latitude in the GPS coordinates
    // All queues in the parameters are of the same size.
    // All entries at the same position (1st, 2nd, 3rd, ...) belong together.
    public StreetMap(Queue<String> addr, Queue<String> distr, Queue<Double> lon, Queue<Double> lat) {
        // TODO: Implementation is your task.
    }

    // Returns all data (district and GPS coordinates) for address addr.
    // Returns null if no data can be found for this address.
    public MapData find(String addr) {
        // TODO: Implementation is your task.
        return null;
    }

    // Returns true if (and only if) address addr is in district distr.
    public boolean inDistrict(String addr, String distr) {
        // TODO: Implementation is your task.
        return false;
    }

    // Adds a new address addr to the street map, where newData are the data to be associated with this address.
    // However, if the address already exists, the old data are replaced with newData.
    // true is returned if the address was replaced, false if a new address was added.
    public boolean newData(String addr, MapData newData) {
        // TODO: Implementation is your task.
        return false;
    }

    // To test the implementation several objects of StreetMap (each with several addresses) are created,
    // all methods are called, and data associated with found addresses are printed.
    public static void main(String[] args) {
        // TODO: Implementation is your task.
    }
}

// Objects of MapData hold all data (district and GPS coordinates) associated with an address in the street map.
// It is necessary to get access to the data in objects of this type.
class MapData {
    // TODO: Implementation is your task.
}
