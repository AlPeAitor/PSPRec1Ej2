package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        for(int i=0;i<11;i++){
            Ordenadores o = new Ordenadores();
            o.setNombre("Ordenador "+ (i+1));
            o.start();
        }
    }
}
