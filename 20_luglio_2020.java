// Esercizio 1

public class Concurrence extends Thread {
    private Integer i;

    public Concurrence(Integer o) {
        i = o;
    }

    public void run() {
        synchronized(i) {
            for (int j=0; j<3; j++) {
                int val = i.intValue();
                val++;
                i = Integer.valueOf(val);
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Integer number = Integer.valueOf(0);
        Concurrence first = new Concurrence(number);
        Concurrence second = new Concurrence(number);
        first.start();
        second.start();
    }
}

// Esercizio 2

public class Util2 {
    public static void main(String[] args) {
        System.out.println("string istanze uguali: " + uguali("brrrrr", "rrbrr"));
        System.out.println("integer istanze uguali: " + uguali(3, 3));
    }

    public static <T> boolean uguali(T t1, T t2) {
        return t1 == t2;
    }
}