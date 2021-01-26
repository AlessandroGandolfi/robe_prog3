import java.lang.reflect.Constructor;

// Esercizio 1

public class StackApp {
    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();
        stack.push(18);
        Integer num = stack.top();
        System.out.println("Top " + num);
        num = stack.pop();
    }
}

class Stack <T> {
    private ArrayList<T> list;
    int index = 0;

    public Stack() {
        list = new ArrayList<T>();
    }

    public T top() {
        if (list.size()>0)
            return list.get(0);
        else return null;
    }

    public T pop() {
        T ris = null;
        if (list.size()>0) {
            ris = list.get(0);
            list.remove(0);
        }
        return ris;
    }

    public void push(T el) {
        list.add(0, el);
        index++;
    }
}

/*
Esercizio 2
JR è un meccanismo molto potente fornito da
Java per analizzare le funzionalità delle classi, ad
esempio per ottenere a run-time informazioni su campi,
metodi, costruttori

Usa package java.lang.reflect (contenente le classi Constructor, Method e Field)
e la classe Class
*/

public static void main(String[] args) {
    // stampo lista costruttori di java.lang.Math
    Class cl = Class.forName("java.lang.Math");
    Constructor[] cons = cl.getConstructors();
    for(Constructor con : cons) {
        Class[] params = con.getParameterTypes();

        // stampo specifiche di istanza e nome dei costruttori
        System.out.println(con.getModifiers() + " " + con.getName() + " ( ");

        // stampo i tipi dei parametri
        for(Class param : params)
            System.out.print(param.getName() + " ");

        System.out.println(")");
    }
    System.exit(0);
}

/*
Esercizio 3
Possibile deadlock in metodo transfer nel caso 2 conti 
cerchino di trasferire denaro uno verso l'altro

Rendere metodo transfer o intero array account synchronized 
*/