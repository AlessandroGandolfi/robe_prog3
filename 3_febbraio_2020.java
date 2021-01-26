/* 
Esercizio 1

Non gestisce la stampante in modo giusto, bisognerebbe aggiungere synchronized 
al metodo stampa o all'istanza di st dentro il run
*/

/*
Esercizio 2
JR è un meccanismo molto potente fornito da
Java per analizzare le funzionalità delle classi, ad
esempio per ottenere a run-time informazioni su campi,
metodi, costruttori, ...
Si basa sui package java.lang.reflect (contenente le classi Constructor, Method e Field)
e la classe Class

per confrontare i tipi di 2 istanze
usare var istanceof Class per controllare tipo di una sola istanza
oppure
usare cl = var1.getClass() per avere la classe di cui var é istanza
usare cl.isIstance(var2) per vedere se é dello stesso tipo
*/

public class TestEsame {
    public static void main(String args[]) {
        Integer num = 3;
        String str = "aaaaaa";

        Class numCl = num.getClass();
        System.out.println("tipo di num: " + numCl.getName());
        System.out.println("tipo di str: " + str.getClass().getName());
        System.out.println("tipi di istanze uguali: " + numCl.isInstance(str));

        System.exit(0);
    }
}

// Esercizio 3 con stampe di A e B, B estende A