package com.company;

import java.util.Random;

public class Ordenadores extends Thread{


    public Ordenadores() {

    }

    private String nombre = "";
    Random r = new Random();
    boolean procesado = false;
    public void run(){

        try{

            while(!docProcesado()) {
                Impresora.procesamiento(this);
            }

            if(docProcesado()){
                Impresora.impresión(this);
            }

        }catch (InterruptedException var9) {
            var9.printStackTrace();
        }
    }

    public void setNombre(String x){
        this.nombre = x;
    }

    public String getNombre(){
        return nombre;
    }

    public boolean docProcesado(){
        return r.nextInt(2)==1;
    }
}
