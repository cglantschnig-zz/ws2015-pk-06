import java.util.ArrayDeque;

/*
    Aufgabenstellung zur Klasse Aufgabe4:

    Implementieren Sie eine statische Methode check, die einen String als Parameter hat und genau dann true zurückgibt,
    wenn der String einen korrekt geklammerten Ausdruck enthält. Ein Ausdruck ist dann korrekt geklammert, wenn es zu
    jeder öffnenden Klammer '(', '[' oder '{' eine entsprechende schließende Klammer ')', ']' oder '}' gibt. Zwischen
    diesen Zeichen können beliebige andere Zeichen vorkommen.

    Beispiele für korrekt geklammerte Ausdrücke: "", "a*[a+12]", "a+(b)-c", "a+{b+8+(b+c)}/a", "[()]"
    Beispiele für nicht korrekt geklammerte Ausdrücke: "[", "(}", "a)[]", "([)]", "]["

    Verwenden Sie einen Stack zur Überprüfung der Klammerung: Durchlaufen Sie die Zeichen im String von vorne nach
    hinten und legen Sie jede öffnende Klammer, die Sie dabei finden, auf den Stack. Wenn Sie auf eine schließende
    Klammer stoßen, nehmen Sie das oberste Element vom Stack; bei korrekter Klammerung muss die schließende Klammer
    mit der Klammer vom Stack zusammenpassen. Andere Zeichen werden einfach ignoriert. Bei korrekter Klammerung muss
    der Stack am Ende leer sein.

    Hinweis: Sie können als Stack z.B. ein Objekt des Typs Deque<String> verwenden.
    Bitte verwenden Sie dafür kein Array.

    Zusatzfragen:
    1. Was versteht man unter dem LIFO- und FIFO-Prinzip?
    2. Könnte man zur Lösung dieser Aufgabe statt Deque<String> auch Queue<String> verwenden?
    3. Wie könnte man diese Aufgabe auch mit einem Array statt einem Stack lösen?
       Welche Nachteile würden sich daraus ergeben?
*/
public class Aufgabe4 {

    private static boolean check(String toBeChecked) {
        // TODO: Implementation is your task.
        ArrayDeque<Character> josette = new ArrayDeque<>();

        for (char honey : toBeChecked.toCharArray()) {
            if (honey == '{' || honey == '[' || honey == '(') {
                josette.add(honey);
            }
            if (honey == '}' || honey == ']' || honey == ')') {
                josette.poll();
            }
        }
        return josette.isEmpty();
    }

    // Just for testing ...
    public static void main(String[] args) {
        // Implementierung von main wird nicht beurteilt.
    }
}
