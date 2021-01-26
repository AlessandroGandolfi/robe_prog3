import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class Es3 {
    private static final int N = 3;
    public static void main(String[] args) {
        Numbers numeri = new Numbers(N);
        Ui ui = new Ui();
        numeri.addObserver(ui);
        (new NumberGenerator(numeri)).start();
    }
}

class NumberGenerator extends Thread {
    private Numbers nums;
    private Random r;
    public NumberGenerator(Numbers numeri) {
        nums = numeri;
        r = new Random();
    }
    public void run() {
        int[] valori = new int[nums.getLength()];
        for (int i = 1; i < 10; i++) {
            for (int index =0; index<nums.getLength(); index++)
                valori[index] = r.nextInt(5);
            nums.setNumbers(valori);
            try {sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) {return;}
        }
    }
}

class Numbers extends Observable {
    private final int[] items;
    public Numbers (int n) {
        items = new int[n];
    }

    public int getLength() {
        return items.length;
    }

    public void setNumbers(int[] values) {
        int[] copia = new int[items.length];
        synchronized (items){
            for (int i=0; i<items.length; i++)
                items[i] = values[i];
            for (int i=0; i<items.length; i++)
                copia[i] = items[i];
        }
        setChanged();
        notifyObservers(copia);
    }
}

class Ui implements Observer {
    public void update (Observable o, Object extra_args) {
        if (o != null && o instanceof Numbers) {
            synchronized (this) {
                int[] items = (int[]) extra_args;
                for (int i = 0; i < items.length; i++)
                    System.out.print(items[i] + "\t");
                System.out.println();
                int i = 0;
                while (i < items.length - 1 && items[i] == items[i + 1])
                    i++;
                if (i >= items.length - 1)
                    System.out.println("TUTTI UGUALI!!!!");
            }
        }
    }
}

