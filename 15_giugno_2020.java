import java.util.ArrayList;

// Esercizio 1

public class PlayList {
    private ArrayList<Integer> pl;

    public PlayList() {
        this.pl = new ArrayList<>();
    }

    public synchronized boolean add(Integer newTrack) {
        if(this.pl != null 
            && this.pl.size() < 10
            && !(this.pl.contains(newTrack))) {
            this.pl.add(newTrack);

            return true;
        }
        return false;
    }

    public synchronized void print() {
        for (int i = 0; i < this.pl.size(); i++)
            System.out.println(this.pl.get(i));
    }

    public static void main(String[] args) {
        PlayList pl = new PlayList();
        pl.add(23);
        pl.add(21);
        pl.add(10);
        pl.print();
    }
}

// Esercizio 2

public class Util {
    public static void main(String[] args) {
        Integer int1 = 4;
        Integer int2 = 6;

        System.out.println("il massimo tra 4 e 6 é " + max(int1, int2));
    }

    public static <T extends Comparable<T>> T max(T t1, T t2) {
        T res = t1;

        if(t2 != null && t2.compareTo(t1) > 0)
            res = t2;

        return res;
    }
}