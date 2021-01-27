package com.company;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Impresora {
    private static final Semaphore impresora = new Semaphore(1, true);
    private static Ordenadores ordenador;
    static final int TIEMPOIMPRESION = 5000;
    static final int PROCESAMIENTOMINIMO = 3000;
    static final int PROCESAMIENTOMAXIMO = 5000-PROCESAMIENTOMINIMO;

    public Impresora() {
    }


    public static void procesamiento(Ordenadores ordenador) throws  InterruptedException{
        impresora.acquire();
        boolean aux = false;
        Random r = new Random();
        System.out.println("Comienza el procesamiento de " + ordenador.getNombre());
        Thread.sleep(r.nextInt(PROCESAMIENTOMAXIMO)+PROCESAMIENTOMINIMO);
        aux = ordenador.docProcesado();
        if(aux){
            System.out.println("Proceso completado con exito");
        } else System.out.println("Proceso no completado con exito");
        impresora.release();
    }

    public static void impresión(Ordenadores ordenador) throws InterruptedException {
        impresora.acquire();
        System.out.println("Comienza la impresión de " + ordenador.getNombre());
        Thread.sleep(TIEMPOIMPRESION);
        System.out.println("IMPRESO");
        impresora.release();
        ordenador.interrupt();
    }


}