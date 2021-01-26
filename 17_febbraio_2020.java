/*
Esercizio 1
L'utente non puó far cambiare "andamento" al contatore perché
il thread dove é presente il listener del pulsante onOff
rimane loopato nel while(true) del listener del pulsante Start
*/
public class Contatore extends JFrame {
    private boolean runFlag;
    private JButton onOff;
    private JButton start;

    public Contatore() {
        runFlag = true;
        setLayout(new FlowLayout());
        onOff = new JButton("INCR-DECR");
        add(onOff);
        onOff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                runFlag = !runFlag;
            }
        });

        start = new JButton("START");
        add(start);
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                start.setEnabled(false); // disabilita il bottone
                StartThread st = new StartThread();
                st.start();
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack(); 
        setVisible(true);
    }

    public class StartThread extends Thread {
        public void run() {
            int count = 0;
            while (true) {
                try {
                    Thread.sleep(500);
                } catch(InterruptedException e)
                {System.out.println(e.getMessage());}
                if (runFlag)
                    count++;
                else count--;
                System.out.println(count);
            }
        }
    }
    public static void main(String args[]) {
        Contatore f = new Contatore();
    }
}

/*
Esercizio 2
Nella programmazione ad eventi l'utente interagisce con il programma
cambiandone lo stato e le istruzioni da eseguire. L'esecuzione di un metodo 
effettivamente deve tenere conto di quello che sta succedendo in altre 
componenti del programma per continuare.
Differisce dalla programmazione sequenziale per quanto riguarda soprattutto
il concetto di stato, dato che nella programmazione sequenziale le istruzione
 vengono esuguite top-down, il codice é formato da sequenze finite
che devono essere eseguite "indipendentemente" da altre azioni in corso e 
l'utente non interagisce molto con il programma durante la sua esecuzione.

L'implementazione nelle GUI Java segue il pattern MVC
L'utente interagisce con la view, il controller in base alle azioni dell'utente
richiede delle elaborazioni dei dati al model che alla fine delle elaborazioni
puó trasmettere il risultato direttamente alla view oppure al controller che le
mostrerá in seguito alla view.
esempio di codice precedente ma meno complesso
*/

import java.util.*;
    public class CoppiaApp {
    public static void main(String args[]) {
        Coppia<String, Date> cop1 = new Coppia<String, Date>("Uno", new Date());
        Coppia<String, Date> cop2 = new Coppia<String, Date>("Due", new Date());

        System.out.println(cop1.toString() + " - " + cop2.toString());
    }
}

class Coppia <T, E> {
    private T x;
    private E y;

    public Coppia(T x, E y) {
        this.x = x;
        this.y = y;
    }

    public T getComp1() {
        return this.x;
    }

    public E getComp2() {
        return this.y;
    }

    public String toString() {
        return x + ", " + y;  
    }
}