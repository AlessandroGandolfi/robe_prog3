/*
Esercizio 1

{[c1, c2, p1, p2], [], false}
{[c2, p1, p2], [c1], false}
{[p1, p2], [c1, c2], false}
{[p2, c1], [c2], true}
{[c1], [c2, p2], true}
{[c2], [p2], false}
{[], [p2, c2], false}
*/

// Esercizio 2

abstract class Poligono {
    private int nVertici;
    private int base;
    private int altezza;
    private static int nPoligoni = 0;

    public Poligono(int v, int b, int a) {
        this.nVertici = v;
        this.base = b;
        this.altezza = a;
        nPoligoni++;
    }

    public int getBase() {
        return this.base;
    }

    public int getAltezza() {
        return this.altezza;
    }

    public int getNumLati() {
        return this.nVertici;
    }

    public abstract double getArea();

    public int getNumPoligoni() {
        return this.nPoligoni;
    }
}

class Rettangolo extends Poligono {
    public Rettangolo(int b, int a) {
        super(4, b, a);
    }

    public double getArea() {
        return getBase() * getAltezza();
    }
}

class Quadrato extends Rettangolo {
    public Quadrato(int l) {
        super(l, l);
    }
}