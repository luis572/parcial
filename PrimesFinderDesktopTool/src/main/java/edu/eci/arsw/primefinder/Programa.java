/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.primefinder;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 2137497
 */
public class Programa {

    BigInteger a;
    BigInteger b;
    BigInteger rango;
    static PrimesResultSet prs;
    public static boolean pausa;
    ArrayList<PrimeFinder> listF;
    public boolean finalizar;

    public Programa(BigInteger _a, BigInteger _b, PrimesResultSet prs) throws InterruptedException {
        listF = new ArrayList<>();
        a = _a;
        b = _b;
        pausa = false;
        PrimeFinder.prs = prs;
        rango = b.subtract(a).divide(BigInteger.valueOf(4));
        finalizar = false;
        rango.divide(BigInteger.valueOf(4));
        BigInteger contador = a;
        for (int i = 0; i < 3; i++) {
            listF.add(new PrimeFinder(contador, contador.add(rango), prs));
            contador = contador.add(rango);
            contador = contador.add(BigInteger.valueOf(1));
        }
        BigInteger limite = b.subtract(contador);
        listF.add(new PrimeFinder(contador, contador.add(limite), prs));
        for (PrimeFinder e : listF) {
            e.start();
        }
        for (PrimeFinder e : listF) {
            e.join();
        }

    }

    public void iniciar() throws InterruptedException {
        
        pausa = false;
    }

    public void setPausa(boolean p) {
        if (p == true) {
            for (PrimeFinder e : listF) {
                e.suspend();
                pausa = p;
            }

        } 
    }

    public boolean getFinalizar() {
        boolean todos = true;
        for (PrimeFinder e : listF) {
            if (!e.isAlive()) {
                todos = false;
                break;
            }

        }
        if (todos) {
            finalizar = true;
        }
        return finalizar;
    }
}
