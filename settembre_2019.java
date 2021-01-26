import java.util.ArrayList;

// Esercizio 1

public class CodaApp {
    public static void main(String args[]) {
        Coda<Integer> queue = new Coda<>();
        queue.enqueue(36);
        queue.enqueue(45);
        
        Integer first = queue.pick();
        System.out.println("primo = " + first);
        queue.dequeue();
        first = queue.pick();
        System.out.println("nuovo primo = " + first);
    }
}

class Coda <T> {
    private ArrayList<T> list;

    public Coda() {
        list = new ArrayList<T>();
    }

    public T pick() {
        if(list.size() > 0)
            return list.get(0);
        else return null;
    }

    public T dequeue() {
        T ris = null;
        if(list.size() > 0) {
            ris = list.get(0);
            list.remove(0);
        }
        return ris;
    }

    public void enqueue(T el) {
        if(el != null)
            list.add(el);
    }
}

// Esercizio 2, RMI non affrontato

/*
Esercizio 3
Nel codice viene usata la notify, quindi non sapendo quale thread verrá notificato
si potrebbe riscontrare un loop nella quale tutti i thread ancora attivi sono nella
lista di wait

[<p1, p2, p3, c1, c2, c3>, <>, false]
[<p2, p3, c1, c2, c3>, <>, true]
[<p3, c1, c2, c3>, <p2>, true]
[<c1, c2, c3>, <p2, p3>, true]
[<c2, c3, p2>, <p3>, false]
[<c3, p2>, <p3, c2>, false]
[<p2>, <p3, c2, c3>, false]
[<p3>, <c2, c3>, true]
[<>, <c2, c3, p3>, true]
*/