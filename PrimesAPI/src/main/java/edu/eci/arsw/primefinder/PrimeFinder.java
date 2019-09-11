package edu.eci.arsw.primefinder;

import edu.eci.arsw.math.MathUtilities;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PrimeFinder extends Thread {
BigInteger a;
BigInteger b ;
static PrimesResultSet  prs;
    @Override
    public void run() {
        
         MathUtilities mt = new MathUtilities();

        int itCount = 0;

        BigInteger i = a;
       
        while (i.compareTo(b) <= 0) {
            itCount++;
            if (mt.isPrime(i)) {
                prs.addPrime(i);
                 
            }
            System.out.println("edu.eci.arsw.primefinder.PrimeFinder.findPrimes()");
            i = i.add(BigInteger.ONE);
        }
    }

    public   PrimeFinder(BigInteger _a, BigInteger _b, PrimesResultSet prs) {
         a = _a;
         b = _b;
        PrimeFinder.prs=prs;
    }

    

}
