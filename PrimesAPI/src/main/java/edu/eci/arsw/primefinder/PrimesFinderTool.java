package edu.eci.arsw.primefinder;


import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class PrimesFinderTool {

    public static void main(String[] args) throws InterruptedException {

        int maxPrim = 1000;
        PrimesResultSet prs = new PrimesResultSet("john");
        BigInteger a = new BigInteger("1");
        BigInteger b = new BigInteger("27");
        Programa programa = new Programa(a, b, prs);
        programa.iniciar();
        System.out.println("Prime numbers found:");

       
        /**Thread t=new Thread() {
            @Override
            public void run() {
                while (!programa.getFinalizar()) {
                    try {
                        //check every 10ms if the idle status (10 seconds without mouse
                        //activity) was reached. 
                        Thread.sleep(10);
                        if (MouseMovementMonitor.getInstance().getTimeSinceLastMouseMovement() > 1000) {
                            programa.setPausa(true);
                            System.out.println("Idle CPU ");
                        } else {
                            programa.iniciar();
                            System.out.println("User working again!");
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PrimesFinderTool.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }
        };
        t.start();
        t.join();*/
        System.out.println(prs.getPrimes());

    }

}
